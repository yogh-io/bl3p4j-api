package io.yogh.bl3p.api.v1;

import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.concurrent.Future;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.body.RequestBodyEntity;

import io.yogh.bl3p.api.v1.request.ApiCall;
import io.yogh.bl3p.api.v1.request.authenticated.RequestUriBuilder;
import io.yogh.bl3p.api.v1.response.exception.Bl3pException;
import io.yogh.bl3p.api.v1.response.exception.Bl3pException.Reason;

public final class Bl3pClientRequestUtil {
  private static final Logger LOG = LoggerFactory.getLogger(Bl3pClientRequestUtil.class);

  private static final String HOST = "https://api.bl3p.eu/1/";

  private Bl3pClientRequestUtil() {}

  public static JsonNode doAuthenticatedCall(final String uuid, final String key, final ApiCall call) throws Bl3pException {
    try {
      return createAuthenticatedCall(uuid, key, call).asJson().getBody();
    } catch (final UnirestException e) {
      LOG.error("Failure while executing request.", call, e);
      throw new Bl3pException(Reason.UNSPECIFIED_CLIENT_ERROR, e.getMessage(), e);
    }
  }

  public static Future<HttpResponse<JsonNode>> doCallAsync(final String uuid, final String key, final ApiCall call) {
    return createAuthenticatedCall(uuid, key, call).asJsonAsync();
  }

  public static void doAuthenticatedCallAsync(final String uuid, final String key, final Callback<JsonNode> complete, final ApiCall call) {
    createAuthenticatedCall(uuid, key, call).asJsonAsync(complete);
  }

  public static JsonNode doPublicCall(final ApiCall call) throws Bl3pException {
    try {
      return createPublicCall(call).asJson().getBody();
    } catch (final UnirestException e) {
      LOG.error("Failure while executing request.", call, e);
      throw new Bl3pException(Reason.UNSPECIFIED_CLIENT_ERROR, e.getMessage(), e);
    }
  }

  public static void doPublicCallAsync(final Callback<JsonNode> complete, final ApiCall call) {
    createPublicCall(call).asJsonAsync(complete);
  }

  private static RequestBodyEntity createAuthenticatedCall(final String uuid, final String key, final ApiCall call) {
    try {
      final String uri = RequestUriBuilder.getUri(call);
      final String post = RequestUriBuilder.getPostData(call);

      final StringBuilder commit = new StringBuilder();
      commit.append(uri);
      commit.append('\u0000');
      commit.append(post);

      final Mac HMAC = Mac.getInstance("HmacSHA512");
      final SecretKeySpec secretKey = new SecretKeySpec(Base64.getDecoder().decode(key), "HmacSHA512");
      HMAC.init(secretKey);
      final byte[] macData = HMAC.doFinal(commit.toString().getBytes(Charset.forName("ASCII")));

      return Unirest.post(HOST + uri)
          .header("Rest-Key", uuid)
          .header("Rest-Sign", Base64.getEncoder().encodeToString(macData))
          .body(post);
    } catch (final NoSuchAlgorithmException | InvalidKeyException e) {
      throw new RuntimeException("Unrecoverable error relating to signing requests.", e);
    }
  }

  private static GetRequest createPublicCall(final ApiCall call) {
    final StringBuilder builder = new StringBuilder(HOST);
    builder.append(RequestUriBuilder.getUri(call));

    final String post = RequestUriBuilder.getPostData(call);
    if (post != null && !post.isEmpty()) {
      builder.append("?");
      builder.append(post);
    }

    return Unirest.get(builder.toString());
  }
}

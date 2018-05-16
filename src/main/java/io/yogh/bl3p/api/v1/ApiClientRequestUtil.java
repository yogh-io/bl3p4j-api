package io.yogh.bl3p.api.v1;

import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.concurrent.Future;
import java.util.function.Consumer;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.body.RequestBodyEntity;

import io.yogh.bl3p.api.v1.request.ApiCall;
import io.yogh.bl3p.api.v1.request.RequestUriBuilder;
import io.yogh.bl3p.api.v1.response.exception.Bl3pException;
import io.yogh.bl3p.api.v1.response.exception.Bl3pException.Reason;

public final class ApiClientRequestUtil {
  private static final Logger LOG = LoggerFactory.getLogger(ApiClientRequestUtil.class);

  private static final String HOST = "https://api.bl3p.eu/1/";

  private ApiClientRequestUtil() {}

  public static JsonNode doCall(final String uuid, final String key, final ApiCall call) throws Bl3pException {
    try {
      return createCall(uuid, key, call).asJson().getBody();
    } catch (final UnirestException e) {
      LOG.error("Failure while executing request.", call, e);
      throw new Bl3pException(Reason.UNSPECIFIED_CLIENT_ERROR, e.getMessage(), e);
    }
  }

  public static Future<HttpResponse<JsonNode>> doCallAsync(final String uuid, final String key, final ApiCall call) {
    return createCall(uuid, key, call).asJsonAsync();
  }

  public static void doCallAsync(final String uuid, final String key, final ApiCall call, final Callback<JsonNode> complete) {
    createCall(uuid, key, call).asJsonAsync(complete);
  }

  /**
   * This method does not report back any errors and as such should not be used in
   * the common case.
   */
  public static void doCallAsyncNaive(final String uuid, final String key, final ApiCall call, final Consumer<JsonNode> complete) {
    createCall(uuid, key, call).asJsonAsync(new Callback<JsonNode>() {
      @Override
      public void completed(final HttpResponse<JsonNode> response) {
        complete.accept(response.getBody());
      }

      @Override
      public void failed(final UnirestException e) {
        LOG.error("Failure while executing request.", call, e);
      }

      @Override
      public void cancelled() {
        LOG.warn("Request cancelled.", call);
      }
    });
  }

  private static RequestBodyEntity createCall(final String uuid, final String key, final ApiCall call) {
    try {
      final String uri = RequestUriBuilder.getUri(call);
      final String post = RequestUriBuilder.getPostData(call);

      final StringBuilder commit = new StringBuilder();
      commit.append(uri);
      commit.append('\u0300');
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
}

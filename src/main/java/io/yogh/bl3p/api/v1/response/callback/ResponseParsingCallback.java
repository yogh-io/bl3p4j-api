package io.yogh.bl3p.api.v1.response.callback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;

import io.yogh.bl3p.api.v1.response.AsyncCallback;
import io.yogh.bl3p.api.v1.response.parser.Parser;

public class ResponseParsingCallback<T> implements Callback<JsonNode> {
  private static final Logger LOG = LoggerFactory.getLogger(ResponseParsingCallback.class);

  private final Parser<T> parser;
  private final AsyncCallback<T> callback;

  public ResponseParsingCallback(final Parser<T> parser, final AsyncCallback<T> callback) {
    this.parser = parser;
    this.callback = callback;
  }

  public static <T> ResponseParsingCallback<T> create(final Parser<T> parser, final AsyncCallback<T> callback) {
    return new ResponseParsingCallback<T>(parser, callback);
  }

  @Override
  public void completed(final HttpResponse<JsonNode> response) {
    final T result;
    try {
      // Don't pass to onSuccess here because that might throw an exception which
      // would get caught in this clause, which is out of scope for this callback
      result = parser.parse(response.getBody());
    } catch (final Exception e) {
      callback.onFailure(e);
      return;
    }

    callback.onSuccess(result);
  }

  @Override
  public void failed(final UnirestException e) {
    // This error is more severe than a response error, so do some logging.
    LOG.error("Error while executing the request.", e);
    callback.onFailure(e);
  }

  @Override
  public void cancelled() {
    LOG.warn("Request cancelled.");
  }
}

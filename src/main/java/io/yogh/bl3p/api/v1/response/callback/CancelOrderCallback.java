package io.yogh.bl3p.api.v1.response.callback;

import io.yogh.bl3p.api.v1.response.AsyncCallback;
import io.yogh.bl3p.api.v1.response.domain.CancelOrderResponse;
import io.yogh.bl3p.api.v1.response.parser.CancelOrderResponseParser;
import io.yogh.bl3p.api.v1.response.parser.Parser;

public class CancelOrderCallback extends ResponseParsingCallback<CancelOrderResponse> {
  public CancelOrderCallback(final Parser<CancelOrderResponse> parser, final AsyncCallback<CancelOrderResponse> callback) {
    super(parser, callback);
  }

  public static CancelOrderCallback create(final AsyncCallback<CancelOrderResponse> callback) {
    return new CancelOrderCallback(new CancelOrderResponseParser(), callback);
  }
}

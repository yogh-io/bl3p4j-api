package io.yogh.bl3p.api.v1.response.callback;

import io.yogh.bl3p.api.v1.response.AsyncCallback;
import io.yogh.bl3p.api.v1.response.domain.RetrieveOrderResponse;
import io.yogh.bl3p.api.v1.response.parser.Parser;
import io.yogh.bl3p.api.v1.response.parser.RetrieveOrderResponseParser;

public class RetrieveOrderCallback extends ResponseParsingCallback<RetrieveOrderResponse> {
  public RetrieveOrderCallback(final Parser<RetrieveOrderResponse> parser, final AsyncCallback<RetrieveOrderResponse> callback) {
    super(parser, callback);
  }

  public static RetrieveOrderCallback create(final AsyncCallback<RetrieveOrderResponse> callback) {
    return new RetrieveOrderCallback(new RetrieveOrderResponseParser(), callback);
  }
}

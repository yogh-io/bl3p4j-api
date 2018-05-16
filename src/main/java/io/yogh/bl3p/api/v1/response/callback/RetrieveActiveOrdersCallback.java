package io.yogh.bl3p.api.v1.response.callback;

import io.yogh.bl3p.api.v1.response.AsyncCallback;
import io.yogh.bl3p.api.v1.response.domain.RetrieveActiveOrdersResponse;
import io.yogh.bl3p.api.v1.response.parser.Parser;
import io.yogh.bl3p.api.v1.response.parser.RetrieveActiveOrdersResponseParser;

public class RetrieveActiveOrdersCallback extends ResponseParsingCallback<RetrieveActiveOrdersResponse> {
  public RetrieveActiveOrdersCallback(final Parser<RetrieveActiveOrdersResponse> parser, final AsyncCallback<RetrieveActiveOrdersResponse> callback) {
    super(parser, callback);
  }

  public static RetrieveActiveOrdersCallback create(final AsyncCallback<RetrieveActiveOrdersResponse> callback) {
    return new RetrieveActiveOrdersCallback(new RetrieveActiveOrdersResponseParser(), callback);
  }
}

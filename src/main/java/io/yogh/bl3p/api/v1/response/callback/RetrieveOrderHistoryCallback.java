package io.yogh.bl3p.api.v1.response.callback;

import io.yogh.bl3p.api.v1.response.AsyncCallback;
import io.yogh.bl3p.api.v1.response.domain.RetrieveOrderHistoryResponse;
import io.yogh.bl3p.api.v1.response.parser.Parser;
import io.yogh.bl3p.api.v1.response.parser.RetrieveOrderHistoryResponseParser;

public class RetrieveOrderHistoryCallback extends ResponseParsingCallback<RetrieveOrderHistoryResponse> {
  public RetrieveOrderHistoryCallback(final Parser<RetrieveOrderHistoryResponse> parser, final AsyncCallback<RetrieveOrderHistoryResponse> callback) {
    super(parser, callback);
  }

  public static RetrieveOrderHistoryCallback create(final AsyncCallback<RetrieveOrderHistoryResponse> callback) {
    return new RetrieveOrderHistoryCallback(new RetrieveOrderHistoryResponseParser(), callback);
  }
}

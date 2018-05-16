package io.yogh.bl3p.api.v1.response.callback;

import io.yogh.bl3p.api.v1.response.AsyncCallback;
import io.yogh.bl3p.api.v1.response.domain.RetrieveTransactionHistoryResponse;
import io.yogh.bl3p.api.v1.response.parser.Parser;
import io.yogh.bl3p.api.v1.response.parser.RetrieveTransactionHistoryResponseParser;

public class RetrieveTransactionHistoryCallback extends ResponseParsingCallback<RetrieveTransactionHistoryResponse> {
  public RetrieveTransactionHistoryCallback(final Parser<RetrieveTransactionHistoryResponse> parser,
      final AsyncCallback<RetrieveTransactionHistoryResponse> callback) {
    super(parser, callback);
  }

  public static RetrieveTransactionHistoryCallback create(final AsyncCallback<RetrieveTransactionHistoryResponse> callback) {
    return new RetrieveTransactionHistoryCallback(new RetrieveTransactionHistoryResponseParser(), callback);
  }
}

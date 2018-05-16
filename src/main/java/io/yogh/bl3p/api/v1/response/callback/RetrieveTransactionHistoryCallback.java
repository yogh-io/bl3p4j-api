package io.yogh.bl3p.api.v1.response.callback;

import io.yogh.bl3p.api.v1.response.AsyncCallback;
import io.yogh.bl3p.api.v1.response.domain.TransactionHistory;
import io.yogh.bl3p.api.v1.response.parser.Parser;
import io.yogh.bl3p.api.v1.response.parser.TransactionHistoryParser;

public class RetrieveTransactionHistoryCallback extends ResponseParsingCallback<TransactionHistory> {
  public RetrieveTransactionHistoryCallback(final Parser<TransactionHistory> parser,
      final AsyncCallback<TransactionHistory> callback) {
    super(parser, callback);
  }

  public static RetrieveTransactionHistoryCallback create(final AsyncCallback<TransactionHistory> callback) {
    return new RetrieveTransactionHistoryCallback(new TransactionHistoryParser(), callback);
  }
}

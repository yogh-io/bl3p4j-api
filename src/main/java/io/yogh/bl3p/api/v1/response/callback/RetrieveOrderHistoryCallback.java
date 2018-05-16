package io.yogh.bl3p.api.v1.response.callback;

import io.yogh.bl3p.api.v1.response.AsyncCallback;
import io.yogh.bl3p.api.v1.response.domain.OrderHistory;
import io.yogh.bl3p.api.v1.response.parser.Parser;
import io.yogh.bl3p.api.v1.response.parser.OrderHistoryParser;

public class RetrieveOrderHistoryCallback extends ResponseParsingCallback<OrderHistory> {
  public RetrieveOrderHistoryCallback(final Parser<OrderHistory> parser, final AsyncCallback<OrderHistory> callback) {
    super(parser, callback);
  }

  public static RetrieveOrderHistoryCallback create(final AsyncCallback<OrderHistory> callback) {
    return new RetrieveOrderHistoryCallback(new OrderHistoryParser(), callback);
  }
}

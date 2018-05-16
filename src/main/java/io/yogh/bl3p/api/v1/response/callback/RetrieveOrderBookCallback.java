package io.yogh.bl3p.api.v1.response.callback;

import io.yogh.bl3p.api.v1.response.AsyncCallback;
import io.yogh.bl3p.api.v1.response.domain.OrderBook;
import io.yogh.bl3p.api.v1.response.parser.Parser;
import io.yogh.bl3p.api.v1.response.parser.OrderBookParser;

public class RetrieveOrderBookCallback extends ResponseParsingCallback<OrderBook> {
  public RetrieveOrderBookCallback(final Parser<OrderBook> parser, final AsyncCallback<OrderBook> callback) {
    super(parser, callback);
  }

  public static RetrieveOrderBookCallback create(final AsyncCallback<OrderBook> callback) {
    return new RetrieveOrderBookCallback(OrderBookParser.create(), callback);
  }
}

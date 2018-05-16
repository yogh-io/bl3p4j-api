package io.yogh.bl3p.api.v1.response.callback;

import io.yogh.bl3p.api.v1.response.AsyncCallback;
import io.yogh.bl3p.api.v1.response.domain.OrderInfo;
import io.yogh.bl3p.api.v1.response.parser.Parser;
import io.yogh.bl3p.api.v1.response.parser.OrderParser;

public class RetrieveOrderCallback extends ResponseParsingCallback<OrderInfo> {
  public RetrieveOrderCallback(final Parser<OrderInfo> parser, final AsyncCallback<OrderInfo> callback) {
    super(parser, callback);
  }

  public static RetrieveOrderCallback create(final AsyncCallback<OrderInfo> callback) {
    return new RetrieveOrderCallback(OrderParser.create(), callback);
  }
}

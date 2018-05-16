package io.yogh.bl3p.api.v1.response.callback;

import java.util.List;

import io.yogh.bl3p.api.v1.response.AsyncCallback;
import io.yogh.bl3p.api.v1.response.domain.OrderInfo;
import io.yogh.bl3p.api.v1.response.parser.Parser;
import io.yogh.bl3p.api.v1.response.parser.ActiveOrdersParser;

public class RetrieveActiveOrdersCallback extends ResponseParsingCallback<List<OrderInfo>> {
  public RetrieveActiveOrdersCallback(final Parser<List<OrderInfo>> parser, final AsyncCallback<List<OrderInfo>> callback) {
    super(parser, callback);
  }

  public static RetrieveActiveOrdersCallback create(final AsyncCallback<List<OrderInfo>> callback) {
    return new RetrieveActiveOrdersCallback(new ActiveOrdersParser(), callback);
  }
}

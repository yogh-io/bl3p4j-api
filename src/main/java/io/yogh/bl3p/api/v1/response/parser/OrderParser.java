package io.yogh.bl3p.api.v1.response.parser;

import com.mashape.unirest.http.JsonNode;

import io.yogh.bl3p.api.v1.response.domain.OrderInfo;
import io.yogh.bl3p.api.v1.response.exception.Bl3pException;

public class OrderParser extends ResultParser implements Parser<OrderInfo> {
  @Override
  public OrderInfo parse(final JsonNode t) throws Bl3pException {
    return CommonParser.parseOrder(getDataNode(t));
  }

  public static OrderParser create() {
    return new OrderParser();
  }
}

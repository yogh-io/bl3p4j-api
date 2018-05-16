package io.yogh.bl3p.api.v1.response.parser;

import com.mashape.unirest.http.JsonNode;

import io.yogh.bl3p.api.v1.response.exception.Bl3pException;

public class CreateOrderParser extends ResultParser implements Parser<Integer> {
  @Override
  public Integer parse(final JsonNode t) throws Bl3pException {
    return getDataNode(t).getInt("order_id");
  }

  public static CreateOrderParser create() {
    return new CreateOrderParser();
  }
}

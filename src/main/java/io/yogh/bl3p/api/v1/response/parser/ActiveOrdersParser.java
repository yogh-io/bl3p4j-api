package io.yogh.bl3p.api.v1.response.parser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.JsonNode;

import io.yogh.bl3p.api.v1.response.domain.OrderInfo;
import io.yogh.bl3p.api.v1.response.exception.Bl3pException;

public class ActiveOrdersParser extends ResultParser implements Parser<List<OrderInfo>> {
  @Override
  public List<OrderInfo> parse(final JsonNode t) throws Bl3pException {
    final JSONObject data = getDataNode(t);

    final JSONArray ordersJson = data.getJSONArray("orders");
    final List<OrderInfo> orders = new ArrayList<>();

    for (int i = 0; i < ordersJson.length(); i++) {
      orders.add(CommonParser.parseOrder(ordersJson.getJSONObject(i)));
    }

    return orders;
  }

  public static ActiveOrdersParser create() {
    return new ActiveOrdersParser();
  }
}

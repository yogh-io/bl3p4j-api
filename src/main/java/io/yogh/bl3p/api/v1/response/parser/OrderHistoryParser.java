package io.yogh.bl3p.api.v1.response.parser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.JsonNode;

import io.yogh.bl3p.api.v1.response.domain.OrderHistory;
import io.yogh.bl3p.api.v1.response.domain.OrderInfo;
import io.yogh.bl3p.api.v1.response.exception.Bl3pException;

public class OrderHistoryParser extends ResultParser implements Parser<OrderHistory> {
  @Override
  public OrderHistory parse(final JsonNode t) throws Bl3pException {
    final JSONObject data = getDataNode(t);

    final OrderHistory history = new OrderHistory();

    CommonParser.parsePagedResponse(history, data);

    final JSONArray ordersJson = data.getJSONArray("orders");
    final List<OrderInfo> orders = new ArrayList<>();

    for (int i = 0; i < ordersJson.length(); i++) {
      orders.add(CommonParser.parseOrder(ordersJson.getJSONObject(i)));
    }

    history.setOrders(orders);

    return history;
  }

  public static OrderHistoryParser create() {
    return new OrderHistoryParser();
  }
}

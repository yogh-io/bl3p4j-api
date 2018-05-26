package io.yogh.bl3p.api.v1.response.websocket;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import io.yogh.bl3p.api.v1.response.domain.OrderBook;
import io.yogh.bl3p.api.v1.response.domain.SimpleOrder;
import io.yogh.bl3p.api.v1.response.parser.CommonParser;

public class OrderBookResponseParser implements StringJsonParser<OrderBook> {
  @Override
  public OrderBook apply(final String text) {
    final JSONObject data = new JSONObject(text);

    final OrderBook orderBook = new OrderBook();

    final List<SimpleOrder> bids = new ArrayList<>();
    final JSONArray bidsJson = data.getJSONArray("bids");
    for (int i = 0; i < bidsJson.length(); i++) {
      bids.add(CommonParser.parseSimpleOrder(bidsJson.getJSONObject(i)));
    }

    final List<SimpleOrder> asks = new ArrayList<>();
    final JSONArray asksJson = data.getJSONArray("asks");
    for (int i = 0; i < asksJson.length(); i++) {
      asksJson.get(i);
      asks.add(CommonParser.parseSimpleOrder(asksJson.getJSONObject(i)));
    }

    orderBook.setBids(bids);
    orderBook.setAsks(asks);

    return orderBook;
  }

  public static OrderBookResponseParser create() {
    return new OrderBookResponseParser();
  }
}

package io.yogh.bl3p.api.v1.response.parser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.JsonNode;

import io.yogh.bl3p.api.v1.response.domain.OrderBook;
import io.yogh.bl3p.api.v1.response.domain.SimpleOrder;
import io.yogh.bl3p.api.v1.response.exception.Bl3pException;

public class OrderBookParser extends ResultParser implements Parser<OrderBook> {
  @Override
  public OrderBook parse(final JsonNode t) throws Bl3pException {
    final JSONObject data = getDataNode(t);

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

  public static OrderBookParser create() {
    return new OrderBookParser();
  }
}

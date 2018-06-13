package io.yogh.bl3p.api.v1.response.websocket;

import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

import io.yogh.bl3p.api.v1.response.domain.OrderBook;

public class OrderBookResponseCallback extends FeedForwarder<OrderBook> implements Consumer<String> {
  public OrderBookResponseCallback(final Set<Consumer<OrderBook>> subscribers, final Function<String, OrderBook> parser) {
    super(subscribers, parser);
  }

  public static OrderBookResponseCallback create(final Set<Consumer<OrderBook>> subscribers) {
    return new OrderBookResponseCallback(subscribers, OrderBookResponseParser.create());
  }

  @Override
  public String toString() {
    return "OrderBookResponseCallback []";
  }
}

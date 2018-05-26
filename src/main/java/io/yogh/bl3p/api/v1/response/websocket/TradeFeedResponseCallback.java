package io.yogh.bl3p.api.v1.response.websocket;

import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

import io.yogh.bl3p.api.v1.response.domain.TradeFeedInfo;

public class TradeFeedResponseCallback extends FeedForwarder<TradeFeedInfo> implements Consumer<String> {
  public TradeFeedResponseCallback(final Set<Consumer<TradeFeedInfo>> subscribers, final Function<String, TradeFeedInfo> parser) {
    super(subscribers, parser);
  }

  public static TradeFeedResponseCallback create(final Set<Consumer<TradeFeedInfo>> subscribers) {
    return new TradeFeedResponseCallback(subscribers, TradeFeedResponseParser.create());
  }
}

package io.yogh.bl3p.api.v1.response.websocket;

import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public class FeedForwarder<T> extends SubscriptionForwarder<T> implements Consumer<String> {
  private final Function<String, T> parser;

  public FeedForwarder(final Set<Consumer<T>> subscribers, final Function<String, T> parser) {
    super(subscribers);
    this.parser = parser;
  }

  @Override
  public void accept(final String text) {
    forward(parser.apply(text));
  }
}

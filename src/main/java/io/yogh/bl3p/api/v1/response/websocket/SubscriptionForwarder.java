package io.yogh.bl3p.api.v1.response.websocket;

import java.util.Set;
import java.util.function.Consumer;

public class SubscriptionForwarder<T> {
  private final Set<Consumer<T>> subscribers;

  public SubscriptionForwarder(final Set<Consumer<T>> subscribers) {
    this.subscribers = subscribers;
  }

  protected void forward(final T item) {
    subscribers.forEach(v -> v.accept(item));
  }
}

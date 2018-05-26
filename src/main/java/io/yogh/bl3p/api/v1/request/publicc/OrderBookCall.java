package io.yogh.bl3p.api.v1.request.publicc;

import io.yogh.bl3p.api.v1.request.ApiCall;
import io.yogh.bl3p.api.v1.request.domain.ApiCallType;

public class OrderBookCall extends ApiCall {
  private OrderBookCall(final Builder<?, ?> builder) {
    super(builder);
  }

  public static Builder<OrderBookCall, OrderBookCallBuilder> builder() {
    return new OrderBookCallBuilder()
        .call(ApiCallType.ORDERBOOK);
  }

  public abstract static class Builder<T extends ApiCall, B extends Builder<T, B>> extends ApiCall.Builder<T, B> {
    protected Builder() {}
  }

  public static class OrderBookCallBuilder extends Builder<OrderBookCall, OrderBookCallBuilder> {
    @Override
    public OrderBookCall build() {
      return new OrderBookCall(this);
    }

    @Override
    public OrderBookCallBuilder self() {
      return this;
    }
  }
}

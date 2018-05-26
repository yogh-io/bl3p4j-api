package io.yogh.bl3p.api.v1.request.publicc;

import io.yogh.bl3p.api.v1.request.ApiCall;
import io.yogh.bl3p.api.v1.request.domain.ApiCallType;

public class TickerCall extends ApiCall {
  private TickerCall(final Builder<?, ?> builder) {
    super(builder);
  }

  public static Builder<TickerCall, TickerCallBuilder> builder() {
    return new TickerCallBuilder()
        .call(ApiCallType.TICKER);
  }

  public abstract static class Builder<T extends ApiCall, B extends Builder<T, B>> extends ApiCall.Builder<T, B> {
    protected Builder() {}
  }

  public static class TickerCallBuilder extends Builder<TickerCall, TickerCallBuilder> {
    @Override
    public TickerCall build() {
      return new TickerCall(this);
    }

    @Override
    public TickerCallBuilder self() {
      return this;
    }
  }

}

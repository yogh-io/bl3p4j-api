package io.yogh.bl3p.api.v1.request.publicc;

import io.yogh.bl3p.api.v1.request.ApiCall;
import io.yogh.bl3p.api.v1.request.domain.ApiCallType;

public class Last1000TradesCall extends ApiCall {
  private Last1000TradesCall(final Builder<?, ?> builder) {
    super(builder);
  }

  public static Builder<Last1000TradesCall, Last1000TradesCallBuilder> builder() {
    return new Last1000TradesCallBuilder()
        .call(ApiCallType.TRADES_LAST_1000);
  }

  public abstract static class Builder<T extends ApiCall, B extends Builder<T, B>> extends ApiCall.Builder<T, B> {
    protected Builder() {}
  }

  public static class Last1000TradesCallBuilder extends Builder<Last1000TradesCall, Last1000TradesCallBuilder> {
    @Override
    public Last1000TradesCall build() {
      return new Last1000TradesCall(this);
    }

    @Override
    public Last1000TradesCallBuilder self() {
      return this;
    }
  }
}

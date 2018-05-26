package io.yogh.bl3p.api.v1.request.authenticated;

import io.yogh.bl3p.api.v1.request.ApiCall;
import io.yogh.bl3p.api.v1.request.domain.ApiCallType;
import io.yogh.bl3p.api.v1.request.domain.ApiSubCallType;
import io.yogh.bl3p.api.v1.request.domain.Namespace;

public final class RetrieveOrderBookCall extends ApiCall {
  private RetrieveOrderBookCall(final Builder<?, ?> builder) {
    super(builder);
  }

  public static Builder<RetrieveOrderBookCall, RetrieveOrderBookCallBuilder> builder() {
    return new RetrieveOrderBookCallBuilder()
        .namespace(Namespace.MONEY)
        .call(ApiCallType.DEPTH)
        .subcall(ApiSubCallType.FULL);
  }

  public abstract static class Builder<T extends ApiCall, B extends Builder<T, B>> extends ApiCall.Builder<T, B> {
    protected Builder() {}
  }

  public static class RetrieveOrderBookCallBuilder extends Builder<RetrieveOrderBookCall, RetrieveOrderBookCallBuilder> {
    @Override
    public RetrieveOrderBookCall build() {
      return new RetrieveOrderBookCall(this);
    }

    @Override
    public RetrieveOrderBookCallBuilder self() {
      return this;
    }
  }
}

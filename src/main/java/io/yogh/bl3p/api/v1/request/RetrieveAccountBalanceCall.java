package io.yogh.bl3p.api.v1.request;

import io.yogh.bl3p.api.v1.request.ApiCall.Builder;
import io.yogh.bl3p.api.v1.request.domain.ApiCallType;
import io.yogh.bl3p.api.v1.request.domain.Market;
import io.yogh.bl3p.api.v1.request.domain.Namespace;

public final class RetrieveAccountBalanceCall extends ApiCall {
  private RetrieveAccountBalanceCall(final Builder<?, ?> builder) {
    super(builder);
  }

  public static Builder<RetrieveAccountBalanceCall, RetrieveAccountBalanceCallBuilder> builder() {
    return new RetrieveAccountBalanceCallBuilder()
        .market(Market.GENMKT)
        .namespace(Namespace.MONEY)
        .call(ApiCallType.INFO);
  }

  public abstract static class Builder<T extends ApiCall, B extends Builder<T, B>> extends ApiCall.Builder<T, B> {
    protected Builder() {}
  }

  public static class RetrieveAccountBalanceCallBuilder extends Builder<RetrieveAccountBalanceCall, RetrieveAccountBalanceCallBuilder> {
    @Override
    public RetrieveAccountBalanceCall build() {
      return new RetrieveAccountBalanceCall(this);
    }

    @Override
    public RetrieveAccountBalanceCallBuilder self() {
      return this;
    }
  }
}

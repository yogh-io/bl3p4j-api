package io.yogh.bl3p.api.v1.request.authenticated;

import io.yogh.bl3p.api.v1.request.ApiCall;
import io.yogh.bl3p.api.v1.request.ApiCallNames;
import io.yogh.bl3p.api.v1.request.domain.ApiCallType;
import io.yogh.bl3p.api.v1.request.domain.ApiSubCallType;
import io.yogh.bl3p.api.v1.request.domain.Currency;
import io.yogh.bl3p.api.v1.request.domain.Namespace;

public final class RetrieveAllTradesCall extends ApiCall {
  private RetrieveAllTradesCall(final Builder<?, ?> builder) {
    super(builder);
    addRequestParameter(ApiCallNames.CURRENCY, builder.currency);
    addRequestParameter(ApiCallNames.TRADE_ID, builder.tradeId);
  }

  public static Builder<RetrieveAllTradesCall, RetrieveAllTradesCallBuilder> builder() {
    return new RetrieveAllTradesCallBuilder()
        .namespace(Namespace.MONEY)
        .call(ApiCallType.TRADES)
        .subcall(ApiSubCallType.FETCH);
  }

  public abstract static class Builder<T extends ApiCall, B extends Builder<T, B>> extends ApiCall.Builder<T, B> {
    private String currency;
    private int tradeId;

    protected Builder() {}

    public B tradeId(final int tradeId) {
      this.tradeId = tradeId;
      return self();
    }

    public B currency(final String currency) {
      this.currency = currency;
      return self();
    }

    public B currency(final Currency currency) {
      this.currency = currency.name();
      return self();
    }
  }

  public static class RetrieveAllTradesCallBuilder extends Builder<RetrieveAllTradesCall, RetrieveAllTradesCallBuilder> {
    @Override
    public RetrieveAllTradesCall build() {
      return new RetrieveAllTradesCall(this);
    }

    @Override
    public RetrieveAllTradesCallBuilder self() {
      return this;
    }
  }
}

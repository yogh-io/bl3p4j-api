package io.yogh.bl3p.api.v1.request;

import io.yogh.bl3p.api.v1.request.ApiCall.Builder;
import io.yogh.bl3p.api.v1.request.domain.ApiCallType;
import io.yogh.bl3p.api.v1.request.domain.Currency;
import io.yogh.bl3p.api.v1.request.domain.Market;
import io.yogh.bl3p.api.v1.request.domain.Namespace;

public final class RetrieveLastDepositAddressCall extends ApiCall {
  private RetrieveLastDepositAddressCall(final Builder<?, ?> builder) {
    super(builder);
    addRequestParameter(ApiCallNames.CURRENCY, builder.currency);
  }

  public static Builder<RetrieveLastDepositAddressCall, RetrieveLastDepositAddressCallBuilder> builder() {
    return new RetrieveLastDepositAddressCallBuilder()
        .market(Market.GENMKT)
        .namespace(Namespace.MONEY)
        .call(ApiCallType.DEPOSIT_ADDRESS);
  }

  public abstract static class Builder<T extends ApiCall, B extends Builder<T, B>> extends ApiCall.Builder<T, B> {
    private String currency;

    protected Builder() {}

    public B currency(final String currency) {
      this.currency = currency;
      return self();
    }

    public B currency(final Currency currency) {
      this.currency = currency.name();
      return self();
    }
  }

  public static class RetrieveLastDepositAddressCallBuilder extends Builder<RetrieveLastDepositAddressCall, RetrieveLastDepositAddressCallBuilder> {
    @Override
    public RetrieveLastDepositAddressCall build() {
      return new RetrieveLastDepositAddressCall(this);
    }

    @Override
    public RetrieveLastDepositAddressCallBuilder self() {
      return this;
    }
  }
}

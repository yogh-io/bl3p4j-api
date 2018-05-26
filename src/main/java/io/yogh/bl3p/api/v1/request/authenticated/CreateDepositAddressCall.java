package io.yogh.bl3p.api.v1.request.authenticated;

import io.yogh.bl3p.api.v1.request.ApiCall;
import io.yogh.bl3p.api.v1.request.ApiCallNames;
import io.yogh.bl3p.api.v1.request.domain.ApiCallType;
import io.yogh.bl3p.api.v1.request.domain.Currency;
import io.yogh.bl3p.api.v1.request.domain.Market;
import io.yogh.bl3p.api.v1.request.domain.Namespace;

public final class CreateDepositAddressCall extends ApiCall {
  private CreateDepositAddressCall(final Builder<CreateDepositAddressCall, CreateDepositAddressCallBuilder> builder) {
    super(builder);
    addRequestParameter(ApiCallNames.CURRENCY, builder.currency);
  }

  public static Builder<CreateDepositAddressCall, CreateDepositAddressCallBuilder> builder() {
    return new CreateDepositAddressCallBuilder()
        .market(Market.GENMKT)
        .namespace(Namespace.MONEY)
        .call(ApiCallType.NEW_DEPOSIT_ADDRESS);
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

  public static class CreateDepositAddressCallBuilder extends Builder<CreateDepositAddressCall, CreateDepositAddressCallBuilder> {
    @Override
    public CreateDepositAddressCall build() {
      return new CreateDepositAddressCall(this);
    }

    @Override
    public CreateDepositAddressCallBuilder self() {
      return this;
    }
  }
}

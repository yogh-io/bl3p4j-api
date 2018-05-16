package io.yogh.bl3p.api.v1.request;

import io.yogh.bl3p.api.v1.request.domain.ApiCallType;
import io.yogh.bl3p.api.v1.request.domain.Currency;
import io.yogh.bl3p.api.v1.request.domain.Market;
import io.yogh.bl3p.api.v1.request.domain.Namespace;

public final class CreateWithdrawalCall extends ApiCall {
  private CreateWithdrawalCall(final Builder<?, ?> builder) {
    super(builder);
    addRequestParameter(ApiCallNames.CURRENCY, builder.currency);
    addRequestParameter(ApiCallNames.ACCOUNT_ID, builder.accountId);
    addRequestParameter(ApiCallNames.ACCOUNT_NAME, builder.accountName);
    addRequestParameter(ApiCallNames.ADDRESS, builder.address);
    addRequestParameter(ApiCallNames.EXTRA_FEE, builder.extraFee);
    addRequestParameter(ApiCallNames.AMOUNT, builder.amount);
  }

  public static Builder<CreateWithdrawalCall, CreateWithdrawalCallBuilder> builder() {
    return new CreateWithdrawalCallBuilder()
        .market(Market.GENMKT)
        .namespace(Namespace.MONEY)
        .call(ApiCallType.DEPOSIT_ADDRESS);
  }

  public abstract static class Builder<T extends ApiCall, B extends Builder<T, B>> extends ApiCall.Builder<T, B> {
    private String currency;

    private String accountId;
    private String accountName;

    private String address;
    private int extraFee;

    private int amount;

    protected Builder() {}

    public B currency(final String currency) {
      this.currency = currency;
      return self();
    }

    public B currency(final Currency currency) {
      this.currency = currency.name();
      return self();
    }

    public B accountId(final String accountId) {
      this.accountId = accountId;
      return self();
    }

    public B accountName(final String accountName) {
      this.accountName = accountName;
      return self();
    }

    public B address(final String address) {
      this.address = address;
      return self();
    }

    /**
     * This will send the withdrawal as priority, extra fee will be charged (see
     * bl3p.eu)
     *
     * use 1 for extra fee
     */
    public B extraFee(final int extraFee) {
      this.extraFee = extraFee;
      return self();
    }

    /**
     * Satoshis or 0,00001 EUR
     */
    public B amount(final int amount) {
      this.amount = amount;
      return self();
    }
  }

  public static class CreateWithdrawalCallBuilder extends Builder<CreateWithdrawalCall, CreateWithdrawalCallBuilder> {
    @Override
    public CreateWithdrawalCall build() {
      return new CreateWithdrawalCall(this);
    }

    @Override
    public CreateWithdrawalCallBuilder self() {
      return this;
    }
  }
}

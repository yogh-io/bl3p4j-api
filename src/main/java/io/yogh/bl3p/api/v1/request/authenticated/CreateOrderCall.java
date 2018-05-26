package io.yogh.bl3p.api.v1.request.authenticated;

import io.yogh.bl3p.api.v1.request.ApiCall;
import io.yogh.bl3p.api.v1.request.ApiCallNames;
import io.yogh.bl3p.api.v1.request.domain.ApiCallType;
import io.yogh.bl3p.api.v1.request.domain.ApiSubCallType;
import io.yogh.bl3p.api.v1.request.domain.FeeCurrency;
import io.yogh.bl3p.api.v1.request.domain.Namespace;
import io.yogh.bl3p.api.v1.request.domain.OrderType;

public final class CreateOrderCall extends ApiCall {
  private CreateOrderCall(final Builder<?, ?> builder) {
    super(builder);
    addRequestParameter(ApiCallNames.TYPE, builder.type);
    addRequestParameter(ApiCallNames.AMOUNT, builder.amount);
    addRequestParameter(ApiCallNames.PRICE, builder.price);
    addRequestParameter(ApiCallNames.AMOUNT_FUNDS, builder.amountFunds);
    addRequestParameter(ApiCallNames.FEE_CURRENCY, builder.feeCurrency);
  }

  public static Builder<CreateOrderCall, CreateOrderCallBuilder> builder() {
    return new CreateOrderCallBuilder()
        .namespace(Namespace.MONEY)
        .call(ApiCallType.ORDER)
        .subcall(ApiSubCallType.ADD);
  }

  public abstract static class Builder<T extends ApiCall, B extends Builder<T, B>> extends ApiCall.Builder<T, B> {
    private String type;
    private Integer amount;
    private Integer price;
    private Integer amountFunds;
    private String feeCurrency;

    protected Builder() {}

    public B type(final OrderType type) {
      this.type = type.name();
      return self();
    }

    public B type(final String type) {
      this.type = type;
      return self();
    }

    public B amount(final Integer amount) {
      this.amount = amount;
      return self();
    }

    public B price(final Integer price) {
      this.price = price;
      return self();
    }

    public B amountFunds(final Integer amountFunds) {
      this.amountFunds = amountFunds;
      return self();
    }

    public B feeCurrency(final FeeCurrency feeCurrency) {
      this.feeCurrency = feeCurrency.name();
      return self();
    }

    public B feeCurrency(final String feeCurrency) {
      this.feeCurrency = feeCurrency;
      return self();
    }
  }

  public static class CreateOrderCallBuilder extends Builder<CreateOrderCall, CreateOrderCallBuilder> {
    @Override
    public CreateOrderCall build() {
      return new CreateOrderCall(this);
    }

    @Override
    public CreateOrderCallBuilder self() {
      return this;
    }
  }
}

package io.yogh.bl3p.api.v1.request;

import io.yogh.bl3p.api.v1.request.domain.ApiCallType;
import io.yogh.bl3p.api.v1.request.domain.ApiSubCallType;
import io.yogh.bl3p.api.v1.request.domain.Currency;
import io.yogh.bl3p.api.v1.request.domain.Market;
import io.yogh.bl3p.api.v1.request.domain.Namespace;
import io.yogh.bl3p.api.v1.request.domain.TransactionType;

public final class TransactionHistoryCall extends PagedApiCall {
  private TransactionHistoryCall(final Builder<?, ?> builder) {
    super(builder);
    addRequestParameter(ApiCallNames.CURRENCY, builder.currency);
    addRequestParameter(ApiCallNames.TYPE, builder.type);
  }

  public static Builder<TransactionHistoryCall, RetrieveTransactionHistoryCallBuilder> builder() {
    return new RetrieveTransactionHistoryCallBuilder()
        .market(Market.GENMKT)
        .namespace(Namespace.MONEY)
        .call(ApiCallType.WALLET)
        .subcall(ApiSubCallType.HISTORY);
  }

  public abstract static class Builder<T extends PagedApiCall, B extends Builder<T, B>> extends PagedApiCall.Builder<T, B> {
    private String currency;
    private String type;

    protected Builder() {}

    public B currency(final String currency) {
      this.currency = currency;
      return self();
    }

    public B currency(final Currency currency) {
      this.currency = currency.name();
      return self();
    }

    public B type(final String type) {
      this.type = type;
      return self();
    }

    public B type(final TransactionType type) {
      this.type = type.name().toLowerCase();
      return self();
    }
  }

  public static class RetrieveTransactionHistoryCallBuilder extends Builder<TransactionHistoryCall, RetrieveTransactionHistoryCallBuilder> {
    @Override
    public TransactionHistoryCall build() {
      return new TransactionHistoryCall(this);
    }

    @Override
    public RetrieveTransactionHistoryCallBuilder self() {
      return this;
    }
  }
}

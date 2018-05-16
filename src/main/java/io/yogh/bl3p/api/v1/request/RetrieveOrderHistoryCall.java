package io.yogh.bl3p.api.v1.request;

import io.yogh.bl3p.api.v1.request.domain.ApiCallType;
import io.yogh.bl3p.api.v1.request.domain.ApiSubCallType;
import io.yogh.bl3p.api.v1.request.domain.Namespace;

public final class RetrieveOrderHistoryCall extends PagedApiCall {
  private RetrieveOrderHistoryCall(final Builder<?, ?> builder) {
    super(builder);
  }

  public static Builder<RetrieveOrderHistoryCall, RetrieveOrderHistoryCallBuilder> builder() {
    return new RetrieveOrderHistoryCallBuilder()
        .namespace(Namespace.MONEY)
        .call(ApiCallType.ORDERS)
        .subcall(ApiSubCallType.HISTORY);
  }

  public abstract static class Builder<T extends PagedApiCall, B extends Builder<T, B>> extends PagedApiCall.Builder<T, B> {}

  public static class RetrieveOrderHistoryCallBuilder extends Builder<RetrieveOrderHistoryCall, RetrieveOrderHistoryCallBuilder> {
    @Override
    public RetrieveOrderHistoryCall build() {
      return new RetrieveOrderHistoryCall(this);
    }

    @Override
    public RetrieveOrderHistoryCallBuilder self() {
      return this;
    }
  }
}

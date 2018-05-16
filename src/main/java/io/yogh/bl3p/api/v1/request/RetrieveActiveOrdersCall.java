package io.yogh.bl3p.api.v1.request;

import io.yogh.bl3p.api.v1.request.ApiCall.Builder;
import io.yogh.bl3p.api.v1.request.domain.ApiCallType;
import io.yogh.bl3p.api.v1.request.domain.Namespace;

public final class RetrieveActiveOrdersCall extends ApiCall {
  private RetrieveActiveOrdersCall(final Builder<?, ?> builder) {
    super(builder);
  }

  public static Builder<RetrieveActiveOrdersCall, RetrieveActiveOrdersCallBuilder> builder() {
    return new RetrieveActiveOrdersCallBuilder()
        .namespace(Namespace.MONEY)
        .call(ApiCallType.ORDERS);
  }

  public abstract static class Builder<T extends ApiCall, B extends Builder<T, B>> extends ApiCall.Builder<T, B> {
    protected Builder() {}
  }

  public static class RetrieveActiveOrdersCallBuilder extends Builder<RetrieveActiveOrdersCall, RetrieveActiveOrdersCallBuilder> {
    @Override
    public RetrieveActiveOrdersCall build() {
      return new RetrieveActiveOrdersCall(this);
    }

    @Override
    public RetrieveActiveOrdersCallBuilder self() {
      return this;
    }
  }
}

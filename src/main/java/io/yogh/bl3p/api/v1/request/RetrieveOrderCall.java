package io.yogh.bl3p.api.v1.request;

import io.yogh.bl3p.api.v1.request.ApiCall.Builder;
import io.yogh.bl3p.api.v1.request.domain.ApiCallType;
import io.yogh.bl3p.api.v1.request.domain.ApiSubCallType;
import io.yogh.bl3p.api.v1.request.domain.Namespace;

public final class RetrieveOrderCall extends ApiCall {
  private RetrieveOrderCall(final Builder<?, ?> builder) {
    super(builder);
    addRequestParameter(ApiCallNames.ORDER_ID, builder.orderId);
  }

  public static Builder<RetrieveOrderCall, RetrieveOrderCallBuilder> builder() {
    return new RetrieveOrderCallBuilder()
        .namespace(Namespace.MONEY)
        .call(ApiCallType.ORDER)
        .subcall(ApiSubCallType.RESULT);
  }

  public abstract static class Builder<T extends ApiCall, B extends Builder<T, B>> extends ApiCall.Builder<T, B> {
    private Integer orderId;

    protected Builder() {}

    public B orderId(final Integer orderId) {
      this.orderId = orderId;
      return self();
    }
  }

  public static class RetrieveOrderCallBuilder extends Builder<RetrieveOrderCall, RetrieveOrderCallBuilder> {
    @Override
    public RetrieveOrderCall build() {
      return new RetrieveOrderCall(this);
    }

    @Override
    public RetrieveOrderCallBuilder self() {
      return this;
    }
  }
}

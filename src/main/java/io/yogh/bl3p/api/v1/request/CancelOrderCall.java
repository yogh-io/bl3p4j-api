package io.yogh.bl3p.api.v1.request;

import io.yogh.bl3p.api.v1.request.domain.ApiCallType;
import io.yogh.bl3p.api.v1.request.domain.ApiSubCallType;
import io.yogh.bl3p.api.v1.request.domain.Namespace;

public final class CancelOrderCall extends ApiCall {
  private CancelOrderCall(final Builder<?, ?> builder) {
    super(builder);
    addRequestParameter(ApiCallNames.ORDER_ID, builder.orderId);
  }

  public static Builder<CancelOrderCall, CancelOrderCallBuilder> builder() {
    return new CancelOrderCallBuilder()
        .namespace(Namespace.MONEY)
        .call(ApiCallType.ORDER)
        .subcall(ApiSubCallType.CANCEL);
  }

  public abstract static class Builder<T extends ApiCall, B extends Builder<T, B>> extends ApiCall.Builder<T, B> {
    private Integer orderId;

    protected Builder() {}

    public B orderId(final Integer orderId) {
      this.orderId = orderId;
      return self();
    }
  }

  public static class CancelOrderCallBuilder extends Builder<CancelOrderCall, CancelOrderCallBuilder> {
    @Override
    public CancelOrderCall build() {
      return new CancelOrderCall(this);
    }

    @Override
    public CancelOrderCallBuilder self() {
      return this;
    }
  }
}

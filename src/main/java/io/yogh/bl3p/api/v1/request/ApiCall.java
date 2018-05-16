package io.yogh.bl3p.api.v1.request;

import java.util.LinkedHashMap;
import java.util.Map;

import io.yogh.bl3p.api.v1.request.domain.ApiCallType;
import io.yogh.bl3p.api.v1.request.domain.ApiSubCallType;
import io.yogh.bl3p.api.v1.request.domain.Market;
import io.yogh.bl3p.api.v1.request.domain.Namespace;

/**
 * <version>/<market>/<namespace>/<callname>[/<subcallname>]
 */
public class ApiCall {
  private final String market;
  private final String namespace;
  private final String call;
  private final String subcall;

  private final Map<String, Object> queryString = new LinkedHashMap<>();

  public ApiCall(final Builder<?, ?> builder) {
    this.market = builder.market;
    this.namespace = builder.namespace;
    this.call = builder.call;
    this.subcall = builder.subcall;
  }

  public static Builder<?, ?> builder() {
    return new ApiCallBuilder();
  }

  public String getMarket() {
    return market;
  }

  public String getNamespace() {
    return namespace;
  }

  public String getCall() {
    return call;
  }

  public String getSubcall() {
    return subcall;
  }

  public Map<String, Object> getQueryString() {
    return queryString;
  }

  protected void addRequestParameter(final String key, final Object value) {
    if (value != null) {
      queryString.put(key, value);
    }
  }

  public abstract static class Builder<T extends ApiCall, B extends Builder<T, B>> {
    private String market;
    private String namespace;
    private String call;
    private String subcall;

    protected Builder() {}

    public B market(final String market) {
      this.market = market;
      return self();
    }

    public B market(final Market market) {
      return market(market.name());
    }

    public B namespace(final String namespace) {
      this.namespace = namespace;
      return self();
    }

    public B namespace(final Namespace namespace) {
      return namespace(namespace.name().toLowerCase());
    }

    public B call(final String call) {
      this.call = call;
      return self();
    }

    public B call(final ApiCallType call) {
      return call(call.getName());
    }

    public B subcall(final String subcall) {
      this.subcall = subcall;
      return self();
    }

    public B subcall(final ApiSubCallType subcall) {
      return subcall(subcall.getName());
    }

    protected abstract B self();

    public abstract T build();
  }

  public static class ApiCallBuilder extends Builder<ApiCall, ApiCallBuilder> {

    private ApiCallBuilder() {

    }

    @Override
    public ApiCall build() {
      return new ApiCall(this);
    }

    @Override
    public ApiCallBuilder self() {
      return this;
    }
  }
}

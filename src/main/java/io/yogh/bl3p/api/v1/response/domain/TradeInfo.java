package io.yogh.bl3p.api.v1.response.domain;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class TradeInfo {
  public static Builder builder() {
    return new AutoValue_TradeInfo.Builder();
  }

  public abstract int tradeId();

  public abstract long date();

  public abstract int amount();

  public abstract int price();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract Builder tradeId(int value);

    public abstract Builder date(long value);

    public abstract Builder amount(int value);

    public abstract Builder price(int value);

    public abstract TradeInfo build();

  }
}

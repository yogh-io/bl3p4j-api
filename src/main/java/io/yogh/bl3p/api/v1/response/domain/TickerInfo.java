package io.yogh.bl3p.api.v1.response.domain;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class TickerInfo {
  public static Builder builder() {
    return new AutoValue_TickerInfo.Builder();
  }

  public abstract String currency();

  public abstract double last();

  public abstract double bid();

  public abstract double ask();

  public abstract double high();

  public abstract double low();

  public abstract long timestamp();

  public abstract double volume1d();

  public abstract double volume30d();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract Builder currency(String value);

    public abstract Builder last(double value);

    public abstract Builder bid(double value);

    public abstract Builder ask(double value);

    public abstract Builder high(double value);

    public abstract Builder low(double value);

    public abstract Builder timestamp(long value);

    public abstract Builder volume1d(double value);

    public abstract Builder volume30d(double value);

    public abstract TickerInfo build();
  }
}

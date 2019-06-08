package io.yogh.bl3p.api.v1.response.domain;

import org.checkerframework.checker.nullness.qual.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class OrderInfo {
  public static Builder builder() {
    return new AutoValue_OrderInfo.Builder();
  }

  public abstract int orderId();

  public abstract String label();

  // Currency of the order. (Is now by default 'EUR')
  public abstract String currency();

  /**
   * The item that will be traded for `currency`. (Can be: 'BTC')
   */
  public abstract String item();

  /**
   * Status of the order. (Can be: 'pending’, ‘open’, ‘closed’, ‘cancelled’,
   * ’placed’)
   */
  public abstract String status();

  public abstract Long date();

  @Nullable
  public abstract Long dateClosed();

  /**
   * Amount in funds that is executed.
   */
  @Nullable
  public abstract Amount amount();

  @Nullable
  public abstract Amount amountFunds();

  public abstract Amount amountFundsExecuted();

  /**
   * Amount that is executed.
   */
  public abstract Amount amountExecuted();

  /**
   * Order limit price. (optional)
   */
  @Nullable
  public abstract Amount price();

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder orderId(int value);

    public abstract Builder label(String value);

    public abstract Builder currency(String value);

    public abstract Builder item(String value);

    public abstract Builder status(String value);

    public abstract Builder date(Long value);

    public abstract Builder dateClosed(Long value);

    public abstract Builder amount(Amount value);

    public abstract Builder amountFunds(Amount value);

    public abstract Builder amountFundsExecuted(Amount value);

    public abstract Builder amountExecuted(Amount value);

    public abstract Builder price(Amount value);

    public abstract OrderInfo build();
  }
}

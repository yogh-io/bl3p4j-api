package io.yogh.bl3p.api.v1.response.domain;

import org.checkerframework.checker.nullness.qual.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Bl3pTransaction {
  public static Builder builder() {
    return new AutoValue_Bl3pTransaction.Builder();
  }

  public abstract int transactionId();

  public abstract Amount amount();

  public abstract int timestamp();

  /**
   * Type of booking. (Can be: 'debit' or 'credit')
   */
  public abstract String debitCredit();

  /**
   * The field described above is for type 'trade' only and will be omitted if
   * recs_per_page > 1000
   */
  @Nullable
  public abstract Amount price();

  /**
   * The field described above is for type 'trade' only and will be omitted if
   * recs_per_page > 1000
   */
  @Nullable
  public abstract Integer orderId();

  /**
   * Type of transaction (Can be: 'trade’, ‘fee’, ‘deposit’, ‘withdraw’)
   */
  public abstract String type();

  /**
   * Balance of the user his account (for the regarding currency) after the
   * transaction.
   */
  public abstract Amount balance();

  /**
   * The field described above is for type 'trade' only and will be omitted if
   * recs_per_page > 1000
   */
  @Nullable
  public abstract Integer tradeId();

  /**
   * The field described above is for type 'trade' only and will be omitted if
   * recs_per_page > 1000
   */
  @Nullable
  public abstract Amount contraAmount();

  /**
   * The field described above is for type 'trade' only and will be omitted if
   * recs_per_page > 1000
   */
  @Nullable
  public abstract Amount fee();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract Builder transactionId(int value);

    public abstract Builder amount(Amount value);

    public abstract Builder timestamp(int value);

    public abstract Builder debitCredit(String value);

    public abstract Builder price(Amount value);

    public abstract Builder orderId(Integer value);

    public abstract Builder type(String value);

    public abstract Builder balance(Amount value);

    public abstract Builder tradeId(Integer value);

    public abstract Builder contraAmount(Amount value);

    public abstract Builder fee(Amount value);

    public abstract Bl3pTransaction build();
  }
}

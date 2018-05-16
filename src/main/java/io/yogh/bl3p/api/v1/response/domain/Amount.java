package io.yogh.bl3p.api.v1.response.domain;

public class Amount {
  /**
   * The amount in 1e5 (for fiat) or 1e8 (for virtual currency).
   */
  private int valueInt;

  /**
   * The amount in 1e5 (for fiat) or 1e8 (for virtual currency), with decimal
   * notation.
   */
  private String value;

  /**
   * The common notation of this amount.
   */
  private String displayShort;

  /**
   * The amount in 1e5 (for fiat) or 1e8 (for virtual currency), with decimal
   * notation and the regarding currency.
   */
  private String display;

  private String currency;

  public int getValueInt() {
    return valueInt;
  }

  public void setValueInt(final int valueInt) {
    this.valueInt = valueInt;
  }

  public String getValue() {
    return value;
  }

  public void setValue(final String value) {
    this.value = value;
  }

  public String getDisplayShort() {
    return displayShort;
  }

  public void setDisplayShort(final String displayShort) {
    this.displayShort = displayShort;
  }

  public String getDisplay() {
    return display;
  }

  public void setDisplay(final String display) {
    this.display = display;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(final String currency) {
    this.currency = currency;
  }

  @Override
  public String toString() {
    return "Amount [valueInt=" + valueInt + ", value=" + value + ", displayShort=" + displayShort + ", display=" + display + ", currency=" + currency
        + "]";
  }
}

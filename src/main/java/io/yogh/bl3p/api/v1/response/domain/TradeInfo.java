package io.yogh.bl3p.api.v1.response.domain;

public class TradeInfo {
  private int tradeId;
  private long date;
  private int amount;
  private int price;

  public int getTradeId() {
    return tradeId;
  }

  public void setTradeId(final int tradeId) {
    this.tradeId = tradeId;
  }

  public long getDate() {
    return date;
  }

  public void setDate(final long date) {
    this.date = date;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(final int amount) {
    this.amount = amount;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(final int price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "TradeInfo [tradeId=" + tradeId + ", date=" + date + ", amount=" + amount + ", price=" + price + "]";
  }
}

package io.yogh.bl3p.api.v1.response.domain;

public class TradeFeedInfo {
  private long timestamp;
  private String marketplace;
  private int price;
  private String type;
  private int amount;

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(final long timestamp) {
    this.timestamp = timestamp;
  }

  public String getMarketplace() {
    return marketplace;
  }

  public void setMarketplace(final String marketplace) {
    this.marketplace = marketplace;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(final int price) {
    this.price = price;
  }

  public String getType() {
    return type;
  }

  public void setType(final String type) {
    this.type = type;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(final int amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "TradeFeedInfo [timestamp=" + timestamp + ", marketplace=" + marketplace + ", price=" + price + ", type=" + type + ", amount=" + amount
        + "]";
  }
}

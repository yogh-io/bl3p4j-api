package io.yogh.bl3p.api.v1.response.domain;

public class SimpleOrder {
  private long amount;
  private long price;
  private int count;

  public long getAmount() {
    return amount;
  }

  public void setAmount(final long amount) {
    this.amount = amount;
  }

  public long getPrice() {
    return price;
  }

  public void setPrice(final long price) {
    this.price = price;
  }

  public int getCount() {
    return count;
  }

  public void setCount(final int count) {
    this.count = count;
  }

  @Override
  public String toString() {
    return "SimpleOrder [amount=" + amount + ", price=" + price + ", count=" + count + "]";
  }
}

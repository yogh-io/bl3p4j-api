package io.yogh.bl3p.api.v1.response.domain;

public class SimpleOrder {
  private int amount;
  private int price;
  private int count;

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

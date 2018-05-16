package io.yogh.bl3p.api.v1.response.domain;

public class WalletInfo {
  private Amount balance;
  private Amount available;

  public Amount getBalance() {
    return balance;
  }

  public void setBalance(final Amount balance) {
    this.balance = balance;
  }

  public Amount getAvailable() {
    return available;
  }

  public void setAvailable(final Amount available) {
    this.available = available;
  }

  @Override
  public String toString() {
    return "WalletInfo [balance=" + balance + ", available=" + available + "]";
  }
}

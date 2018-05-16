package io.yogh.bl3p.api.v1.response.domain;

import java.util.Map;

public class AccountBalance {
  private int userId;
  private double tradeFee;

  private Map<String, WalletInfo> wallets;

  public int getUserId() {
    return userId;
  }

  public void setUserId(final int userId) {
    this.userId = userId;
  }

  public double getTradeFee() {
    return tradeFee;
  }

  @Override
  public String toString() {
    return "AccountBalance [userId=" + userId + ", tradeFee=" + tradeFee + ", wallets=" + wallets + "]";
  }

  public void setTradeFee(final double tradeFee) {
    this.tradeFee = tradeFee;
  }

  public Map<String, WalletInfo> getWallets() {
    return wallets;
  }

  public void setWallets(final Map<String, WalletInfo> wallets) {
    this.wallets = wallets;
  }
}

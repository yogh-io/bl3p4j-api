package io.yogh.bl3p.api.v1.response.domain;

import java.util.List;

public class TransactionHistory extends AbstractPagedResponse implements PagedResponse {
  private List<Bl3pTransaction> transactions;

  public List<Bl3pTransaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(final List<Bl3pTransaction> transactions) {
    this.transactions = transactions;
  }

  @Override
  public String toString() {
    return "TransactionHistory [transactions=" + transactions.size() + "]";
  }
}

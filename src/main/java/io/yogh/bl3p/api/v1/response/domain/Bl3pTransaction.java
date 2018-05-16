package io.yogh.bl3p.api.v1.response.domain;

public class Bl3pTransaction {
  private int transactionId;
  private Amount amount;
  private int timestamp;

  // Type of booking. (Can be: 'debit' or 'credit')
  private String debitCredit;

  // The field described above is for type 'trade' only and will be omitted if
  // recs_per_page > 1000
  private Amount price;

  // The field described above is for type 'trade' only and will be omitted if
  // recs_per_page > 1000
  private int orderId;

  // Type of transaction (Can be: 'trade’, ‘fee’, ‘deposit’, ‘withdraw’)
  private String type;

  // Balance of the user his account (for the regarding currency) after the
  // transaction.
  private Amount balance;

  // The field described above is for type 'trade' only and will be omitted if
  // recs_per_page > 1000
  private int tradeId;

  // The field described above is for type 'trade' only and will be omitted if
  // recs_per_page > 1000
  private Amount contraAmount;

  // The field described above is for type 'trade' only and will be omitted if
  // recs_per_page > 1000
  private Amount fee;

  public int getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(final int transactionId) {
    this.transactionId = transactionId;
  }

  public Amount getAmount() {
    return amount;
  }

  public void setAmount(final Amount amount) {
    this.amount = amount;
  }

  public int getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(final int timestamp) {
    this.timestamp = timestamp;
  }

  public String getDebitCredit() {
    return debitCredit;
  }

  public void setDebitCredit(final String debitCredit) {
    this.debitCredit = debitCredit;
  }

  public Amount getPrice() {
    return price;
  }

  public void setPrice(final Amount price) {
    this.price = price;
  }

  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(final int orderId) {
    this.orderId = orderId;
  }

  public String getType() {
    return type;
  }

  public void setType(final String type) {
    this.type = type;
  }

  public Amount getBalance() {
    return balance;
  }

  public void setBalance(final Amount balance) {
    this.balance = balance;
  }

  public int getTradeId() {
    return tradeId;
  }

  public void setTradeId(final int tradeId) {
    this.tradeId = tradeId;
  }

  public Amount getContraAmount() {
    return contraAmount;
  }

  public void setContraAmount(final Amount contraAmount) {
    this.contraAmount = contraAmount;
  }

  public Amount getFee() {
    return fee;
  }

  public void setFee(final Amount fee) {
    this.fee = fee;
  }

  @Override
  public String toString() {
    return "Bl3pTransaction [transactionId=" + transactionId + ", amount=" + amount + ", timestamp=" + timestamp + ", debitCredit=" + debitCredit
        + ", price=" + price + ", orderId=" + orderId + ", type=" + type + ", balance=" + balance + ", tradeId=" + tradeId + ", contraAmount="
        + contraAmount + ", fee=" + fee + "]";
  }
}

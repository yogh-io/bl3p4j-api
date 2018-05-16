package io.yogh.bl3p.api.v1.response.domain;

public class OrderInfo {
  private int orderId;
  private String label;

  // Currency of the order. (Is now by default 'EUR')
  private String currency;

  // The item that will be traded for `currency`. (Can be: 'BTC')
  private String item;

  // Status of the order. (Can be: 'pending’, ‘open’, ‘closed’, ‘cancelled’,
  // ’placed’)
  private String status;

  private long date;
  private long dateClosed;

  // Amount in funds that is executed.
  private Amount amount;

  private Amount amountFunds;

  private Amount amountFundsExecuted;

  // Amount that is executed.
  private Amount amountExecuted;

  // Order limit price. (optional)
  private Amount price;

  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(final int orderId) {
    this.orderId = orderId;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(final String label) {
    this.label = label;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(final String currency) {
    this.currency = currency;
  }

  public String getItem() {
    return item;
  }

  public void setItem(final String item) {
    this.item = item;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(final String status) {
    this.status = status;
  }

  public long getDate() {
    return date;
  }

  public void setDate(final long date) {
    this.date = date;
  }

  public long getDateClosed() {
    return dateClosed;
  }

  public void setDateClosed(final long dateClosed) {
    this.dateClosed = dateClosed;
  }

  public Amount getAmount() {
    return amount;
  }

  public void setAmount(final Amount amount) {
    this.amount = amount;
  }

  public Amount getAmountExecuted() {
    return amountExecuted;
  }

  public void setAmountExecuted(final Amount amountExecuted) {
    this.amountExecuted = amountExecuted;
  }

  public Amount getPrice() {
    return price;
  }

  public void setPrice(final Amount price) {
    this.price = price;
  }

  public Amount getAmountFundsExecuted() {
    return amountFundsExecuted;
  }

  public void setAmountFundsExecuted(final Amount amountFundsExecuted) {
    this.amountFundsExecuted = amountFundsExecuted;
  }

  public Amount getAmountFunds() {
    return amountFunds;
  }

  public void setAmountFunds(final Amount amountFunds) {
    this.amountFunds = amountFunds;
  }

  @Override
  public String toString() {
    return "OrderInfo [orderId=" + orderId + ", label=" + label + ", currency=" + currency + ", status=" + status + ", price=" + price + "]";
  }
}

package io.yogh.bl3p.api.v1.response.domain;

import java.util.List;

public class OrderHistory extends AbstractPagedResponse implements PagedResponse {
  private List<OrderInfo> orders;

  public List<OrderInfo> getOrders() {
    return orders;
  }

  public void setOrders(final List<OrderInfo> orders) {
    this.orders = orders;
  }

  @Override
  public String toString() {
    return "OrderHistory [orders=" + orders + "]";
  }
}

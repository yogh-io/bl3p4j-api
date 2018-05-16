package io.yogh.bl3p.api.v1.response.domain;

import java.util.List;

public class OrderBook {
  private List<SimpleOrder> asks;
  private List<SimpleOrder> bids;

  public List<SimpleOrder> getAsks() {
    return asks;
  }

  public void setAsks(final List<SimpleOrder> asks) {
    this.asks = asks;
  }

  public List<SimpleOrder> getBids() {
    return bids;
  }

  public void setBids(final List<SimpleOrder> bids) {
    this.bids = bids;
  }

  @Override
  public String toString() {
    return "OrderBook [asks=" + asks.size() + ", bids=" + bids.size() + "]";
  }
}

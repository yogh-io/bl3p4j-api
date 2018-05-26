package io.yogh.bl3p.api.v1.response.domain;

public class TickerInfo {
  private String currency;
  private double last;
  private double bid;
  private double ask;
  private double high;
  private double low;
  private long timestamp;

  private double volume1d;
  private double volume30d;

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(final String currency) {
    this.currency = currency;
  }

  public double getLast() {
    return last;
  }

  public void setLast(final double last) {
    this.last = last;
  }

  public double getBid() {
    return bid;
  }

  public void setBid(final double bid) {
    this.bid = bid;
  }

  public double getAsk() {
    return ask;
  }

  public void setAsk(final double ask) {
    this.ask = ask;
  }

  public double getHigh() {
    return high;
  }

  public void setHigh(final double high) {
    this.high = high;
  }

  public double getLow() {
    return low;
  }

  public void setLow(final double low) {
    this.low = low;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(final long timestamp) {
    this.timestamp = timestamp;
  }

  public double getVolume1d() {
    return volume1d;
  }

  public void setVolume1d(final double volume1d) {
    this.volume1d = volume1d;
  }

  public double getVolume30d() {
    return volume30d;
  }

  public void setVolume30d(final double volume30d) {
    this.volume30d = volume30d;
  }

  @Override
  public String toString() {
    return "TickerInfo [currency=" + currency + ", last=" + last + ", bid=" + bid + ", ask=" + ask + ", high=" + high + ", low=" + low
        + ", timestamp=" + timestamp + ", volume1d=" + volume1d + ", volume30d=" + volume30d + "]";
  }
}

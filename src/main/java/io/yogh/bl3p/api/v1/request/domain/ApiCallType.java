package io.yogh.bl3p.api.v1.request.domain;

public enum ApiCallType {
  /** AUTHENTICATED CALLS **/

  ORDER("order"),

  DEPTH("depth"),

  WALLET("wallet"),

  NEW_DEPOSIT_ADDRESS("new_deposit_address"),

  DEPOSIT_ADDRESS("deposit_address"),

  INFO("info"),

  ORDERS("orders"),

  TRADES("trades"),

  /** PUBLIC CALLS **/

  TICKER("ticker"),

  ORDERBOOK("orderbook"),

  TRADES_LAST_1000("trades");

  private final String name;

  private ApiCallType(final String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}

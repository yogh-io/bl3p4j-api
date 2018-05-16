package io.yogh.bl3p.api.v1.request.domain;

public enum ApiCallType {
  ORDER("order"),

  DEPTH("depth"),

  WALLET("wallet"),

  NEW_DEPOSIT_ADDRESS("new_deposit_address"),

  DEPOSIT_ADDRESS("deposit_address"),

  INFO("info"),

  ORDERS("orders"),

  TRADES("trades");

  private final String name;

  private ApiCallType(final String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}

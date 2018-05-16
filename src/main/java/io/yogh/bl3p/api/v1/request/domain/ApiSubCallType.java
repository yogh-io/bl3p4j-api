package io.yogh.bl3p.api.v1.request.domain;

public enum ApiSubCallType {
  ADD("add"), CANCEL("cancel"), RESULT("result"),

  FULL("full"),

  HISTORY("history"),

  FETCH("fetch");

  private final String name;

  private ApiSubCallType(final String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}

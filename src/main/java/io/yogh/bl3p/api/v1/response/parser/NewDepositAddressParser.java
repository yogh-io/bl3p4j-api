package io.yogh.bl3p.api.v1.response.parser;

import com.mashape.unirest.http.JsonNode;

import io.yogh.bl3p.api.v1.response.exception.Bl3pException;

public class NewDepositAddressParser extends ResultParser implements Parser<String> {
  @Override
  public String parse(final JsonNode t) throws Bl3pException {
    return getDataNode(t).getString("address");
  }

  public static NewDepositAddressParser create() {
    return new NewDepositAddressParser();
  }
}

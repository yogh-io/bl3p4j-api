package io.yogh.bl3p.api.v1.response.parser;

import org.json.JSONObject;

import com.mashape.unirest.http.JsonNode;

import io.yogh.bl3p.api.v1.response.domain.AccountBalance;
import io.yogh.bl3p.api.v1.response.exception.Bl3pException;

public class RetrieveAccountBalanceResponseParser extends ResultParser implements Parser<AccountBalance> {
  @Override
  public AccountBalance parse(final JsonNode t) throws Bl3pException {
    final JSONObject data = getDataNode(t);
    System.out.println(t.toString());
    return null;
  }
}

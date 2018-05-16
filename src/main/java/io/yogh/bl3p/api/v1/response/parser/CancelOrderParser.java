package io.yogh.bl3p.api.v1.response.parser;

import com.mashape.unirest.http.JsonNode;

import io.yogh.bl3p.api.v1.response.exception.Bl3pException;

public class CancelOrderParser extends ResultParser implements Parser<Void> {
  @Override
  public Void parse(final JsonNode t) throws Bl3pException {
    // Parse success/failure, then return null
    getDataNode(t);
    return null;
  }

  public static CancelOrderParser create() {
    return new CancelOrderParser();
  }
}

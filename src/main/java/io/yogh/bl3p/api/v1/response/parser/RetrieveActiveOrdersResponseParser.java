package io.yogh.bl3p.api.v1.response.parser;

import org.json.JSONObject;

import com.mashape.unirest.http.JsonNode;

import io.yogh.bl3p.api.v1.response.domain.RetrieveActiveOrdersResponse;
import io.yogh.bl3p.api.v1.response.exception.Bl3pException;

public class RetrieveActiveOrdersResponseParser extends ResultParser implements Parser<RetrieveActiveOrdersResponse> {
  @Override
  public RetrieveActiveOrdersResponse parse(final JsonNode t) throws Bl3pException {
    final JSONObject data = getDataNode(t);
    return null;
  }
}

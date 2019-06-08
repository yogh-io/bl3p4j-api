package io.yogh.bl3p.api.v1.response.parser;

import org.json.JSONObject;

import com.mashape.unirest.http.JsonNode;

import io.yogh.bl3p.api.v1.response.domain.TickerInfo;

public class TickerResponseParser extends ResultParser implements Parser<TickerInfo> {
  @Override
  public TickerInfo parse(final JsonNode t) {
    final JSONObject data = t.getObject();
    final JSONObject volume = data.getJSONObject("volume");

    return TickerInfo.builder()
        .currency(data.getString("currency"))
        .last(data.getDouble("last"))
        .bid(data.getDouble("bid"))
        .ask(data.getDouble("ask"))
        .high(data.getDouble("high"))
        .low(data.getDouble("low"))
        .timestamp(data.getLong("timestamp"))
        .volume1d(volume.getDouble("24h"))
        .volume30d(volume.getDouble("30d"))
        .build();
  }

  public static TickerResponseParser create() {
    return new TickerResponseParser();
  }
}

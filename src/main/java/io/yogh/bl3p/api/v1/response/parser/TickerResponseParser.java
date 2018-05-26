package io.yogh.bl3p.api.v1.response.parser;

import org.json.JSONObject;

import com.mashape.unirest.http.JsonNode;

import io.yogh.bl3p.api.v1.response.domain.TickerInfo;

public class TickerResponseParser extends ResultParser implements Parser<TickerInfo> {
  @Override
  public TickerInfo parse(final JsonNode t) {
    final JSONObject data = t.getObject();

    final TickerInfo ticker = new TickerInfo();

    ticker.setCurrency(data.getString("currency"));
    ticker.setLast(data.getDouble("last"));
    ticker.setBid(data.getDouble("bid"));
    ticker.setAsk(data.getDouble("ask"));
    ticker.setHigh(data.getDouble("high"));
    ticker.setLow(data.getDouble("low"));
    ticker.setTimestamp(data.getLong("timestamp"));

    final JSONObject volume = data.getJSONObject("volume");

    ticker.setVolume1d(volume.getDouble("24h"));
    ticker.setVolume30d(volume.getDouble("30d"));

    return ticker;
  }

  public static TickerResponseParser create() {
    return new TickerResponseParser();
  }
}

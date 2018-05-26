package io.yogh.bl3p.api.v1.response.websocket;

import org.json.JSONObject;

import io.yogh.bl3p.api.v1.response.domain.TradeFeedInfo;

public class TradeFeedResponseParser implements StringJsonParser<TradeFeedInfo> {
  @Override
  public TradeFeedInfo apply(final String text) {
    final JSONObject data = new JSONObject(text);
    final TradeFeedInfo trade = new TradeFeedInfo();

    trade.setTimestamp(data.getLong("date"));
    trade.setMarketplace(data.getString("marketplace"));
    trade.setPrice(data.getInt("price_int"));
    trade.setAmount(data.getInt("amount_int"));

    return trade;
  }

  public static TradeFeedResponseParser create() {
    return new TradeFeedResponseParser();
  }
}

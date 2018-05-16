package io.yogh.bl3p.api.v1.response.parser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.JsonNode;

import io.yogh.bl3p.api.v1.response.domain.TradeInfo;
import io.yogh.bl3p.api.v1.response.exception.Bl3pException;

public class RetrieveAllTradesResponseParser extends ResultParser implements Parser<List<TradeInfo>> {
  @Override
  public List<TradeInfo> parse(final JsonNode t) throws Bl3pException {
    final JSONObject data = getDataNode(t);

    final JSONArray tradesJson = data.getJSONArray("trades");
    final List<TradeInfo> trades = new ArrayList<>();
    for (int i = 0; i < tradesJson.length(); i++) {
      final JSONObject tradeJson = tradesJson.getJSONObject(i);
      final TradeInfo trade = new TradeInfo();

      trade.setTradeId(tradeJson.getInt("trade_id"));
      trade.setDate(tradeJson.getLong("date"));
      trade.setPrice(tradeJson.getInt("price_int"));
      trade.setAmount(tradeJson.getInt("amount_int"));

      trades.add(trade);
    }

    return trades;
  }

  public static RetrieveAllTradesResponseParser create() {
    return new RetrieveAllTradesResponseParser();
  }
}

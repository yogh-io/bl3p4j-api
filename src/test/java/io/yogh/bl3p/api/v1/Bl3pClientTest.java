package io.yogh.bl3p.api.v1;

import io.yogh.bl3p.api.v1.request.domain.Market;
import io.yogh.bl3p.api.v1.response.exception.Bl3pException;

public class Bl3pClientTest {
  public static void main(final String[] args) throws Bl3pException {
    final Bl3pClient client = Bl3pClient.create()
        .defaultMarket(Market.BTCEUR);

    client.subscribeTradesFeed(System.out::println);
  }
}

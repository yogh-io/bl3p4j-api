package io.yogh.bl3p.api.v1;

import io.yogh.bl3p.api.v1.request.domain.Market;
import io.yogh.bl3p.api.v1.response.exception.Bl3pException;

public class Bl3pClientTest {
  public static void main(final String[] args) throws Bl3pException {
    final Bl3pClient client = Bl3pClient.create();

    client.getTickerAsync(Market.BTCEUR, System.out::println);

    client.getOrderBookAsync(Market.BTCEUR, System.out::println);

    client.getLast1000TradesAsync(Market.BTCEUR, System.out::println);
  }
}

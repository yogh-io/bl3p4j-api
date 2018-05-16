package io.yogh.bl3p.api.v1;

import io.yogh.bl3p.api.v1.request.domain.Currency;
import io.yogh.bl3p.api.v1.response.domain.AccountBalance;
import io.yogh.bl3p.api.v1.response.exception.Bl3pException;

public class Bl3pClientTest {
  public static void main(final String[] args) throws Bl3pException {
    final Bl3pClient client = Bl3pClient.create().uuid(args[0]).key(args[1]);

    final AccountBalance balance = client.getAccountBalance();

    final int fiat = balance.getWallets().get(Currency.EUR.name()).getAvailable().getValueInt();

    final SimpleTradeWrapper trader = SimpleTradeWrapper.wrap(client);

    trader.buyEuroAmount(fiat);
  }
}

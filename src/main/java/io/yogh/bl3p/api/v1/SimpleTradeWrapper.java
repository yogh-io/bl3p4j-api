package io.yogh.bl3p.api.v1;

import io.yogh.bl3p.api.v1.response.AsyncCallback;
import io.yogh.bl3p.api.v1.response.exception.Bl3pException;

/**
 * A simple wrapper for simple minds.
 */
public class SimpleTradeWrapper {
  private final Bl3pClient client;

  public SimpleTradeWrapper(final Bl3pClient client) {
    this.client = client;
  }

  public static SimpleTradeWrapper wrap(final Bl3pClient client) {
    return new SimpleTradeWrapper(client);
  }

  public Integer sellCoinsDownTo(final int price, final int amount) throws Bl3pException {
    return client.createLimitSellFromCrypto(price, amount);
  }

  public Integer sellEuroAmountDownTo(final int price, final int amountFunds) throws Bl3pException {
    return client.createLimitSellFromFunds(price, amountFunds);
  }

  public Integer sellCoins(final int amount) throws Bl3pException {
    return client.createMarketSellFromCrypto(amount);
  }

  public Integer sellEuroAmount(final int amountFunds) throws Bl3pException {
    return client.createMarketSellFromFunds(amountFunds);
  }

  public Integer buyCoinsUpTo(final int price, final int amount) throws Bl3pException {
    return client.createLimitBuyFromCrypto(price, amount);
  }

  public Integer buyEuroAmountUpTo(final int price, final int amountFunds) throws Bl3pException {
    return client.createLimitBuyFromFunds(price, amountFunds);
  }

  public Integer buyCoins(final int amount) throws Bl3pException {
    return client.createMarketBuyFromCrypto(amount);
  }

  public Integer buyEuroAmount(final int amountFunds) throws Bl3pException {
    return client.createMarketBuyFromFunds(amountFunds);
  }

  public void sellCoinsDownToAsync(final int price, final int amount, final AsyncCallback<Integer> callback) {
    client.createLimitSellFromCryptoAsync(price, amount, callback);
  }

  public void sellEuroAmountDownToAsync(final int price, final int amountFunds, final AsyncCallback<Integer> callback) {
    client.createLimitSellFromFundsAsync(price, amountFunds, callback);
  }

  public void sellCoinsAsync(final int amount, final AsyncCallback<Integer> callback) {
    client.createMarketSellFromCryptoAsync(amount, callback);
  }

  public void sellEuroAmountAsync(final int amountFunds, final AsyncCallback<Integer> callback) {
    client.createMarketSellFromFundsAsync(amountFunds, callback);
  }

  public void buyCoinsUpToAsync(final int price, final int amount, final AsyncCallback<Integer> callback) {
    client.createLimitBuyFromCryptoAsync(price, amount, callback);
  }

  public void buyEuroAmountUpToAsync(final int price, final int amountFunds, final AsyncCallback<Integer> callback) {
    client.createLimitBuyFromFundsAsync(price, amountFunds, callback);
  }

  public void buyCoinsAsync(final int amount, final AsyncCallback<Integer> callback) {
    client.createMarketBuyFromCryptoAsync(amount, callback);
  }

  public void buyEuroAmountAsync(final int amountFunds, final AsyncCallback<Integer> callback) {
    client.createMarketBuyFromFundsAsync(amountFunds, callback);
  }
}

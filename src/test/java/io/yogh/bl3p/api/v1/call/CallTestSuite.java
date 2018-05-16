package io.yogh.bl3p.api.v1.call;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.yogh.bl3p.api.v1.request.CancelOrderCall;
import io.yogh.bl3p.api.v1.request.CreateDepositAddressCall;
import io.yogh.bl3p.api.v1.request.CreateOrderCall;
import io.yogh.bl3p.api.v1.request.RequestUriBuilder;
import io.yogh.bl3p.api.v1.request.RetrieveAccountBalanceCall;
import io.yogh.bl3p.api.v1.request.RetrieveActiveOrdersCall;
import io.yogh.bl3p.api.v1.request.RetrieveAllTradesCall;
import io.yogh.bl3p.api.v1.request.RetrieveLastDepositAddressCall;
import io.yogh.bl3p.api.v1.request.RetrieveOrderBookCall;
import io.yogh.bl3p.api.v1.request.RetrieveOrderCall;
import io.yogh.bl3p.api.v1.request.RetrieveOrderHistoryCall;
import io.yogh.bl3p.api.v1.request.TransactionHistoryCall;
import io.yogh.bl3p.api.v1.request.domain.Currency;
import io.yogh.bl3p.api.v1.request.domain.FeeCurrency;
import io.yogh.bl3p.api.v1.request.domain.Market;

public class CallTestSuite {
  @Test
  public void testCancelOrderCall() {
    final CancelOrderCall call = CancelOrderCall.builder()
        .market(Market.BTCEUR)
        .orderId(1234)
        .build();

    assertEquals("/1/BTCEUR/money/order/cancel", RequestUriBuilder.getUri(call));
    assertEquals("order_id=1234", RequestUriBuilder.getPostData(call));
  }

  @Test
  public void testDepositAddressCall() {
    final CreateDepositAddressCall call1 = CreateDepositAddressCall.builder()
        .currency(Currency.BTC)
        .build();

    assertEquals("/1/GENMKT/money/new_deposit_address", RequestUriBuilder.getUri(call1));
    assertEquals("currency=BTC", RequestUriBuilder.getPostData(call1));

    final CreateDepositAddressCall call2 = CreateDepositAddressCall.builder()
        .currency(Currency.EUR)
        .build();

    assertEquals("/1/GENMKT/money/new_deposit_address", RequestUriBuilder.getUri(call2));
    assertEquals("currency=EUR", RequestUriBuilder.getPostData(call2));
  }

  @Test
  public void testCreateOrdercall() {
    final CreateOrderCall call = CreateOrderCall.builder()
        .market(Market.BTCEUR)
        .amount(5)
        .amountFunds(20)
        .feeCurrency(FeeCurrency.BTC)
        .build();

    assertEquals("/1/BTCEUR/money/order/add", RequestUriBuilder.getUri(call));
    assertEquals("amount_int=5&amount_funds_int=20&fee_currency=BTC", RequestUriBuilder.getPostData(call));
  }

  @Test
  public void testCreateWithdrawalCall() {
    final CreateDepositAddressCall call = CreateDepositAddressCall.builder()
        .build();
  }

  @Test
  public void testRetrieveAccountBalanceCall() {
    final RetrieveAccountBalanceCall call = RetrieveAccountBalanceCall.builder()
        .build();
  }

  @Test
  public void testRetrieveActiveOrdersCall() {
    final RetrieveActiveOrdersCall call = RetrieveActiveOrdersCall.builder()
        .build();
  }

  @Test
  public void testRetrieveAllTradesCall() {
    final RetrieveAllTradesCall call = RetrieveAllTradesCall.builder()
        .build();
  }

  @Test
  public void testRetrieveLastDepositAddressCall() {
    final RetrieveLastDepositAddressCall call = RetrieveLastDepositAddressCall.builder()
        .build();
  }

  @Test
  public void testRetrieveOrderBookCall() {
    final RetrieveOrderBookCall call = RetrieveOrderBookCall.builder()
        .build();
  }

  @Test
  public void testRetrieveOrderCall() {
    final RetrieveOrderCall call = RetrieveOrderCall.builder()
        .build();
  }

  @Test
  public void testRetrieveOrderHistoryCall() {
    final RetrieveOrderHistoryCall call = RetrieveOrderHistoryCall.builder()
        .build();
  }

  @Test
  public void testRetrieveTransactionHistoryCall() {
    final TransactionHistoryCall call = TransactionHistoryCall.builder()
        .build();
  }
}

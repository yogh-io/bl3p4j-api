package io.yogh.bl3p.api.v1;

import java.util.List;

import io.yogh.bl3p.api.v1.request.ApiCall;
import io.yogh.bl3p.api.v1.request.CancelOrderCall;
import io.yogh.bl3p.api.v1.request.CreateDepositAddressCall;
import io.yogh.bl3p.api.v1.request.CreateOrderCall;
import io.yogh.bl3p.api.v1.request.CreateWithdrawalCall;
import io.yogh.bl3p.api.v1.request.RetrieveAccountBalanceCall;
import io.yogh.bl3p.api.v1.request.RetrieveActiveOrdersCall;
import io.yogh.bl3p.api.v1.request.RetrieveLastDepositAddressCall;
import io.yogh.bl3p.api.v1.request.RetrieveOrderBookCall;
import io.yogh.bl3p.api.v1.request.RetrieveOrderCall;
import io.yogh.bl3p.api.v1.request.RetrieveOrderHistoryCall;
import io.yogh.bl3p.api.v1.request.TransactionHistoryCall;
import io.yogh.bl3p.api.v1.request.domain.Currency;
import io.yogh.bl3p.api.v1.request.domain.FeeCurrency;
import io.yogh.bl3p.api.v1.request.domain.Market;
import io.yogh.bl3p.api.v1.request.domain.OrderType;
import io.yogh.bl3p.api.v1.request.domain.TransactionType;
import io.yogh.bl3p.api.v1.response.AsyncCallback;
import io.yogh.bl3p.api.v1.response.callback.CancelOrderCallback;
import io.yogh.bl3p.api.v1.response.callback.CreateDepositAddressCallback;
import io.yogh.bl3p.api.v1.response.callback.CreateOrderCallback;
import io.yogh.bl3p.api.v1.response.callback.CreateWithdrawalCallback;
import io.yogh.bl3p.api.v1.response.callback.RetrieveAccountBalanceCallback;
import io.yogh.bl3p.api.v1.response.callback.RetrieveActiveOrdersCallback;
import io.yogh.bl3p.api.v1.response.callback.RetrieveLastDepositAddressCallback;
import io.yogh.bl3p.api.v1.response.callback.RetrieveOrderBookCallback;
import io.yogh.bl3p.api.v1.response.callback.RetrieveOrderCallback;
import io.yogh.bl3p.api.v1.response.callback.RetrieveOrderHistoryCallback;
import io.yogh.bl3p.api.v1.response.callback.RetrieveTransactionHistoryCallback;
import io.yogh.bl3p.api.v1.response.domain.AccountBalance;
import io.yogh.bl3p.api.v1.response.domain.OrderBook;
import io.yogh.bl3p.api.v1.response.domain.OrderHistory;
import io.yogh.bl3p.api.v1.response.domain.OrderInfo;
import io.yogh.bl3p.api.v1.response.domain.TransactionHistory;
import io.yogh.bl3p.api.v1.response.exception.Bl3pException;
import io.yogh.bl3p.api.v1.response.parser.AccountBalanceParser;
import io.yogh.bl3p.api.v1.response.parser.ActiveOrdersParser;
import io.yogh.bl3p.api.v1.response.parser.CancelOrderParser;
import io.yogh.bl3p.api.v1.response.parser.CreateOrderParser;
import io.yogh.bl3p.api.v1.response.parser.CreateWithdrawalParser;
import io.yogh.bl3p.api.v1.response.parser.LastDepositAddressParser;
import io.yogh.bl3p.api.v1.response.parser.NewDepositAddressParser;
import io.yogh.bl3p.api.v1.response.parser.OrderBookParser;
import io.yogh.bl3p.api.v1.response.parser.OrderHistoryParser;
import io.yogh.bl3p.api.v1.response.parser.OrderParser;
import io.yogh.bl3p.api.v1.response.parser.Parser;
import io.yogh.bl3p.api.v1.response.parser.TransactionHistoryParser;

/**
 * Overly verbose client providing overloads for client-configurable properties.
 *
 * There's no real reason to use this.
 */
public final class VerboseBl3pClient {
  private String uuid;
  private String key;

  private Market defaultMarket;
  private Currency defaultCurrency;
  private FeeCurrency defaultFeeCurrency;

  public static VerboseBl3pClient create() {
    return new VerboseBl3pClient()
        .defaultMarket(Market.BTCEUR)
        .defaultCurrency(Currency.BTC)
        .defaultFeeCurrency(FeeCurrency.BTC);
  }

  public VerboseBl3pClient uuid(final String uuid) {
    this.uuid = uuid;
    return this;
  }

  public VerboseBl3pClient key(final String key) {
    this.key = key;
    return this;
  }

  public VerboseBl3pClient defaultCurrency(final Currency defaultCurrency) {
    this.defaultCurrency = defaultCurrency;
    return this;
  }

  public VerboseBl3pClient defaultMarket(final Market defaultMarket) {
    this.defaultMarket = defaultMarket;
    return this;
  }

  public VerboseBl3pClient defaultFeeCurrency(final FeeCurrency defaultFeeCurrency) {
    this.defaultFeeCurrency = defaultFeeCurrency;
    return this;

  }

  public AccountBalance getAccountBalance() throws Bl3pException {
    return doCall(AccountBalanceParser.create(), RetrieveAccountBalanceCall.builder().build());
  }

  public void getAccountBalanceAsync(final AsyncCallback<AccountBalance> callback) {
    Bl3pClientRequestUtil.doCallAsync(uuid, key, RetrieveAccountBalanceCallback.create(callback), RetrieveAccountBalanceCall.builder().build());
  }

  public TransactionHistory getTransactionHistory(final Currency currency) throws Bl3pException {
    return doCall(TransactionHistoryParser.create(), TransactionHistoryCall.builder()
        .currency(currency)
        .build());
  }

  public TransactionHistory getTransactionHistory(final Currency currency, final TransactionType type) throws Bl3pException {
    return doCall(TransactionHistoryParser.create(), TransactionHistoryCall.builder()
        .currency(currency)
        .type(type)
        .build());
  }

  public TransactionHistory getPagedTransactionHistory(final Currency currency, final int page) throws Bl3pException {
    return doCall(TransactionHistoryParser.create(), TransactionHistoryCall.builder()
        .currency(currency)
        .page(page)
        .build());
  }

  public TransactionHistory getPagedTransactionHistory(final Currency currency, final int page, final TransactionType type) throws Bl3pException {
    return doCall(TransactionHistoryParser.create(), TransactionHistoryCall.builder()
        .currency(currency)
        .page(page)
        .type(type)
        .build());
  }

  public TransactionHistory getPagedTransactionHistory(final Currency currency, final int page, final int recordsPerPage) throws Bl3pException {
    return doCall(TransactionHistoryParser.create(), TransactionHistoryCall.builder()
        .currency(currency)
        .page(page)
        .recordsPerPage(recordsPerPage)
        .build());
  }

  public TransactionHistory getPagedTransactionHistory(final Currency currency, final int page, final int recordsPerPage, final TransactionType type)
      throws Bl3pException {
    return doCall(TransactionHistoryParser.create(), TransactionHistoryCall.builder()
        .currency(currency)
        .page(page)
        .recordsPerPage(recordsPerPage)
        .type(type)
        .build());
  }

  public TransactionHistory getPagedTransactionHistoryByDate(final Currency currency, final int page, final int dateFrom) throws Bl3pException {
    return doCall(TransactionHistoryParser.create(), TransactionHistoryCall.builder()
        .currency(currency)
        .page(page)
        .dateFrom(dateFrom)
        .build());
  }

  public TransactionHistory getPagedTransactionHistoryByDate(final Currency currency, final int page, final int dateFrom, final int dateTo)
      throws Bl3pException {
    return doCall(TransactionHistoryParser.create(),
        TransactionHistoryCall.builder()
        .currency(currency)
        .page(page)
        .dateFrom(dateFrom)
        .dateTo(dateTo)
        .build());
  }

  public TransactionHistory getPagedTransactionHistoryByDate(final Currency currency, final int page, final int dateFrom, final int dateTo,
      final int recordsPerPage)
          throws Bl3pException {
    return doCall(TransactionHistoryParser.create(), TransactionHistoryCall.builder()
        .currency(currency)
        .page(page)
        .dateFrom(dateFrom)
        .dateTo(dateTo)
        .recordsPerPage(recordsPerPage)
        .build());
  }

  public TransactionHistory getPagedTransactionHistoryByDate(final Currency currency, final int page, final int dateFrom, final int dateTo,
      final int recordsPerPage,
      final TransactionType type) throws Bl3pException {
    return doCall(TransactionHistoryParser.create(), TransactionHistoryCall.builder()
        .currency(currency)
        .page(page)
        .dateFrom(dateFrom)
        .dateTo(dateTo)
        .recordsPerPage(recordsPerPage)
        .type(type)
        .build());
  }

  public TransactionHistory getPagedTransactionHistoryByDate(final Currency currency, final int page, final int dateFrom, final int dateTo,
      final TransactionType type)
          throws Bl3pException {
    return doCall(TransactionHistoryParser.create(), TransactionHistoryCall.builder()
        .currency(currency)
        .page(page)
        .dateFrom(dateFrom)
        .dateTo(dateTo)
        .type(type)
        .build());
  }

  public void getTransactionHistoryAsync(final Currency currency, final AsyncCallback<TransactionHistory> callback) {
    Bl3pClientRequestUtil.doCallAsync(uuid, key, RetrieveTransactionHistoryCallback.create(callback), TransactionHistoryCall.builder()
        .currency(currency)
        .build());
  }

  public void getTransactionHistoryAsync(final Currency currency, final TransactionType type, final AsyncCallback<TransactionHistory> callback) {
    Bl3pClientRequestUtil.doCallAsync(uuid, key, RetrieveTransactionHistoryCallback.create(callback), TransactionHistoryCall.builder()
        .currency(currency)
        .type(type)
        .build());
  }

  public void getPagedTransactionHistoryAsync(final Currency currency, final int page, final AsyncCallback<TransactionHistory> callback) {
    Bl3pClientRequestUtil.doCallAsync(uuid, key, RetrieveTransactionHistoryCallback.create(callback), TransactionHistoryCall.builder()
        .currency(currency)
        .page(page)
        .build());
  }

  public void getPagedTransactionHistoryAsync(final Currency currency, final int page, final int recordsPerPage,
      final AsyncCallback<TransactionHistory> callback) {
    Bl3pClientRequestUtil.doCallAsync(uuid, key, RetrieveTransactionHistoryCallback.create(callback), TransactionHistoryCall.builder()
        .currency(currency)
        .page(page)
        .recordsPerPage(recordsPerPage)
        .build());
  }

  public void getPagedTransactionHistoryAsync(final Currency currency, final int page, final int recordsPerPage, final TransactionType type,
      final AsyncCallback<TransactionHistory> callback) {
    Bl3pClientRequestUtil.doCallAsync(uuid, key, RetrieveTransactionHistoryCallback.create(callback), TransactionHistoryCall.builder()
        .currency(currency)
        .page(page)
        .recordsPerPage(recordsPerPage)
        .type(type)
        .build());
  }

  public void getPagedTransactionHistoryAsync(final Currency currency, final int page, final TransactionType type,
      final AsyncCallback<TransactionHistory> callback) {
    Bl3pClientRequestUtil.doCallAsync(uuid, key, RetrieveTransactionHistoryCallback.create(callback), TransactionHistoryCall.builder()
        .currency(currency)
        .page(page)
        .type(type)
        .build());
  }

  public void getPagedTransactionHistoryByDateAsync(final Currency currency, final int page, final int dateFrom,
      final AsyncCallback<TransactionHistory> callback) {
    Bl3pClientRequestUtil.doCallAsync(uuid, key, RetrieveTransactionHistoryCallback.create(callback), TransactionHistoryCall.builder()
        .currency(currency)
        .page(page)
        .dateFrom(dateFrom)
        .build());
  }

  public void getPagedTransactionHistoryByDateAsync(final Currency currency, final int page, final int dateFrom, final int dateTo,
      final AsyncCallback<TransactionHistory> callback) {
    Bl3pClientRequestUtil.doCallAsync(uuid, key, RetrieveTransactionHistoryCallback.create(callback), TransactionHistoryCall.builder()
        .currency(currency)
        .page(page)
        .dateFrom(dateFrom)
        .dateTo(dateTo)
        .build());
  }

  public void getPagedTransactionHistoryByDateAsync(final Currency currency, final int page, final int dateFrom, final int dateTo,
      final int recordsPerPage, final AsyncCallback<TransactionHistory> callback) {
    Bl3pClientRequestUtil.doCallAsync(uuid, key, RetrieveTransactionHistoryCallback.create(callback), TransactionHistoryCall.builder()
        .currency(currency)
        .page(page)
        .dateFrom(dateFrom)
        .dateTo(dateTo)
        .recordsPerPage(recordsPerPage)
        .build());
  }

  public void getPagedTransactionHistoryByDateAsync(final Currency currency, final int page, final int dateFrom, final int dateTo,
      final int recordsPerPage, final TransactionType type, final AsyncCallback<TransactionHistory> callback) {
    Bl3pClientRequestUtil.doCallAsync(uuid, key, RetrieveTransactionHistoryCallback.create(callback), TransactionHistoryCall.builder()
        .currency(currency)
        .page(page)
        .dateFrom(dateFrom)
        .dateTo(dateTo)
        .recordsPerPage(recordsPerPage)
        .type(type)
        .build());
  }

  public void getPagedTransactionHistoryByDateAsync(final Currency currency, final int page, final int dateFrom, final int dateTo,
      final TransactionType type, final AsyncCallback<TransactionHistory> callback) {
    Bl3pClientRequestUtil.doCallAsync(uuid, key, RetrieveTransactionHistoryCallback.create(callback), TransactionHistoryCall.builder()
        .currency(currency)
        .page(page)
        .dateFrom(dateFrom)
        .dateTo(dateTo)
        .type(type)
        .build());
  }

  public TransactionHistory getTransactionHistory() throws Bl3pException {
    return getTransactionHistory(defaultCurrency);
  }

  public TransactionHistory getTransactionHistory(final TransactionType type) throws Bl3pException {
    return getTransactionHistory(defaultCurrency, type);
  }

  public TransactionHistory getPagedTransactionHistory(final int page) throws Bl3pException {
    return getPagedTransactionHistory(defaultCurrency, page);
  }

  public TransactionHistory getPagedTransactionHistory(final int page, final TransactionType type) throws Bl3pException {
    return getPagedTransactionHistory(defaultCurrency, page, type);
  }

  public TransactionHistory getPagedTransactionHistory(final int page, final int recordsPerPage) throws Bl3pException {
    return getPagedTransactionHistory(defaultCurrency, page, recordsPerPage);
  }

  public TransactionHistory getPagedTransactionHistory(final int page, final int recordsPerPage, final TransactionType type) throws Bl3pException {
    return getPagedTransactionHistory(defaultCurrency, page, recordsPerPage, type);
  }

  public TransactionHistory getPagedTransactionHistoryByDate(final int page, final int dateFrom) throws Bl3pException {
    return getPagedTransactionHistory(defaultCurrency, page, dateFrom);
  }

  public TransactionHistory getPagedTransactionHistoryByDate(final int page, final int dateFrom, final int dateTo) throws Bl3pException {
    return getPagedTransactionHistoryByDate(defaultCurrency, page, dateFrom, dateTo);
  }

  public TransactionHistory getPagedTransactionHistoryByDate(final int page, final int dateFrom, final int dateTo, final int recordsPerPage)
      throws Bl3pException {
    return getPagedTransactionHistoryByDate(defaultCurrency, page, dateFrom, dateTo, recordsPerPage);
  }

  public TransactionHistory getPagedTransactionHistoryByDate(final int page, final int dateFrom, final int dateTo, final int recordsPerPage,
      final TransactionType type) throws Bl3pException {
    return getPagedTransactionHistoryByDate(defaultCurrency, page, dateFrom, dateTo, recordsPerPage, type);
  }

  public TransactionHistory getPagedTransactionHistoryByDate(final int page, final int dateFrom, final int dateTo, final TransactionType type)
      throws Bl3pException {
    return getPagedTransactionHistoryByDate(defaultCurrency, page, dateFrom, dateTo, type);
  }

  public void getTransactionHistoryAsync(final AsyncCallback<TransactionHistory> callback) {
    getTransactionHistoryAsync(defaultCurrency, callback);
  }

  public void getTransactionHistoryAsync(final TransactionType type, final AsyncCallback<TransactionHistory> callback) {
    getTransactionHistoryAsync(defaultCurrency, type, callback);
  }

  public void getPagedTransactionHistoryAsync(final int page, final AsyncCallback<TransactionHistory> callback) {
    getPagedTransactionHistoryAsync(defaultCurrency, page, callback);
  }

  public void getPagedTransactionHistoryAsync(final int page, final int recordsPerPage, final AsyncCallback<TransactionHistory> callback) {
    getPagedTransactionHistoryAsync(defaultCurrency, page, recordsPerPage, callback);
  }

  public void getPagedTransactionHistoryAsync(final int page, final int recordsPerPage, final TransactionType type,
      final AsyncCallback<TransactionHistory> callback) {
    getPagedTransactionHistoryAsync(defaultCurrency, page, recordsPerPage, type, callback);
  }

  public void getPagedTransactionHistoryAsync(final int page, final TransactionType type, final AsyncCallback<TransactionHistory> callback) {
    getPagedTransactionHistoryAsync(defaultCurrency, page, type, callback);
  }

  public void getPagedTransactionHistoryByDateAsync(final int page, final int dateFrom, final AsyncCallback<TransactionHistory> callback) {
    getPagedTransactionHistoryAsync(defaultCurrency, page, dateFrom, callback);
  }

  public void getPagedTransactionHistoryByDateAsync(final int page, final int dateFrom, final int dateTo,
      final AsyncCallback<TransactionHistory> callback) {
    getPagedTransactionHistoryByDateAsync(defaultCurrency, page, dateFrom, dateTo, callback);
  }

  public void getPagedTransactionHistoryByDateAsync(final int page, final int dateFrom, final int dateTo, final int recordsPerPage,
      final AsyncCallback<TransactionHistory> callback) {
    getPagedTransactionHistoryByDateAsync(defaultCurrency, page, dateFrom, dateTo, recordsPerPage, callback);
  }

  public void getPagedTransactionHistoryByDateAsync(final int page, final int dateFrom, final int dateTo, final int recordsPerPage,
      final TransactionType type, final AsyncCallback<TransactionHistory> callback) {
    getPagedTransactionHistoryByDateAsync(defaultCurrency, page, dateFrom, dateTo, recordsPerPage, type, callback);
  }

  public void getPagedTransactionHistoryByDateAsync(final int page, final int dateFrom, final int dateTo, final TransactionType type,
      final AsyncCallback<TransactionHistory> callback) {
    getPagedTransactionHistoryByDateAsync(defaultCurrency, page, dateFrom, dateTo, type, callback);
  }

  public String createNewDepositAddress() throws Bl3pException {
    return createNewDepositAddress(defaultCurrency);
  }

  public String createNewDepositAddress(final Currency currency) throws Bl3pException {
    return doCall(NewDepositAddressParser.create(), CreateDepositAddressCall.builder()
        .currency(currency)
        .build());
  }

  public void createNewDepositAddressAsync(final AsyncCallback<String> callback) {
    createNewDepositAddressAsync(defaultCurrency, callback);
  }

  public void createNewDepositAddressAsync(final Currency currency, final AsyncCallback<String> callback) {
    Bl3pClientRequestUtil.doCallAsync(uuid, key, CreateDepositAddressCallback.create(callback), CreateDepositAddressCall.builder()
        .currency(currency)
        .build());
  }

  public String getLastDepositAddress() throws Bl3pException {
    return getLastDepositAddress(defaultCurrency);
  }

  public String getLastDepositAddress(final Currency currency) throws Bl3pException {
    return doCall(LastDepositAddressParser.create(), RetrieveLastDepositAddressCall.builder()
        .currency(currency)
        .build());
  }

  public void getLastDepositAddressAsync(final AsyncCallback<String> callback) {
    getLastDepositAddressAsync(defaultCurrency, callback);
  }

  public void getLastDepositAddressAsync(final Currency currency, final AsyncCallback<String> callback) {
    Bl3pClientRequestUtil.doCallAsync(uuid, key, RetrieveLastDepositAddressCallback.create(callback), RetrieveLastDepositAddressCall.builder()
        .currency(currency)
        .build());
  }

  public Integer createSepaWithdrawal(final String accountId, final String accountName) throws Bl3pException {
    return doCall(CreateWithdrawalParser.create(), CreateWithdrawalCall.builder()
        .currency(Currency.EUR)
        .accountId(accountId)
        .accountName(accountName)
        .build());
  }

  public void createSepaWithdrawalAsync(final String accountId, final String accountName, final AsyncCallback<Integer> callback) {
    Bl3pClientRequestUtil.doCallAsync(uuid, key, CreateWithdrawalCallback.create(callback), CreateWithdrawalCall.builder()
        .currency(Currency.EUR)
        .accountId(accountId)
        .accountName(accountName)
        .build());
  }

  public List<OrderInfo> getActiveOrders() throws Bl3pException {
    return doCall(ActiveOrdersParser.create(), RetrieveActiveOrdersCall.builder().build());
  }

  public void getActiveOrdersAsync(final AsyncCallback<List<OrderInfo>> callback) {
    Bl3pClientRequestUtil.doCallAsync(uuid, key, RetrieveActiveOrdersCallback.create(callback), RetrieveActiveOrdersCall.builder()
        .market(defaultMarket)
        .build());
  }

  public OrderHistory getOrderHistory() throws Bl3pException {
    return doCall(OrderHistoryParser.create(), RetrieveOrderHistoryCall.builder()
        .market(defaultMarket)
        .build());
  }

  public OrderHistory getPagedOrderHistory(final int page) throws Bl3pException {
    return doCall(OrderHistoryParser.create(), RetrieveOrderHistoryCall.builder()
        .market(defaultMarket)
        .page(page)
        .build());
  }

  public OrderHistory getPagedOrderHistory(final int page, final int recordsPerPage) throws Bl3pException {
    return doCall(OrderHistoryParser.create(), RetrieveOrderHistoryCall.builder()
        .market(defaultMarket)
        .page(page)
        .recordsPerPage(recordsPerPage)
        .build());
  }

  public OrderHistory getPagedOrderHistoryByDate(final int page, final int dateFrom) throws Bl3pException {
    return doCall(OrderHistoryParser.create(), RetrieveOrderHistoryCall.builder()
        .market(defaultMarket)
        .page(page)
        .dateFrom(dateFrom)
        .build());
  }

  public OrderHistory getPagedOrderHistoryByDate(final int page, final int dateFrom, final int dateTo) throws Bl3pException {
    return doCall(OrderHistoryParser.create(), RetrieveOrderHistoryCall.builder()
        .market(defaultMarket)
        .page(page)
        .dateFrom(dateFrom)
        .dateTo(dateTo)
        .build());
  }

  public OrderHistory getPagedOrderHistoryByDate(final int page, final int dateFrom, final int dateTo, final int recordsPerPage)
      throws Bl3pException {
    return doCall(OrderHistoryParser.create(), RetrieveOrderHistoryCall.builder()
        .market(defaultMarket)
        .page(page)
        .dateFrom(dateFrom)
        .dateTo(dateTo)
        .recordsPerPage(recordsPerPage)
        .build());
  }

  public void getOrderHistoryAsync(final AsyncCallback<OrderHistory> callback) {
    Bl3pClientRequestUtil.doCallAsync(uuid, key, RetrieveOrderHistoryCallback.create(callback), RetrieveOrderHistoryCall.builder()
        .market(defaultMarket)
        .build());
  }

  public void getPagedOrderHistoryAsync(final int page, final AsyncCallback<OrderHistory> callback) {
    Bl3pClientRequestUtil.doCallAsync(uuid, key, RetrieveOrderHistoryCallback.create(callback), RetrieveOrderHistoryCall.builder()
        .market(defaultMarket)
        .page(page)
        .build());
  }

  public void getPagedOrderHistoryAsync(final int page, final int recordsPerPage, final AsyncCallback<OrderHistory> callback) {
    Bl3pClientRequestUtil.doCallAsync(uuid, key, RetrieveOrderHistoryCallback.create(callback), RetrieveOrderHistoryCall.builder()
        .market(defaultMarket)
        .page(page)
        .recordsPerPage(recordsPerPage)
        .build());
  }

  public void getPagedOrderHistoryByDateAsync(final int page, final int dateFrom, final AsyncCallback<OrderHistory> callback) {
    Bl3pClientRequestUtil.doCallAsync(uuid, key, RetrieveOrderHistoryCallback.create(callback), RetrieveOrderHistoryCall.builder()
        .market(defaultMarket)
        .page(page)
        .dateFrom(dateFrom)
        .build());
  }

  public void getPagedOrderHistoryByDateAsync(final int page, final int dateFrom, final int dateTo, final AsyncCallback<OrderHistory> callback) {
    Bl3pClientRequestUtil.doCallAsync(uuid, key, RetrieveOrderHistoryCallback.create(callback), RetrieveOrderHistoryCall.builder()
        .market(defaultMarket)
        .page(page)
        .dateFrom(dateFrom)
        .dateTo(dateTo)
        .build());
  }

  public void getPagedOrderHistoryByDateAsync(final int page, final int dateFrom, final int dateTo, final int recordsPerPage,
      final AsyncCallback<OrderHistory> callback) {
    Bl3pClientRequestUtil.doCallAsync(uuid, key, RetrieveOrderHistoryCallback.create(callback), RetrieveOrderHistoryCall.builder()
        .market(defaultMarket)
        .page(page)
        .dateFrom(dateFrom)
        .dateTo(dateTo)
        .recordsPerPage(recordsPerPage)
        .build());
  }

  public OrderBook getOrderBook() throws Bl3pException {
    return getOrderBook(defaultMarket);
  }

  public OrderBook getOrderBook(final Market market) throws Bl3pException {
    return doCall(OrderBookParser.create(), RetrieveOrderBookCall.builder()
        .market(market)
        .build());
  }

  public void getOrderBookAsync(final AsyncCallback<OrderBook> callback) {
    getOrderBookAsync(defaultMarket, callback);
  }

  public void getOrderBookAsync(final Market market, final AsyncCallback<OrderBook> callback) {
    Bl3pClientRequestUtil.doCallAsync(uuid, key, RetrieveOrderBookCallback.create(callback), RetrieveOrderBookCall.builder()
        .market(market)
        .build());
  }

  public OrderInfo getOrder(final int orderId) throws Bl3pException {
    return getOrder(defaultMarket, orderId);
  }

  public OrderInfo getOrder(final Market market, final int orderId) throws Bl3pException {
    return doCall(OrderParser.create(), RetrieveOrderCall.builder()
        .market(market)
        .orderId(orderId)
        .build());
  }

  public void getOrderAsync(final int orderId, final AsyncCallback<OrderInfo> callback) {
    getOrderAsync(defaultMarket, orderId, callback);
  }

  public void getOrderAsync(final Market market, final int orderId, final AsyncCallback<OrderInfo> callback) {
    Bl3pClientRequestUtil.doCallAsync(uuid, key, RetrieveOrderCallback.create(callback), RetrieveOrderCall.builder()
        .market(market)
        .orderId(orderId)
        .build());
  }

  public void cancelOrder(final int orderId) throws Bl3pException {
    cancelOrder(defaultMarket, orderId);
  }

  public void cancelOrder(final Market market, final int orderId) throws Bl3pException {
    doCall(CancelOrderParser.create(), CancelOrderCall.builder()
        .market(market)
        .orderId(orderId)
        .build());
  }

  public void cancelOrderAsync(final int orderId, final AsyncCallback<Void> callback) {
    cancelOrderAsync(defaultMarket, orderId, callback);
  }

  public void cancelOrderAsync(final Market market, final int orderId, final AsyncCallback<Void> callback) {
    Bl3pClientRequestUtil.doCallAsync(uuid, key, CancelOrderCallback.create(callback), CancelOrderCall.builder()
        .market(market)
        .orderId(orderId)
        .build());
  }

  public void createLimitSellFromCryptoAsync(final int price, final int amount, final AsyncCallback<Integer> callback) {
    createLimitOrderFromCryptoAsync(OrderType.ASK, price, amount, callback);
  }

  public void createLimitSellFromFundsAsync(final int price, final int amountFunds, final AsyncCallback<Integer> callback) {
    createLimitOrderFromFundsAsync(OrderType.ASK, price, amountFunds, callback);
  }

  public void createMarketSellFromCryptoAsync(final int amount, final AsyncCallback<Integer> callback) {
    createMarketOrderFromCryptoAsync(OrderType.ASK, amount, callback);
  }

  public void createMarketSellFromFundsAsync(final int amountFunds, final AsyncCallback<Integer> callback) {
    createMarketOrderFromFundsAsync(OrderType.ASK, amountFunds, callback);
  }

  public void createLimitSellFromCryptoAsync(final Market market, final int price, final int amount, final AsyncCallback<Integer> callback) {
    createLimitOrderFromCryptoAsync(market, OrderType.ASK, price, amount, callback);
  }

  public void createLimitSellFromFundsAsync(final Market market, final int price, final int amountFunds, final AsyncCallback<Integer> callback) {
    createLimitOrderFromFundsAsync(market, OrderType.ASK, price, amountFunds, callback);
  }

  public void createMarketSellFromCryptoAsync(final Market market, final int amount, final AsyncCallback<Integer> callback) {
    createMarketOrderFromCryptoAsync(market, OrderType.ASK, amount, callback);
  }

  public void createMarketSellFromFundsAsync(final Market market, final int amountFunds, final AsyncCallback<Integer> callback) {
    createMarketOrderFromFundsAsync(market, OrderType.ASK, amountFunds, callback);
  }

  public void createLimitSellFromCryptoAsync(final FeeCurrency feeCurrency, final int price, final int amount,
      final AsyncCallback<Integer> callback) {
    createLimitOrderFromCryptoAsync(feeCurrency, OrderType.ASK, price, amount, callback);
  }

  public void createLimitSellFromFundsAsync(final FeeCurrency feeCurrency, final int price, final int amountFunds,
      final AsyncCallback<Integer> callback) {
    createLimitOrderFromFundsAsync(feeCurrency, OrderType.ASK, price, amountFunds, callback);
  }

  public void createMarketSellFromCryptoAsync(final FeeCurrency feeCurrency, final int amount, final AsyncCallback<Integer> callback) {
    createMarketOrderFromCryptoAsync(feeCurrency, OrderType.ASK, amount, callback);
  }

  public void createMarketSellFromFundsAsync(final FeeCurrency feeCurrency, final int amountFunds, final AsyncCallback<Integer> callback) {
    createMarketOrderFromFundsAsync(feeCurrency, OrderType.ASK, amountFunds, callback);
  }

  public void createLimitSellFromCryptoAsync(final Market market, final FeeCurrency feeCurrency, final int price, final int amount,
      final AsyncCallback<Integer> callback) {
    createLimitOrderFromCryptoAsync(market, feeCurrency, OrderType.ASK, price, amount, callback);
  }

  public void createLimitSellFromFundsAsync(final Market market, final FeeCurrency feeCurrency, final int price, final int amountFunds,
      final AsyncCallback<Integer> callback) {
    createLimitOrderFromFundsAsync(market, feeCurrency, OrderType.ASK, price, amountFunds, callback);
  }

  public void createMarketSellFromCryptoAsync(final Market market, final FeeCurrency feeCurrency, final int amount,
      final AsyncCallback<Integer> callback) {
    createMarketOrderFromCryptoAsync(market, feeCurrency, OrderType.ASK, amount, callback);
  }

  public void createMarketSellFromFundsAsync(final Market market, final FeeCurrency feeCurrency, final int amountFunds,
      final AsyncCallback<Integer> callback) {
    createMarketOrderFromFundsAsync(market, feeCurrency, OrderType.ASK, amountFunds, callback);
  }

  public void createLimitBuyFromCryptoAsync(final int price, final int amount, final AsyncCallback<Integer> callback) {
    createLimitOrderFromCryptoAsync(OrderType.BID, price, amount, callback);
  }

  public void createLimitBuyFromFundsAsync(final int price, final int amountFunds, final AsyncCallback<Integer> callback) {
    createLimitOrderFromFundsAsync(OrderType.BID, price, amountFunds, callback);
  }

  public void createMarketBuyFromCryptoAsync(final int amount, final AsyncCallback<Integer> callback) {
    createMarketOrderFromCryptoAsync(OrderType.BID, amount, callback);
  }

  public void createMarketBuyFromFundsAsync(final int amountFunds, final AsyncCallback<Integer> callback) {
    createMarketOrderFromFundsAsync(OrderType.BID, amountFunds, callback);
  }

  public void createLimitBuyFromCryptoAsync(final Market market, final int price, final int amount, final AsyncCallback<Integer> callback) {
    createLimitOrderFromCryptoAsync(market, OrderType.BID, price, amount, callback);
  }

  public void createLimitBuyFromFundsAsync(final Market market, final int price, final int amountFunds, final AsyncCallback<Integer> callback) {
    createLimitOrderFromFundsAsync(market, OrderType.BID, price, amountFunds, callback);
  }

  public void createMarketBuyFromCryptoAsync(final Market market, final int amount, final AsyncCallback<Integer> callback) {
    createMarketOrderFromCryptoAsync(market, OrderType.BID, amount, callback);
  }

  public void createMarketBuyFromFundsAsync(final Market market, final int amountFunds, final AsyncCallback<Integer> callback) {
    createMarketOrderFromFundsAsync(market, OrderType.BID, amountFunds, callback);
  }

  public void createLimitBuyFromCryptoAsync(final FeeCurrency feeCurrency, final int price, final int amount, final AsyncCallback<Integer> callback) {
    createLimitOrderFromCryptoAsync(feeCurrency, OrderType.BID, price, amount, callback);
  }

  public void createLimitBuyFromFundsAsync(final FeeCurrency feeCurrency, final int price, final int amountFunds,
      final AsyncCallback<Integer> callback) {
    createLimitOrderFromFundsAsync(feeCurrency, OrderType.BID, price, amountFunds, callback);
  }

  public void createMarketBuyFromCryptoAsync(final FeeCurrency feeCurrency, final int amount, final AsyncCallback<Integer> callback) {
    createMarketOrderFromCryptoAsync(feeCurrency, OrderType.BID, amount, callback);
  }

  public void createMarketBuyFromFundsAsync(final FeeCurrency feeCurrency, final int amountFunds, final AsyncCallback<Integer> callback) {
    createMarketOrderFromFundsAsync(feeCurrency, OrderType.BID, amountFunds, callback);
  }

  public void createLimitBuyFromCryptoAsync(final Market market, final FeeCurrency feeCurrency, final int price, final int amount,
      final AsyncCallback<Integer> callback) {
    createLimitOrderFromCryptoAsync(market, feeCurrency, OrderType.BID, price, amount, callback);
  }

  public void createLimitBuyFromFundsAsync(final Market market, final FeeCurrency feeCurrency, final int price, final int amountFunds,
      final AsyncCallback<Integer> callback) {
    createLimitOrderFromFundsAsync(market, feeCurrency, OrderType.BID, price, amountFunds, callback);
  }

  public void createMarketBuyFromCryptoAsync(final Market market, final FeeCurrency feeCurrency, final int amount,
      final AsyncCallback<Integer> callback) {
    createMarketOrderFromCryptoAsync(market, feeCurrency, OrderType.BID, amount, callback);
  }

  public void createMarketBuyFromFundsAsync(final Market market, final FeeCurrency feeCurrency, final int amountFunds,
      final AsyncCallback<Integer> callback) {
    createMarketOrderFromFundsAsync(market, feeCurrency, OrderType.BID, amountFunds, callback);
  }

  public void createMarketOrderFromFundsAsync(final OrderType type, final int amountFunds, final AsyncCallback<Integer> callback) {
    createMarketOrderFromFundsAsync(defaultMarket, defaultFeeCurrency, type, amountFunds, callback);
  }

  public void createMarketOrderFromFundsAsync(final Market market, final OrderType type, final int amountFunds,
      final AsyncCallback<Integer> callback) {
    createMarketOrderFromFundsAsync(market, defaultFeeCurrency, type, amountFunds, callback);
  }

  public void createMarketOrderFromFundsAsync(final FeeCurrency feeCurrency, final OrderType type, final int amountFunds,
      final AsyncCallback<Integer> callback) {
    createMarketOrderFromFundsAsync(defaultMarket, feeCurrency, type, amountFunds, callback);
  }

  public void createMarketOrderFromFundsAsync(final Market market, final FeeCurrency feeCurrency, final OrderType type, final int amountFunds,
      final AsyncCallback<Integer> callback) {
    Bl3pClientRequestUtil.doCallAsync(uuid, key, CreateOrderCallback.create(callback), CreateOrderCall.builder()
        .market(market)
        .feeCurrency(feeCurrency)
        .amountFunds(amountFunds)
        .type(type)
        .build());
  }

  public void createMarketOrderFromCryptoAsync(final OrderType type, final int amount, final AsyncCallback<Integer> callback) {
    createMarketOrderFromCryptoAsync(defaultMarket, defaultFeeCurrency, type, amount, callback);
  }

  public void createMarketOrderFromCryptoAsync(final Market market, final OrderType type, final int amount, final AsyncCallback<Integer> callback) {
    createMarketOrderFromCryptoAsync(market, defaultFeeCurrency, type, amount, callback);
  }

  public void createMarketOrderFromCryptoAsync(final FeeCurrency feeCurrency, final OrderType type, final int amount,
      final AsyncCallback<Integer> callback) {
    createMarketOrderFromCryptoAsync(defaultMarket, feeCurrency, type, amount, callback);
  }

  public void createMarketOrderFromCryptoAsync(final Market market, final FeeCurrency feeCurrency, final OrderType type, final int amount,
      final AsyncCallback<Integer> callback) {
    Bl3pClientRequestUtil.doCallAsync(uuid, key, CreateOrderCallback.create(callback), CreateOrderCall.builder()
        .market(market)
        .feeCurrency(feeCurrency)
        .type(type)
        .amount(amount)
        .build());
  }

  public void createLimitOrderFromFundsAsync(final OrderType type, final int price, final int amountFunds, final AsyncCallback<Integer> callback) {
    createLimitOrderFromFundsAsync(defaultMarket, defaultFeeCurrency, type, price, amountFunds, callback);
  }

  public void createLimitOrderFromFundsAsync(final Market market, final OrderType type, final int price, final int amountFunds,
      final AsyncCallback<Integer> callback) {
    createLimitOrderFromFundsAsync(market, defaultFeeCurrency, type, price, amountFunds, callback);
  }

  public void createLimitOrderFromFundsAsync(final FeeCurrency feeCurrency, final OrderType type, final int price, final int amountFunds,
      final AsyncCallback<Integer> callback) {
    createLimitOrderFromFundsAsync(defaultMarket, feeCurrency, type, price, amountFunds, callback);
  }

  public void createLimitOrderFromFundsAsync(final Market market, final FeeCurrency feeCurrency, final OrderType type, final int price,
      final int amountFunds, final AsyncCallback<Integer> callback) {
    Bl3pClientRequestUtil.doCallAsync(uuid, key, CreateOrderCallback.create(callback), CreateOrderCall.builder()
        .market(market)
        .feeCurrency(feeCurrency)
        .amountFunds(amountFunds)
        .type(type)
        .price(price)
        .build());
  }

  public void createLimitOrderFromCryptoAsync(final OrderType type, final int price, final int amount, final AsyncCallback<Integer> callback) {
    createLimitOrderFromCryptoAsync(defaultMarket, defaultFeeCurrency, type, price, amount, callback);
  }

  public void createLimitOrderFromCryptoAsync(final Market market, final OrderType type, final int price, final int amount,
      final AsyncCallback<Integer> callback) {
    createLimitOrderFromCryptoAsync(market, defaultFeeCurrency, type, price, amount, callback);
  }

  public void createLimitOrderFromCryptoAsync(final FeeCurrency feeCurrency, final OrderType type, final int price, final int amount,
      final AsyncCallback<Integer> callback) {
    createLimitOrderFromCryptoAsync(defaultMarket, feeCurrency, type, price, amount, callback);
  }

  public void createLimitOrderFromCryptoAsync(final Market market, final FeeCurrency feeCurrency, final OrderType type, final int price,
      final int amount, final AsyncCallback<Integer> callback) {
    Bl3pClientRequestUtil.doCallAsync(uuid, key, CreateOrderCallback.create(callback), CreateOrderCall.builder()
        .market(market)
        .feeCurrency(feeCurrency)
        .type(type)
        .price(price)
        .amount(amount)
        .build());
  }

  public Integer createLimitSellFromCrypto(final int price, final int amount) throws Bl3pException {
    return createLimitOrderFromCrypto(OrderType.ASK, price, amount);
  }

  public Integer createLimitSellFromFunds(final int price, final int amountFunds) throws Bl3pException {
    return createLimitOrderFromFunds(OrderType.ASK, price, amountFunds);
  }

  public Integer createMarketSellFromCrypto(final int amount) throws Bl3pException {
    return createMarketOrderFromCrypto(OrderType.ASK, amount);
  }

  public Integer createMarketSellFromFunds(final int amountFunds) throws Bl3pException {
    return createMarketOrderFromFunds(OrderType.ASK, amountFunds);
  }

  public Integer createLimitSellFromCrypto(final Market market, final int price, final int amount) throws Bl3pException {
    return createLimitOrderFromCrypto(market, OrderType.ASK, price, amount);
  }

  public Integer createLimitSellFromFunds(final Market market, final int price, final int amountFunds) throws Bl3pException {
    return createLimitOrderFromFunds(market, OrderType.ASK, price, amountFunds);
  }

  public Integer createMarketSellFromCrypto(final Market market, final int amount) throws Bl3pException {
    return createMarketOrderFromCrypto(market, OrderType.ASK, amount);
  }

  public Integer createMarketSellFromFunds(final Market market, final int amountFunds) throws Bl3pException {
    return createMarketOrderFromFunds(market, OrderType.ASK, amountFunds);
  }

  public Integer createLimitSellFromCrypto(final FeeCurrency feeCurrency, final int price, final int amount) throws Bl3pException {
    return createLimitOrderFromCrypto(feeCurrency, OrderType.ASK, price, amount);
  }

  public Integer createLimitSellFromFunds(final FeeCurrency feeCurrency, final int price, final int amountFunds) throws Bl3pException {
    return createLimitOrderFromFunds(feeCurrency, OrderType.ASK, price, amountFunds);
  }

  public Integer createMarketSellFromCrypto(final FeeCurrency feeCurrency, final int amount) throws Bl3pException {
    return createMarketOrderFromCrypto(feeCurrency, OrderType.ASK, amount);
  }

  public Integer createMarketSellFromFunds(final FeeCurrency feeCurrency, final int amountFunds) throws Bl3pException {
    return createMarketOrderFromFunds(feeCurrency, OrderType.ASK, amountFunds);
  }

  public Integer createLimitSellFromCrypto(final Market market, final FeeCurrency feeCurrency, final int price, final int amount)
      throws Bl3pException {
    return createLimitOrderFromCrypto(market, feeCurrency, OrderType.ASK, price, amount);
  }

  public Integer createLimitSellFromFunds(final Market market, final FeeCurrency feeCurrency, final int price, final int amountFunds)
      throws Bl3pException {
    return createLimitOrderFromFunds(market, feeCurrency, OrderType.ASK, price, amountFunds);
  }

  public Integer createMarketSellFromCrypto(final Market market, final FeeCurrency feeCurrency, final int amount) throws Bl3pException {
    return createMarketOrderFromCrypto(market, feeCurrency, OrderType.ASK, amount);
  }

  public Integer createMarketSellFromFunds(final Market market, final FeeCurrency feeCurrency, final int amountFunds) throws Bl3pException {
    return createMarketOrderFromFunds(market, feeCurrency, OrderType.ASK, amountFunds);
  }

  public Integer createLimitBuyFromCrypto(final int price, final int amount) throws Bl3pException {
    return createLimitOrderFromCrypto(OrderType.BID, price, amount);
  }

  public Integer createLimitBuyFromFunds(final int price, final int amountFunds) throws Bl3pException {
    return createLimitOrderFromFunds(OrderType.BID, price, amountFunds);
  }

  public Integer createMarketBuyFromCrypto(final int amount) throws Bl3pException {
    return createMarketOrderFromCrypto(OrderType.BID, amount);
  }

  public Integer createMarketBuyFromFunds(final int amountFunds) throws Bl3pException {
    return createMarketOrderFromFunds(OrderType.BID, amountFunds);
  }

  public Integer createLimitBuyFromCrypto(final Market market, final int price, final int amount) throws Bl3pException {
    return createLimitOrderFromCrypto(market, OrderType.BID, price, amount);
  }

  public Integer createLimitBuyFromFunds(final Market market, final int price, final int amountFunds) throws Bl3pException {
    return createLimitOrderFromFunds(market, OrderType.BID, price, amountFunds);
  }

  public Integer createMarketBuyFromCrypto(final Market market, final int amount) throws Bl3pException {
    return createMarketOrderFromCrypto(market, OrderType.BID, amount);
  }

  public Integer createMarketBuyFromFunds(final Market market, final int amountFunds) throws Bl3pException {
    return createMarketOrderFromFunds(market, OrderType.BID, amountFunds);
  }

  public Integer createLimitBuyFromCrypto(final FeeCurrency feeCurrency, final int price, final int amount) throws Bl3pException {
    return createLimitOrderFromCrypto(feeCurrency, OrderType.BID, price, amount);
  }

  public Integer createLimitBuyFromFunds(final FeeCurrency feeCurrency, final int price, final int amountFunds) throws Bl3pException {
    return createLimitOrderFromFunds(feeCurrency, OrderType.BID, price, amountFunds);
  }

  public Integer createMarketBuyFromCrypto(final FeeCurrency feeCurrency, final int amount) throws Bl3pException {
    return createMarketOrderFromCrypto(feeCurrency, OrderType.BID, amount);
  }

  public Integer createMarketBuyFromFunds(final FeeCurrency feeCurrency, final int amountFunds) throws Bl3pException {
    return createMarketOrderFromFunds(feeCurrency, OrderType.BID, amountFunds);
  }

  public Integer createLimitBuyFromCrypto(final Market market, final FeeCurrency feeCurrency, final int price, final int amount)
      throws Bl3pException {
    return createLimitOrderFromCrypto(market, feeCurrency, OrderType.BID, price, amount);
  }

  public Integer createLimitBuyFromFunds(final Market market, final FeeCurrency feeCurrency, final int price, final int amountFunds)
      throws Bl3pException {
    return createLimitOrderFromFunds(market, feeCurrency, OrderType.BID, price, amountFunds);
  }

  public Integer createMarketBuyFromCrypto(final Market market, final FeeCurrency feeCurrency, final int amount) throws Bl3pException {
    return createMarketOrderFromCrypto(market, feeCurrency, OrderType.BID, amount);
  }

  public Integer createMarketBuyFromFunds(final Market market, final FeeCurrency feeCurrency, final int amountFunds) throws Bl3pException {
    return createMarketOrderFromFunds(market, feeCurrency, OrderType.BID, amountFunds);
  }

  public Integer createMarketOrderFromFunds(final OrderType type, final int amountFunds) throws Bl3pException {
    return createMarketOrderFromFunds(defaultMarket, defaultFeeCurrency, type, amountFunds);
  }

  public Integer createMarketOrderFromFunds(final Market market, final OrderType type, final int amountFunds) throws Bl3pException {
    return createMarketOrderFromFunds(market, defaultFeeCurrency, type, amountFunds);
  }

  public Integer createMarketOrderFromFunds(final FeeCurrency feeCurrency, final OrderType type, final int amountFunds) throws Bl3pException {
    return createMarketOrderFromFunds(defaultMarket, feeCurrency, type, amountFunds);
  }

  public Integer createMarketOrderFromFunds(final Market market, final FeeCurrency feeCurrency, final OrderType type, final int amountFunds)
      throws Bl3pException {
    return doCall(CreateOrderParser.create(), CreateOrderCall.builder()
        .market(market)
        .feeCurrency(feeCurrency)
        .type(type)
        .amountFunds(amountFunds)
        .build());
  }

  public Integer createMarketOrderFromCrypto(final OrderType type, final int amount) throws Bl3pException {
    return createMarketOrderFromCrypto(defaultMarket, defaultFeeCurrency, type, amount);
  }

  public Integer createMarketOrderFromCrypto(final Market market, final OrderType type, final int amount) throws Bl3pException {
    return createMarketOrderFromCrypto(market, defaultFeeCurrency, type, amount);
  }

  public Integer createMarketOrderFromCrypto(final FeeCurrency feeCurrency, final OrderType type, final int amount) throws Bl3pException {
    return createMarketOrderFromCrypto(defaultMarket, feeCurrency, type, amount);
  }

  public Integer createMarketOrderFromCrypto(final Market market, final FeeCurrency feeCurrency, final OrderType type, final int amount)
      throws Bl3pException {
    return doCall(CreateOrderParser.create(), CreateOrderCall.builder()
        .market(market)
        .feeCurrency(feeCurrency)
        .type(type)
        .amount(amount)
        .build());
  }

  public Integer createLimitOrderFromFunds(final OrderType type, final int price, final int amountFunds) throws Bl3pException {
    return createLimitOrderFromFunds(defaultMarket, defaultFeeCurrency, type, price, amountFunds);
  }

  public Integer createLimitOrderFromFunds(final Market market, final OrderType type, final int price, final int amountFunds) throws Bl3pException {
    return createLimitOrderFromFunds(market, defaultFeeCurrency, type, price, amountFunds);
  }

  public Integer createLimitOrderFromFunds(final FeeCurrency feeCurrency, final OrderType type, final int price, final int amountFunds)
      throws Bl3pException {
    return createLimitOrderFromFunds(defaultMarket, feeCurrency, type, price, amountFunds);
  }

  public Integer createLimitOrderFromFunds(final Market market, final FeeCurrency feeCurrency, final OrderType type, final int price,
      final int amountFunds) throws Bl3pException {
    return doCall(CreateOrderParser.create(), CreateOrderCall.builder()
        .market(market)
        .feeCurrency(feeCurrency)
        .type(type)
        .price(price)
        .amountFunds(amountFunds)
        .build());
  }

  public Integer createLimitOrderFromCrypto(final OrderType type, final int price, final int amount) throws Bl3pException {
    return createLimitOrderFromCrypto(defaultMarket, defaultFeeCurrency, type, price, amount);
  }

  public Integer createLimitOrderFromCrypto(final Market market, final OrderType type, final int price, final int amount) throws Bl3pException {
    return createLimitOrderFromCrypto(market, defaultFeeCurrency, type, price, amount);
  }

  public Integer createLimitOrderFromCrypto(final FeeCurrency feeCurrency, final OrderType type, final int price, final int amount)
      throws Bl3pException {
    return createLimitOrderFromCrypto(defaultMarket, feeCurrency, type, price, amount);
  }

  public Integer createLimitOrderFromCrypto(final Market market, final FeeCurrency feeCurrency, final OrderType type, final int price,
      final int amount) throws Bl3pException {
    return doCall(CreateOrderParser.create(), CreateOrderCall.builder()
        .market(market)
        .feeCurrency(feeCurrency)
        .type(type)
        .price(price)
        .amount(amount)
        .build());
  }

  private <T> T doCall(final Parser<T> parser, final ApiCall call) throws Bl3pException {
    return parser.parse(Bl3pClientRequestUtil.doCall(uuid, key, call));
  }
}

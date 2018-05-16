package io.yogh.bl3p.api.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.yogh.bl3p.api.v1.request.RetrieveAccountBalanceCall;
import io.yogh.bl3p.api.v1.response.AsyncCallback;
import io.yogh.bl3p.api.v1.response.callback.RetrieveAccountBalanceCallback;
import io.yogh.bl3p.api.v1.response.domain.AccountBalance;
import io.yogh.bl3p.api.v1.response.exception.Bl3pException;
import io.yogh.bl3p.api.v1.response.parser.RetrieveAccountBalanceResponseParser;

public final class ApiClient {
  private static final Logger LOG = LoggerFactory.getLogger(ApiClient.class);

  private String uuid;
  private String key;

  public static ApiClient create() {
    return new ApiClient();
  }

  public ApiClient uuid(final String uuid) {
    this.uuid = uuid;
    return this;
  }

  public ApiClient key(final String key) {
    this.key = key;
    return this;
  }

  public static void main(final String[] args) {
    final ApiClient client = ApiClient.create();
    client.uuid(args[0]);
    client.key(args[1]);

    try {
      final AccountBalance retrieveAccountBalance = client.retrieveAccountBalance();
    } catch (final Bl3pException e) {
      e.printStackTrace();
    }
  }

  public void retrieveAccountBalanceAsync(final AsyncCallback<AccountBalance> callback) {
    ApiClientRequestUtil.doCallAsync(uuid, key, RetrieveAccountBalanceCall.builder().build(), RetrieveAccountBalanceCallback.create(callback));
  }

  public AccountBalance retrieveAccountBalance() throws Bl3pException {
    return new RetrieveAccountBalanceResponseParser().parse(ApiClientRequestUtil.doCall(uuid, key, RetrieveAccountBalanceCall.builder().build()));
  }
}

package io.yogh.bl3p.api.v1.response.callback;

import io.yogh.bl3p.api.v1.response.AsyncCallback;
import io.yogh.bl3p.api.v1.response.domain.AccountBalance;
import io.yogh.bl3p.api.v1.response.parser.Parser;
import io.yogh.bl3p.api.v1.response.parser.RetrieveAccountBalanceResponseParser;

public class RetrieveAccountBalanceCallback extends ResponseParsingCallback<AccountBalance> {
  public RetrieveAccountBalanceCallback(final Parser<AccountBalance> parser,
      final AsyncCallback<AccountBalance> callback) {
    super(parser, callback);
  }

  public static RetrieveAccountBalanceCallback create(final AsyncCallback<AccountBalance> callback) {
    return new RetrieveAccountBalanceCallback(new RetrieveAccountBalanceResponseParser(), callback);
  }
}

package io.yogh.bl3p.api.v1.response.callback;

import io.yogh.bl3p.api.v1.response.AsyncCallback;
import io.yogh.bl3p.api.v1.response.parser.Parser;
import io.yogh.bl3p.api.v1.response.parser.LastDepositAddressParser;

public class RetrieveLastDepositAddressCallback extends ResponseParsingCallback<String> {
  public RetrieveLastDepositAddressCallback(final Parser<String> parser,
      final AsyncCallback<String> callback) {
    super(parser, callback);
  }

  public static RetrieveLastDepositAddressCallback create(final AsyncCallback<String> callback) {
    return new RetrieveLastDepositAddressCallback(new LastDepositAddressParser(), callback);
  }
}

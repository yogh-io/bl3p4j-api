package io.yogh.bl3p.api.v1.response.callback;

import io.yogh.bl3p.api.v1.response.AsyncCallback;
import io.yogh.bl3p.api.v1.response.parser.NewDepositAddressParser;
import io.yogh.bl3p.api.v1.response.parser.Parser;

public class CreateDepositAddressCallback extends ResponseParsingCallback<String> {
  public CreateDepositAddressCallback(final Parser<String> parser, final AsyncCallback<String> callback) {
    super(parser, callback);
  }

  public static CreateDepositAddressCallback create(final AsyncCallback<String> callback) {
    return new CreateDepositAddressCallback(NewDepositAddressParser.create(), callback);
  }
}

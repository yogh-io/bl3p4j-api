package io.yogh.bl3p.api.v1.response.callback;

import io.yogh.bl3p.api.v1.response.AsyncCallback;
import io.yogh.bl3p.api.v1.response.parser.CreateWithdrawalParser;
import io.yogh.bl3p.api.v1.response.parser.Parser;

public class CreateWithdrawalCallback extends ResponseParsingCallback<Integer> {
  public CreateWithdrawalCallback(final Parser<Integer> parser, final AsyncCallback<Integer> callback) {
    super(parser, callback);
  }

  public static CreateWithdrawalCallback create(final AsyncCallback<Integer> callback) {
    return new CreateWithdrawalCallback(new CreateWithdrawalParser(), callback);
  }
}

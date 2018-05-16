package io.yogh.bl3p.api.v1.response.callback;

import io.yogh.bl3p.api.v1.response.AsyncCallback;
import io.yogh.bl3p.api.v1.response.domain.CreateWithdrawalResponse;
import io.yogh.bl3p.api.v1.response.parser.CreateWithdrawalResponseParser;
import io.yogh.bl3p.api.v1.response.parser.Parser;

public class CreateWithdrawalCallback extends ResponseParsingCallback<CreateWithdrawalResponse> {
  public CreateWithdrawalCallback(final Parser<CreateWithdrawalResponse> parser, final AsyncCallback<CreateWithdrawalResponse> callback) {
    super(parser, callback);
  }

  public static CreateWithdrawalCallback create(final AsyncCallback<CreateWithdrawalResponse> callback) {
    return new CreateWithdrawalCallback(new CreateWithdrawalResponseParser(), callback);
  }
}

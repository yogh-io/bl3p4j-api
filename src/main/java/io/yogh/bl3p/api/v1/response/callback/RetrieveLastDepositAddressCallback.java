package io.yogh.bl3p.api.v1.response.callback;

import io.yogh.bl3p.api.v1.response.AsyncCallback;
import io.yogh.bl3p.api.v1.response.domain.RetrieveLastDepositAddressResponse;
import io.yogh.bl3p.api.v1.response.parser.Parser;
import io.yogh.bl3p.api.v1.response.parser.RetrieveLastDepositAddressResponseParser;

public class RetrieveLastDepositAddressCallback extends ResponseParsingCallback<RetrieveLastDepositAddressResponse> {
  public RetrieveLastDepositAddressCallback(final Parser<RetrieveLastDepositAddressResponse> parser,
      final AsyncCallback<RetrieveLastDepositAddressResponse> callback) {
    super(parser, callback);
  }

  public static RetrieveLastDepositAddressCallback create(final AsyncCallback<RetrieveLastDepositAddressResponse> callback) {
    return new RetrieveLastDepositAddressCallback(new RetrieveLastDepositAddressResponseParser(), callback);
  }
}

package io.yogh.bl3p.api.v1.response.callback;

import io.yogh.bl3p.api.v1.response.AsyncCallback;
import io.yogh.bl3p.api.v1.response.domain.RetrieveAllTradesResponse;
import io.yogh.bl3p.api.v1.response.parser.Parser;
import io.yogh.bl3p.api.v1.response.parser.RetrieveAllTradesResponseParser;

public class RetrieveAllTradesCallback extends ResponseParsingCallback<RetrieveAllTradesResponse> {
  public RetrieveAllTradesCallback(final Parser<RetrieveAllTradesResponse> parser, final AsyncCallback<RetrieveAllTradesResponse> callback) {
    super(parser, callback);
  }

  public static RetrieveAllTradesCallback create(final AsyncCallback<RetrieveAllTradesResponse> callback) {
    return new RetrieveAllTradesCallback(new RetrieveAllTradesResponseParser(), callback);
  }
}

package io.yogh.bl3p.api.v1.response.callback;

import io.yogh.bl3p.api.v1.response.AsyncCallback;
import io.yogh.bl3p.api.v1.response.domain.RetrieveOrderBookResponse;
import io.yogh.bl3p.api.v1.response.parser.Parser;
import io.yogh.bl3p.api.v1.response.parser.RetrieveOrderBookResponseParser;

public class RetrieveOrderBookCallback extends ResponseParsingCallback<RetrieveOrderBookResponse> {
  public RetrieveOrderBookCallback(final Parser<RetrieveOrderBookResponse> parser, final AsyncCallback<RetrieveOrderBookResponse> callback) {
    super(parser, callback);
  }

  public static RetrieveOrderBookCallback create(final AsyncCallback<RetrieveOrderBookResponse> callback) {
    return new RetrieveOrderBookCallback(new RetrieveOrderBookResponseParser(), callback);
  }
}

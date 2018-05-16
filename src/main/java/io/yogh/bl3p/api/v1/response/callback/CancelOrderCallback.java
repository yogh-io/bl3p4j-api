package io.yogh.bl3p.api.v1.response.callback;

import io.yogh.bl3p.api.v1.response.AsyncCallback;
import io.yogh.bl3p.api.v1.response.parser.CancelOrderParser;
import io.yogh.bl3p.api.v1.response.parser.Parser;

public class CancelOrderCallback extends ResponseParsingCallback<Void> {
  public CancelOrderCallback(final Parser<Void> parser, final AsyncCallback<Void> callback) {
    super(parser, callback);
  }

  public static CancelOrderCallback create(final AsyncCallback<Void> callback) {
    return new CancelOrderCallback(CancelOrderParser.create(), callback);
  }
}

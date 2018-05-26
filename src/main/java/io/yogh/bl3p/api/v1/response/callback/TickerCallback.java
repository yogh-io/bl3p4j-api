package io.yogh.bl3p.api.v1.response.callback;

import io.yogh.bl3p.api.v1.response.AsyncCallback;
import io.yogh.bl3p.api.v1.response.domain.TickerInfo;
import io.yogh.bl3p.api.v1.response.parser.Parser;
import io.yogh.bl3p.api.v1.response.parser.TickerResponseParser;

public class TickerCallback extends ResponseParsingCallback<TickerInfo> {
  public TickerCallback(final Parser<TickerInfo> parser, final AsyncCallback<TickerInfo> callback) {
    super(parser, callback);
  }

  public static TickerCallback create(final AsyncCallback<TickerInfo> callback) {
    return new TickerCallback(TickerResponseParser.create(), callback);
  }
}

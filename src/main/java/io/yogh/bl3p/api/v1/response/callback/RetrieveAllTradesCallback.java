package io.yogh.bl3p.api.v1.response.callback;

import java.util.List;

import io.yogh.bl3p.api.v1.response.AsyncCallback;
import io.yogh.bl3p.api.v1.response.domain.TradeInfo;
import io.yogh.bl3p.api.v1.response.parser.Parser;
import io.yogh.bl3p.api.v1.response.parser.RetrieveAllTradesResponseParser;

public class RetrieveAllTradesCallback extends ResponseParsingCallback<List<TradeInfo>> {
  public RetrieveAllTradesCallback(final Parser<List<TradeInfo>> parser, final AsyncCallback<List<TradeInfo>> callback) {
    super(parser, callback);
  }

  public static RetrieveAllTradesCallback create(final AsyncCallback<List<TradeInfo>> callback) {
    return new RetrieveAllTradesCallback(RetrieveAllTradesResponseParser.create(), callback);
  }
}

package io.yogh.bl3p.api.v1.response.callback;

import io.yogh.bl3p.api.v1.response.AsyncCallback;
import io.yogh.bl3p.api.v1.response.parser.CreateOrderParser;
import io.yogh.bl3p.api.v1.response.parser.Parser;

public class CreateOrderCallback extends ResponseParsingCallback<Integer> {
  public CreateOrderCallback(final Parser<Integer> parser, final AsyncCallback<Integer> callback) {
    super(parser, callback);
  }

  public static CreateOrderCallback create(final AsyncCallback<Integer> callback) {
    return new CreateOrderCallback(CreateOrderParser.create(), callback);
  }
}

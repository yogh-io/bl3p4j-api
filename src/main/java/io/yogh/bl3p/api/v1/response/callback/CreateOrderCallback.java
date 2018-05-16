package io.yogh.bl3p.api.v1.response.callback;

import io.yogh.bl3p.api.v1.response.AsyncCallback;
import io.yogh.bl3p.api.v1.response.domain.CreateOrderResponse;
import io.yogh.bl3p.api.v1.response.parser.CreateOrderResponseParser;
import io.yogh.bl3p.api.v1.response.parser.Parser;

public class CreateOrderCallback extends ResponseParsingCallback<CreateOrderResponse> {
  public CreateOrderCallback(final Parser<CreateOrderResponse> parser, final AsyncCallback<CreateOrderResponse> callback) {
    super(parser, callback);
  }

  public static CreateOrderCallback create(final AsyncCallback<CreateOrderResponse> callback) {
    return new CreateOrderCallback(new CreateOrderResponseParser(), callback);
  }
}

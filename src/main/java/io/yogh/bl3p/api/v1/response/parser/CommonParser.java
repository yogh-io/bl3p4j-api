package io.yogh.bl3p.api.v1.response.parser;

import org.json.JSONObject;

import io.yogh.bl3p.api.v1.response.domain.Amount;
import io.yogh.bl3p.api.v1.response.domain.OrderInfo;
import io.yogh.bl3p.api.v1.response.domain.OrderInfo.Builder;
import io.yogh.bl3p.api.v1.response.domain.PagedResponse;
import io.yogh.bl3p.api.v1.response.domain.SimpleOrder;

public final class CommonParser {
  private CommonParser() {}

  public static Amount parseAmount(final JSONObject obj, final String key) {
    return parseAmount(obj.getJSONObject(key));
  }

  public static Amount parseAmount(final JSONObject obj) {
    final Amount amount = new Amount();

    amount.setValueInt(Long.parseLong(obj.getString("value_int")));
    amount.setDisplayShort(obj.getString("display_short"));
    amount.setDisplay(obj.getString("display"));
    amount.setCurrency(obj.getString("currency"));
    amount.setValue(obj.getString("value"));

    return amount;
  }

  public static <P extends PagedResponse> P parsePagedResponse(final P pagedResponse, final JSONObject object) {
    pagedResponse.setPage(object.getInt("page"));
    pagedResponse.setRecords(object.getInt("records"));
    pagedResponse.setMaxPage(object.getInt("max_page"));

    return pagedResponse;
  }

  public static OrderInfo parseOrder(final JSONObject orderJson) {
    final Builder bldr = OrderInfo.builder()
        .orderId(orderJson.getInt("order_id"))
        .label(orderJson.getString("label"))
        .currency(orderJson.getString("currency"))
        .status(orderJson.getString("status"))
        .date(orderJson.getLong("date"))
        .amountFundsExecuted(parseAmount(orderJson, "amount_funds_executed"))
        .amountExecuted(parseAmount(orderJson, "amount_executed"));

    if (orderJson.has("date_closed")) {
      bldr.dateClosed(orderJson.getLong("date_closed"));
    }

    if (orderJson.has("price")) {
      bldr.price(parseAmount(orderJson, "price"));
    }

    if (orderJson.has("amount")) {
      bldr.amount(parseAmount(orderJson, "amount"));
    }

    if (orderJson.has("amount_funds")) {
      bldr.amountFunds(parseAmount(orderJson, "amount_funds"));
    }

    return bldr.build();
  }

  public static SimpleOrder parseSimpleOrder(final JSONObject orderJson) {
    final SimpleOrder order = new SimpleOrder();
    order.setAmount(orderJson.getLong("amount_int"));
    order.setPrice(orderJson.getLong("price_int"));

    if (orderJson.has("count")) {
      order.setCount(orderJson.getInt("count"));
    }

    return order;
  }
}

package io.yogh.bl3p.api.v1.response.parser;

import org.json.JSONObject;

import io.yogh.bl3p.api.v1.response.domain.Amount;
import io.yogh.bl3p.api.v1.response.domain.OrderInfo;
import io.yogh.bl3p.api.v1.response.domain.PagedResponse;
import io.yogh.bl3p.api.v1.response.domain.SimpleOrder;

public final class CommonParser {
  private CommonParser() {}

  public static Amount parseAmount(final JSONObject obj) {
    final Amount amount = new Amount();

    amount.setValueInt(Integer.parseInt(obj.getString("value_int")));
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
    final OrderInfo order = new OrderInfo();

    order.setOrderId(orderJson.getInt("order_id"));
    order.setLabel(orderJson.getString("label"));

    order.setCurrency(orderJson.getString("currency"));
    order.setStatus(orderJson.getString("status"));

    order.setDate(orderJson.getLong("date"));

    if (orderJson.has("date_closed")) {
      order.setDateClosed(orderJson.getLong("date_closed"));
    }

    if (orderJson.has("price")) {
      order.setPrice(CommonParser.parseAmount(orderJson.getJSONObject("price")));
    }

    if (orderJson.has("amount")) {
      order.setAmount(CommonParser.parseAmount(orderJson.getJSONObject("amount")));
    }

    if (orderJson.has("amount_funds")) {
      order.setAmountFunds(CommonParser.parseAmount(orderJson.getJSONObject("amount_funds")));
    }

    order.setAmountFundsExecuted(CommonParser.parseAmount(orderJson.getJSONObject("amount_funds_executed")));
    order.setAmountExecuted(CommonParser.parseAmount(orderJson.getJSONObject("amount_executed")));

    return order;
  }

  public static SimpleOrder parseSimpleOrder(final JSONObject orderJson) {
    final SimpleOrder order = new SimpleOrder();
    order.setAmount(orderJson.getInt("amount_int"));
    order.setPrice(orderJson.getInt("price_int"));

    if (orderJson.has("count")) {
      order.setCount(orderJson.getInt("count"));
    }

    return order;
  }
}

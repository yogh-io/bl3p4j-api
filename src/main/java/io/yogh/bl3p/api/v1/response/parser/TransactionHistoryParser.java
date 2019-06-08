package io.yogh.bl3p.api.v1.response.parser;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.JsonNode;

import io.yogh.bl3p.api.v1.response.domain.Bl3pTransaction;
import io.yogh.bl3p.api.v1.response.domain.Bl3pTransaction.Builder;
import io.yogh.bl3p.api.v1.response.domain.TransactionHistory;
import io.yogh.bl3p.api.v1.response.exception.Bl3pException;

public class TransactionHistoryParser extends ResultParser implements Parser<TransactionHistory> {
  @Override
  public TransactionHistory parse(final JsonNode t) throws Bl3pException {
    final JSONObject data = getDataNode(t);
    final TransactionHistory transactionHistory = new TransactionHistory();

    CommonParser.parsePagedResponse(transactionHistory, data);

    final JSONArray transactionsJson = data.getJSONArray("transactions");
    final ArrayList<Bl3pTransaction> transactions = new ArrayList<>();
    for (int i = 0; i < transactionsJson.length(); i++) {
      final JSONObject transactionJson = transactionsJson.getJSONObject(i);

      final Builder bldr = Bl3pTransaction.builder()
          .transactionId(transactionJson.getInt("transaction_id"))
          .timestamp(transactionJson.getInt("date"))
          .amount(CommonParser.parseAmount(transactionJson, "amount"))
          .balance(CommonParser.parseAmount(transactionJson, "balance"))
          .debitCredit(transactionJson.getString("debit_credit"))
          .type(transactionJson.getString("type"));

      if (transactionJson.has("contra_amount")) {
        bldr.contraAmount(CommonParser.parseAmount(transactionJson, "contra_amount"));
      }
      if (transactionJson.has("trade_id")) {
        bldr.tradeId(transactionJson.getInt("trade_id"));
      }
      if (transactionJson.has("price")) {
        bldr.price(CommonParser.parseAmount(transactionJson, "price"));
      }
      if (transactionJson.has("fee")) {
        bldr.fee(CommonParser.parseAmount(transactionJson, "fee"));
      }
      if (transactionJson.has("order_id")) {
        bldr.orderId(transactionJson.getInt("order_id"));
      }

      transactions.add(bldr.build());
    }

    transactionHistory.setTransactions(transactions);

    return transactionHistory;
  }

  public static TransactionHistoryParser create() {
    return new TransactionHistoryParser();
  }
}

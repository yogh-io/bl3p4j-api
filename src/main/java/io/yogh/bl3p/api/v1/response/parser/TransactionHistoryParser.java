package io.yogh.bl3p.api.v1.response.parser;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.JsonNode;

import io.yogh.bl3p.api.v1.response.domain.Bl3pTransaction;
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
      final Bl3pTransaction transaction = new Bl3pTransaction();
      final JSONObject transactionJson = transactionsJson.getJSONObject(i);

      transaction.setTransactionId(transactionJson.getInt("transaction_id"));
      transaction.setTimestamp(transactionJson.getInt("date"));
      transaction.setAmount(CommonParser.parseAmount(transactionJson.getJSONObject("amount")));
      transaction.setBalance(CommonParser.parseAmount(transactionJson.getJSONObject("balance")));
      transaction.setDebitCredit(transactionJson.getString("debit_credit"));
      transaction.setType(transactionJson.getString("type"));

      if (transactionJson.has("contra_amount")) {
        transaction.setContraAmount(CommonParser.parseAmount(transactionJson.getJSONObject("contra_amount")));
      }
      if (transactionJson.has("trade_id")) {
        transaction.setTradeId(transactionJson.getInt("trade_id"));
      }
      if (transactionJson.has("price")) {
        transaction.setPrice(CommonParser.parseAmount(transactionJson.getJSONObject("price")));
      }
      if (transactionJson.has("fee")) {
        transaction.setFee(CommonParser.parseAmount(transactionJson.getJSONObject("fee")));
      }
      if (transactionJson.has("order_id")) {
        transaction.setOrderId(transactionJson.getInt("order_id"));
      }

      transactions.add(transaction);
    }

    transactionHistory.setTransactions(transactions);

    return transactionHistory;
  }

  public static TransactionHistoryParser create() {
    return new TransactionHistoryParser();
  }
}

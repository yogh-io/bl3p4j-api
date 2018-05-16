package io.yogh.bl3p.api.v1.response.parser;

import static io.yogh.bl3p.api.v1.response.parser.CommonParser.parseAmount;

import java.util.HashMap;

import org.json.JSONObject;

import com.mashape.unirest.http.JsonNode;

import io.yogh.bl3p.api.v1.response.domain.AccountBalance;
import io.yogh.bl3p.api.v1.response.domain.WalletInfo;
import io.yogh.bl3p.api.v1.response.exception.Bl3pException;

public class AccountBalanceParser extends ResultParser implements Parser<AccountBalance> {
  @Override
  public AccountBalance parse(final JsonNode t) throws Bl3pException {
    final JSONObject data = getDataNode(t);

    final AccountBalance balance = new AccountBalance();

    balance.setUserId(data.getInt("user_id"));
    balance.setTradeFee(data.getDouble("trade_fee"));

    final HashMap<String, WalletInfo> wallets = new HashMap<>();
    final JSONObject walletsJson = data.getJSONObject("wallets");

    for (final Object key : walletsJson.keySet()) {
      final String keyStr = String.valueOf(key);

      final JSONObject walletJson = walletsJson.getJSONObject(keyStr);
      final WalletInfo wallet = new WalletInfo();
      wallet.setAvailable(parseAmount(walletJson.getJSONObject("available")));
      wallet.setBalance(parseAmount(walletJson.getJSONObject("balance")));

      wallets.put(keyStr, wallet);
    }

    balance.setWallets(wallets);

    return balance;
  }

  public static AccountBalanceParser create() {
    return new AccountBalanceParser();
  }
}

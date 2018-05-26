# Java API Wrapper for the BL3P Exchange

Simple wrapper to approach the full BL3P API from Java.

Example usage:

````java
// Create and initialize the client
Bl3pClient client = Bl3pClient.create()
  .uuid("your-uuid-here")
  .key("your-key-here");

// Determine fiat reserves
AccountBalance balance = client.getAccountBalance();
int fiat = balance.getWallets().get(Currency.EUR.name()).getAvailable().getValueInt();

// Wrap the client in a more intuitive semantic trade utility
SimpleTradeWrapper trader = SimpleTradeWrapper.wrap(client);

// Buy some coins with harmless market buy through trade utility
trader.buyEuroAmount(fiat);

// Hodl
````

Supports the authenticated API, the public API, and the websocket feeds.

Provides synchronous and asynchronous handles for each.

Allows custom calls and custom client creation using Builder pattern.

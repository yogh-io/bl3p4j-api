package io.yogh.bl3p.api.v1;

import java.util.function.Consumer;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.CloseReason.CloseCodes;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientEndpoint
public class WebSocketEndPoint {
  private static final Logger LOG = LoggerFactory.getLogger(WebSocketEndPoint.class);

  private final Consumer<String> consumer;

  private final WebSocketClient client;

  public WebSocketEndPoint(final WebSocketClient client, final Consumer<String> consumer) {
    this.client = client;
    this.consumer = consumer;

    LOG.debug("Created WebSocketEndPoint: {}", this);
  }

  @OnOpen
  public void onOpen() {
    LOG.debug("Opened WebSocketEndPoint");
  }

  @OnMessage
  public void onMessage(final String message) {
    consumer.accept(message);
  }

  @OnClose
  public void onClose(final CloseReason closeReason) {
    if (closeReason.getCloseCode() == CloseCodes.NORMAL_CLOSURE) {
      return;
    }

    LOG.error("Closed WebSocketEndPoint abnormally: {}", closeReason);
    client.reconnect();
  }

  @OnError
  public void onError(final Throwable t) {
    LOG.warn("Error during websocket session", t);
  }

  @Override
  public String toString() {
    return "WebSocketEndPoint [consumer=" + consumer + "]";
  }
}

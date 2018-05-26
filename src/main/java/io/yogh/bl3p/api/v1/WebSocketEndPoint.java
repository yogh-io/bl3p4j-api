package io.yogh.bl3p.api.v1;

import java.util.function.Consumer;

import javax.websocket.ClientEndpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientEndpoint
public class WebSocketEndPoint {
  private static final Logger LOG = LoggerFactory.getLogger(WebSocketEndPoint.class);

  private final Consumer<String> consumer;

  public WebSocketEndPoint(final Consumer<String> consumer) {
    this.consumer = consumer;

    LOG.debug("Created WebSocketEndPoint: {}", this);
  }

  @OnOpen
  public void onOpen(final EndpointConfig conf) {
    LOG.debug("Opened WebSocketEndPoint: {}", conf);
  }

  @OnMessage
  public void onMessage(final String message) {
    consumer.accept(message);
  }

  @OnClose
  public void onClose(final EndpointConfig conf) {
    LOG.debug("Closed WebSocketEndPoint: {}", conf);
  }
}

package io.yogh.bl3p.api.v1;

import java.net.URI;
import java.util.function.Consumer;

import javax.websocket.ContainerProvider;
import javax.websocket.MessageHandler;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.yogh.bl3p.api.v1.request.domain.Market;

public class WebSocketClient implements MessageHandler {
  private static final Logger LOG = LoggerFactory.getLogger(Bl3pClientRequestUtil.class);

  private static final String HOST = "wss://api.bl3p.eu/1/";

  private static Object waitLock = new Object();

  private final Market market;
  private final String channel;
  private final Consumer<String> parser;

  public WebSocketClient(final Market market, final String channel, final Consumer<String> parser) {
    this.market = market;
    this.channel = channel;
    this.parser = parser;
  }

  public void start() {
    new Thread(() -> {
      final WebSocketContainer container = ContainerProvider.getWebSocketContainer();

      final String url = HOST + market.name() + "/" + channel;

      try (final Session session = container.connectToServer(new WebSocketEndPoint(this, parser), URI.create(url))) {
        waitForTerminate();
      } catch (final Exception e) {
        LOG.error("Exception during websocket session.", e);
        // Squelch error.
      }
    }).start();
  }

  private static void waitForTerminate() {
    synchronized (waitLock) {
      try {
        waitLock.wait();
      } catch (final InterruptedException e) {}
    }
  }

  public void terminate() {
    synchronized (waitLock) {
      waitLock.notify();
    }
  }

  public void reconnect() {
    terminate();
    start();
  }
}

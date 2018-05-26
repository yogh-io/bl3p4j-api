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

  public WebSocketClient(final Market market, final String channel, final Consumer<String> parser) {
    final WebSocketContainer container = ContainerProvider.getWebSocketContainer();

    final String url = HOST + market.name() + "/" + channel;

    try (final Session session = container.connectToServer(new WebSocketEndPoint(parser), URI.create(url))) {
      waitForTerminate();
    } catch (final Exception e) {
      LOG.error("Exception during websocket session.", e);
      // Squelch error.
    }
  }

  private static void waitForTerminate() {
    synchronized (waitLock) {
      try {
        waitLock.wait();
      } catch (final InterruptedException e) {}
    }
  }

  public void terminate() {
    waitLock.notifyAll();
  }
}

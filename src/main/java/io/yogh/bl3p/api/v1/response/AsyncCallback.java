package io.yogh.bl3p.api.v1.response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface AsyncCallback<T> {
  static final Logger LOG = LoggerFactory.getLogger(AsyncCallback.class);

  void onSuccess(T result);

  default void onFailure(final Throwable e) {
    LOG.error("Failure in AsyncCallback", e);

    throw new RuntimeException(e);
  }
}

package io.yogh.bl3p.api.v1.response;

public interface AsyncCallback<T> {
  void onSuccess(T result);

  default void onFailure(final Throwable e) {
    throw new RuntimeException(e);
  }
}

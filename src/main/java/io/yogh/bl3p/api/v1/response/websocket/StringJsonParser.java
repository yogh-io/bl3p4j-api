package io.yogh.bl3p.api.v1.response.websocket;

import java.util.function.Function;

public interface StringJsonParser<T> extends Function<String, T> {}

package io.yogh.bl3p.api.v1.request.authenticated;

import java.util.Map.Entry;

import io.yogh.bl3p.api.v1.request.ApiCall;

public class RequestUriBuilder {
  private static final String QUERYSTRING_EQUATER = "=";
  private static final String QUERYSTRING_DELIMITER = "&";

  private static final String SLASH = "/";

  private final ApiCall call;

  public RequestUriBuilder(final ApiCall call) {
    this.call = call;
  }

  public static String getUri(final ApiCall call) {
    return new RequestUriBuilder(call).createUri();
  }

  public static String getPostData(final ApiCall call) {
    return new RequestUriBuilder(call).createPostData();
  }

  private String createUri() {
    final StringBuilder bldr = new StringBuilder();
    bldr.append(call.getMarket());
    if (call.getNamespace() != null) {
      bldr.append(SLASH);
      bldr.append(call.getNamespace());
    }
    bldr.append(SLASH);
    bldr.append(call.getCall());

    if (call.getSubcall() != null) {
      bldr.append(SLASH);
      bldr.append(call.getSubcall());
    }

    return bldr.toString();
  }

  private String createPostData() {
    final StringBuilder bldr = new StringBuilder();

    if (!call.getQueryString().isEmpty()) {
      for (final Entry<String, Object> entry : call.getQueryString().entrySet()) {
        bldr.append(entry.getKey());
        bldr.append(QUERYSTRING_EQUATER);
        bldr.append(entry.getValue());
        bldr.append(QUERYSTRING_DELIMITER);
      }

      bldr.deleteCharAt(bldr.lastIndexOf(QUERYSTRING_DELIMITER));
    }

    return bldr.toString();
  }
}

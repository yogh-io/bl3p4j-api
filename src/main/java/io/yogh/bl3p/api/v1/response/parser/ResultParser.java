package io.yogh.bl3p.api.v1.response.parser;

import org.json.JSONObject;

import com.mashape.unirest.http.JsonNode;

import io.yogh.bl3p.api.v1.response.exception.Bl3pException;
import io.yogh.bl3p.api.v1.response.exception.Bl3pException.Reason;

public class ResultParser {
  private static final String SUCCESS = "success";
  private static final String ERROR = "error";

  protected JSONObject getDataNode(final JsonNode t) throws Bl3pException {
    final String result = t.getObject().getString("result");

    if (ERROR.equals(result)) {
      throw parseBl3pException(t.getObject().getJSONObject("data"));
    } else if (SUCCESS.equals(result)) {
      return t.getObject().getJSONObject("data");
    } else {
      throw new IllegalStateException("Unknown result code received. " + result);
    }
  }

  private Bl3pException parseBl3pException(final JSONObject object) {
    return new Bl3pException(Reason.safeValueOf(object.getString("code")), object.getString("message"));
  }
}

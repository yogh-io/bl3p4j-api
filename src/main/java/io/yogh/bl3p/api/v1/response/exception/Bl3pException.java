package io.yogh.bl3p.api.v1.response.exception;

public class Bl3pException extends Exception {
  private static final long serialVersionUID = 4366828874902810863L;

  private final Reason reason;

  public static enum Reason {
    // Order amount (amount_funds) smaller than the minimum.
    AMOUNT_FUNDS_LESS_THAN_MINIMUM,

    // Order amount is smaller than the minimum
    AMOUNT_LESS_THAN_MINIMUM,

    // Not enough money on account for this order.
    INSUFFICIENT_FUNDS,

    // Invalid field 'amount_int'.
    INVALID_AMOUNT,

    // Invalid field 'amount_funds_int'.
    INVALID_AMOUNT_FUNDS,
    // Invalid field 'fee_currency'.
    INVALID_FEE_CURRENCY,

    // Limitorders can't have both an 'amount' and an 'amount_funds'.
    INVALID_LIMIT_ORDER,

    // Invalid field 'price_int'.
    INVALID_PRICE,

    // Invalid field type (‘bid’ or ‘ask’).
    INVALID_TYPE,

    // The Rest-Key header misses.
    KEY_MISSING,

    // User has done to much calls.
    LIMIT_REACHED,

    // Market (temporarily) closed.
    MARKETPLACE_INACCESSIBLE,

    // Market does (temporarily) not accepts orders.
    MARKETPLACE_NOT_ACCEPTING_ORDERS,

    // The field 'amount' or 'amout_funds' is missing with this order.
    MISSING_AMOUNT,

    // A required field at this call is missing.
    MISSING_FIELD,

    // Signature-key-combination is invalid.
    NOT_AUTHENTICATED,

    // The Rest-Sign header misses.
    SIGN_MISSING,

    // User has no account for given currency (SystemServer)
    UNKNOWN_ACCOUNT,

    // The requested currency doesn't exist.
    UNKNOWN_CURRENCY,

    // An unknown server error occured.
    UNKNOWN_ERROR,

    // The requested market doesn't exist.
    UNKNOWN_MARKETPLACE,

    // The order to cancel or fetch doesn't exist
    UNKNOWN_ORDER,

    // Requested path and/or call doesn't exist.
    UNKNOWN_PATH,

    // Client error (error not originating from Bl3p / custom)
    UNSPECIFIED_CLIENT_ERROR;

    public static Reason safeValueOf(final String name) {
      try {
        return Reason.valueOf(name);
      } catch (final IllegalArgumentException e) {

        return null;
      }
    }
  }

  public Bl3pException(final Reason reason, final String message) {
    super(message);
    this.reason = reason;
  }

  public Bl3pException(final Reason reason, final String message, final Exception e) {
    super(message, e);
    this.reason = reason;
  }

  @Override
  public String getMessage() {
    return "Reason: " + reason.name() + " | " + super.getMessage();
  }

  public Reason getReason() {
    return reason;
  }

  @Override
  public String toString() {
    return "Bl3pException [reason: " + reason + ", message: " + getMessage() + "]";
  }
}

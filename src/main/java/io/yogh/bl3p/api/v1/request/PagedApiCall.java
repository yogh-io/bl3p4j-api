package io.yogh.bl3p.api.v1.request;

public class PagedApiCall extends ApiCall {
  protected PagedApiCall(final Builder<?, ?> builder) {
    super(builder);
    addRequestParameter(ApiCallNames.PAGE, builder.page);
    addRequestParameter(ApiCallNames.DATE_FROM, builder.dateFrom);
    addRequestParameter(ApiCallNames.DATE_TO, builder.dateTo);
    addRequestParameter(ApiCallNames.RECORDS_PER_PAGE, builder.recordsPerPage);
  }

  public abstract static class Builder<T extends PagedApiCall, B extends Builder<T, B>> extends ApiCall.Builder<T, B> {
    private Integer page;
    private Integer dateFrom;
    private Integer dateTo;
    private Integer recordsPerPage;

    protected Builder() {}

    public B page(final Integer page) {
      this.page = page;
      return self();
    }

    public B dateFrom(final Integer dateFrom) {
      this.dateFrom = dateFrom;
      return self();
    }

    public B dateTo(final Integer dateTo) {
      this.dateTo = dateTo;
      return self();
    }

    public B recordsPerPage(final Integer recordsPerPage) {
      this.recordsPerPage = recordsPerPage;
      return self();
    }
  }
}

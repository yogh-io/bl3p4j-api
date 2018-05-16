package io.yogh.bl3p.api.v1.response.domain;

public class AbstractPagedResponse implements PagedResponse {
  private int page;
  private int records;
  private int maxPage;

  @Override
  public int getPage() {
    return page;
  }

  @Override
  public void setPage(final int page) {
    this.page = page;
  }

  @Override
  public int getRecords() {
    return records;
  }

  @Override
  public void setRecords(final int records) {
    this.records = records;
  }

  @Override
  public int getMaxPage() {
    return maxPage;
  }

  @Override
  public void setMaxPage(final int maxPage) {
    this.maxPage = maxPage;
  }

  @Override
  public String toString() {
    return "AbstractPagedResponse [page=" + page + ", records=" + records + ", maxPage=" + maxPage + "]";
  }
}

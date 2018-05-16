package io.yogh.bl3p.api.v1.response.domain;

public interface PagedResponse {
  public int getPage();

  public void setPage(final int page);

  public int getRecords();

  public void setRecords(final int records);

  public int getMaxPage();

  public void setMaxPage(final int maxPage);
}

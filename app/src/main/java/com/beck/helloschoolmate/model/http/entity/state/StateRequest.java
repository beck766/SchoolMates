package com.beck.helloschoolmate.model.http.entity.state;

/**
 * Created by beck on 2018/8/13.
 */

public class StateRequest {
    /**
     * page : 0
     * pageCount : 0
     */

    private int page;
    private int pageCount;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}

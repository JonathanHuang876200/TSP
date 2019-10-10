
package com.eland.getResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseList {

    @SerializedName("search_id")
    @Expose
    private Object searchId;
    @SerializedName("valid_count")
    @Expose
    private Integer validCount;
    @SerializedName("total_count")
    @Expose
    private Integer totalCount;
    @SerializedName("query_time")
    @Expose
    private Double queryTime;

    public Object getSearchId() {
        return searchId;
    }

    public void setSearchId(Object searchId) {
        this.searchId = searchId;
    }

    public Integer getValidCount() {
        return validCount;
    }

    public void setValidCount(Integer validCount) {
        this.validCount = validCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Double getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(Double queryTime) {
        this.queryTime = queryTime;
    }

}

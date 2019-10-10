
package com.eland.getRequest;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetRequest {

    @SerializedName("query_type")
    @Expose
    private String queryType;
    @SerializedName("keyword")
    @Expose
    private String keyword;
    @SerializedName("target_db")
    @Expose
    private List<String> targetDb = null;
    @SerializedName("search_range")
    @Expose
    private SearchRange searchRange;
    @SerializedName("field_filter")
    @Expose
    private FieldFilter fieldFilter;
    @SerializedName("result_field")
    @Expose
    private List<String> resultField = null;

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<String> getTargetDb() {
        return targetDb;
    }

    public void setTargetDb(List<String> targetDb) {
        this.targetDb = targetDb;
    }

    public SearchRange getSearchRange() {
        return searchRange;
    }

    public void setSearchRange(SearchRange searchRange) {
        this.searchRange = searchRange;
    }

    public FieldFilter getFieldFilter() {
        return fieldFilter;
    }

    public void setFieldFilter(FieldFilter fieldFilter) {
        this.fieldFilter = fieldFilter;
    }

    public List<String> getResultField() {
        return resultField;
    }

    public void setResultField(List<String> resultField) {
        this.resultField = resultField;
    }

}

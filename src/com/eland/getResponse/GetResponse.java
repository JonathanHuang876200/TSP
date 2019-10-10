
package com.eland.getResponse;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetResponse {

    @SerializedName("response_list")
    @Expose
    private ResponseList responseList;
    @SerializedName("indexdb_info")
    @Expose
    private IndexdbInfo indexdbInfo;
    @SerializedName("category_tree")
    @Expose
    private CategoryTree categoryTree;
    @SerializedName("result_list")
    @Expose
    private List<ResultList> resultList = null;
    @SerializedName("error_code")
    @Expose
    private String errorCode;
    @SerializedName("error_msg")
    @Expose
    private String errorMsg;

    public ResponseList getResponseList() {
        return responseList;
    }

    public void setResponseList(ResponseList responseList) {
        this.responseList = responseList;
    }

    public IndexdbInfo getIndexdbInfo() {
        return indexdbInfo;
    }

    public void setIndexdbInfo(IndexdbInfo indexdbInfo) {
        this.indexdbInfo = indexdbInfo;
    }

    public CategoryTree getCategoryTree() {
        return categoryTree;
    }

    public void setCategoryTree(CategoryTree categoryTree) {
        this.categoryTree = categoryTree;
    }

    public List<ResultList> getResultList() {
        return resultList;
    }

    public void setResultList(List<ResultList> resultList) {
        this.resultList = resultList;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}

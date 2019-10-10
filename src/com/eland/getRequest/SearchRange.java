
package com.eland.getRequest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchRange {

    @SerializedName("start_pos")
    @Expose
    private Integer startPos;
    @SerializedName("max_record")
    @Expose
    private Integer maxRecord;

    public Integer getStartPos() {
        return startPos;
    }

    public void setStartPos(Integer startPos) {
        this.startPos = startPos;
    }

    public Integer getMaxRecord() {
        return maxRecord;
    }

    public void setMaxRecord(Integer maxRecord) {
        this.maxRecord = maxRecord;
    }

}

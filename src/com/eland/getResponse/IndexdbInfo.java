
package com.eland.getResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IndexdbInfo {

    @SerializedName("Database")
    @Expose
    private Integer database;

    public Integer getDatabase() {
        return database;
    }

    public void setDatabase(Integer database) {
        this.database = database;
    }

}

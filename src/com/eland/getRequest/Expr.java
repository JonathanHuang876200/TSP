
package com.eland.getRequest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Expr {

    @SerializedName("and")
    @Expose
    private And and;

    public And getAnd() {
        return and;
    }

    public void setAnd(And and) {
        this.and = and;
    }

}

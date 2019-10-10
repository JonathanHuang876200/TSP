
package com.eland.getRequest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class And {

    @SerializedName("expr_string")
    @Expose
    private String exprString;
    @SerializedName("field_map")
    @Expose
    private FieldMap fieldMap;

    public String getExprString() {
        return exprString;
    }

    public void setExprString(String exprString) {
        this.exprString = exprString;
    }

    public FieldMap getFieldMap() {
        return fieldMap;
    }

    public void setFieldMap(FieldMap fieldMap) {
        this.fieldMap = fieldMap;
    }

}


package com.eland.getRequest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PriceFilter {

    @SerializedName("Price")
    @Expose
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}

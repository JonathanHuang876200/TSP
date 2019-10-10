
package com.eland.getRequest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FieldMap {

    @SerializedName("DateFilter")
    @Expose
    private DateFilter dateFilter;
    @SerializedName("PriceFilter")
    @Expose
    private PriceFilter priceFilter;
    @SerializedName("LanguageFilter")
    @Expose
    private LanguageFilter languageFilter;

    public DateFilter getDateFilter() {
        return dateFilter;
    }

    public void setDateFilter(DateFilter dateFilter) {
        this.dateFilter = dateFilter;
    }

    public PriceFilter getPriceFilter() {
        return priceFilter;
    }

    public void setPriceFilter(PriceFilter priceFilter) {
        this.priceFilter = priceFilter;
    }

    public LanguageFilter getLanguageFilter() {
        return languageFilter;
    }

    public void setLanguageFilter(LanguageFilter languageFilter) {
        this.languageFilter = languageFilter;
    }

}


package com.eland.getResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultList {

    @SerializedName("Author")
    @Expose
    private String author;
    @SerializedName("BrowseNum")
    @Expose
    private String browseNum;
    @SerializedName("Content")
    @Expose
    private String content;
    @SerializedName("Date")
    @Expose
    private String date;
    @SerializedName("Language")
    @Expose
    private String language;
    @SerializedName("Price")
    @Expose
    private String price;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("DateOnly")
    @Expose
    private String dateOnly;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBrowseNum() {
        return browseNum;
    }

    public void setBrowseNum(String browseNum) {
        this.browseNum = browseNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateOnly() { return dateOnly; }

    public void setDateOnly(String dateOnly) { this.dateOnly = dateOnly; }

}

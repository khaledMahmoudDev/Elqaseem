
package com.example.elqaseem.dataModel;

import com.google.gson.annotations.SerializedName;

public class Pagination {

    @SerializedName("ad")
    private Ad mAd;

    @SerializedName("count")
    private Long mCount;

    @SerializedName("current")
    private Long mCurrent;

    @SerializedName("next")
    private String mNext;

    @SerializedName("pages")
    private Long mPages;

    @SerializedName("previous")
    private Object mPrevious;

    public Ad getAd() {
        return mAd;
    }

    public void setAd(Ad ad) {
        mAd = ad;
    }

    public Long getCount() {
        return mCount;
    }

    public void setCount(Long count) {
        mCount = count;
    }

    public Long getCurrent() {
        return mCurrent;
    }

    public void setCurrent(Long current) {
        mCurrent = current;
    }

    public String getNext() {
        return mNext;
    }

    public void setNext(String next) {
        mNext = next;
    }

    public Long getPages() {
        return mPages;
    }

    public void setPages(Long pages) {
        mPages = pages;
    }

    public Object getPrevious() {
        return mPrevious;
    }

    public void setPrevious(Object previous) {
        mPrevious = previous;
    }

}

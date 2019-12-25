
package com.example.elqaseem.dataModel;

import com.google.gson.annotations.SerializedName;

public class RealOffer {

    @SerializedName("days")
    private Object mDays;
    @SerializedName("weekends")
    private Object mWeekends;

    public Object getDays() {
        return mDays;
    }

    public void setDays(Object days) {
        mDays = days;
    }

    public Object getWeekends() {
        return mWeekends;
    }

    public void setWeekends(Object weekends) {
        mWeekends = weekends;
    }

}

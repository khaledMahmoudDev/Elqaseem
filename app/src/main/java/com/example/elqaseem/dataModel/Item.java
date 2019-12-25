
package com.example.elqaseem.dataModel;

import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("address")
    private String mAddress;

    @SerializedName("available")
    private Boolean mAvailable;

    @SerializedName("faved")
    private Boolean mFaved;

    @SerializedName("holiday_price")
    private Double mHolidayPrice;

    @SerializedName("id")
    private Long mId;

    @SerializedName("image")
    private String mImage;

    @SerializedName("location")
    private String mLocation;

    @SerializedName("name")
    private String mName;

    @SerializedName("offer")
    private Object mOffer;

    @SerializedName("price")
    private Double mPrice;

    @SerializedName("rate")
    private Double mRate;

    @SerializedName("rate_count")
    private Long mRateCount;

    @SerializedName("real_offer")
    private RealOffer mRealOffer;

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public Boolean getAvailable() {
        return mAvailable;
    }

    public void setAvailable(Boolean available) {
        mAvailable = available;
    }

    public Boolean getFaved() {
        return mFaved;
    }

    public void setFaved(Boolean faved) {
        mFaved = faved;
    }

    public Double getHolidayPrice() {
        return mHolidayPrice;
    }

    public void setHolidayPrice(Double holidayPrice) {
        mHolidayPrice = holidayPrice;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Object getOffer() {
        return mOffer;
    }

    public void setOffer(Object offer) {
        mOffer = offer;
    }

    public Double getPrice() {
        return mPrice;
    }

    public void setPrice(Double price) {
        mPrice = price;
    }

    public Double getRate() {
        return mRate;
    }

    public void setRate(Double rate) {
        mRate = rate;
    }

    public Long getRateCount() {
        return mRateCount;
    }

    public void setRateCount(Long rateCount) {
        mRateCount = rateCount;
    }

    public RealOffer getRealOffer() {
        return mRealOffer;
    }

    public void setRealOffer(RealOffer realOffer) {
        mRealOffer = realOffer;
    }

}

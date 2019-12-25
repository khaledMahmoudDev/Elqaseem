
package com.example.elqaseem.dataModel;

import com.google.gson.annotations.SerializedName;

public class Ad {

    @SerializedName("photo")
    private String mPhoto;

    @SerializedName("url")
    private String mUrl;

    public String getPhoto() {
        return mPhoto;
    }

    public void setPhoto(String photo) {
        mPhoto = photo;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

}

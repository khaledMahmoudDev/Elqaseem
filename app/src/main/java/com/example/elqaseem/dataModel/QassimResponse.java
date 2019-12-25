
package com.example.elqaseem.dataModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class QassimResponse {

    @SerializedName("data")
    private List<Item> mData;

    @SerializedName("errors")
    private List<Object> mErrors;

    @SerializedName("message")
    private String mMessage;

    @SerializedName("pagination")
    private Pagination mPagination;

    @SerializedName("status")
    private Long mStatus;

    @SerializedName("status_code")
    private Long mStatusCode;

    public List<Item> getData() {
        return mData;
    }

    public void setData(List<Item> data) {
        mData = data;
    }

    public List<Object> getErrors() {
        return mErrors;
    }

    public void setErrors(List<Object> errors) {
        mErrors = errors;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public Pagination getPagination() {
        return mPagination;
    }

    public void setPagination(Pagination pagination) {
        mPagination = pagination;
    }

    public Long getStatus() {
        return mStatus;
    }

    public void setStatus(Long status) {
        mStatus = status;
    }

    public Long getStatusCode() {
        return mStatusCode;
    }

    public void setStatusCode(Long statusCode) {
        mStatusCode = statusCode;
    }

}

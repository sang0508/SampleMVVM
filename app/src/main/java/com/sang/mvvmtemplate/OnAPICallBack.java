package com.sang.mvvmtemplate;

public interface OnAPICallBack {
    void apiSuccess(String key, Object data);
    void apiFailure(String key, int code, Object data);
}

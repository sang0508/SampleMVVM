package com.sang.mvvmtemplate.view;

public interface OnMainCallBack {
    void showFragment(String tag, Object data, boolean isBacked);
    void backToPrevious();
}

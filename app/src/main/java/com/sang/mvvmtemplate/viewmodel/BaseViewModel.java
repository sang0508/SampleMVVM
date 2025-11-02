package com.sang.mvvmtemplate.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.sang.mvvmtemplate.OnAPICallBack;

import com.sang.mvvmtemplate.api.API;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseViewModel extends ViewModel {
    private static final String TAG = BaseViewModel.class.getName();
    private static final String BASE_URL = "";

    protected OnAPICallBack callBack;


    public void setCallBack(OnAPICallBack callBack) {
        this.callBack = callBack;
    }

    protected final API getAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().callTimeout(30, TimeUnit.SECONDS).build())
                .build();

        return retrofit.create(API.class);
    }

    protected <T> Callback<T> initHandleResponse(String key){
        return new Callback<T>() {
            @Override
            public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
                if(response.code() == 200 || response.code() == 201){
                    assert response.body() != null;
                    handleSuccess(key, response.body());
                }else {
                    handleFailure(key, response.code(), response.errorBody());
                }
            }

            @Override
            public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
                handleException(key, t);
            }
        };
    }

    protected void handleException(String key, Throwable t) {
        callBack.apiFailure(key, 999, t.getMessage());
    }

    protected void handleFailure(String key, int code, ResponseBody responseBody) {
        String errorMessage = "Unknown error";
        if (responseBody != null) {
            try {
                errorMessage = responseBody.string();
            } catch (Exception e) {
                Log.e(TAG, "Error parsing responseBody: " + e.getMessage());
                errorMessage = e.getMessage();
            }
        }
        Log.e(TAG, "handleFailure: key=" + key + ", code=" + code + ", error=" + errorMessage);
        callBack.apiFailure(key, code, errorMessage);
    }

    protected void handleSuccess(String key, Object body) {
        Log.d(TAG, "API success for key: " + key + ", Full Data: " + new Gson().toJson(body));
        callBack.apiSuccess(key, body);

    }




}

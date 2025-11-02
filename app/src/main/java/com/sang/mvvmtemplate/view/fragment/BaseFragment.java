package com.sang.mvvmtemplate.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

import com.sang.mvvmtemplate.OnAPICallBack;
import com.sang.mvvmtemplate.view.OnMainCallBack;
import com.sang.mvvmtemplate.viewmodel.BaseViewModel;

public abstract class BaseFragment<B extends ViewBinding, V extends BaseViewModel> extends Fragment implements View.OnClickListener, OnAPICallBack {
    protected Context context;
    protected B binding;
    protected V viewModel;
    protected OnMainCallBack callBack;
    protected Object mData;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = initViewBinding(inflater, container);
        viewModel = new ViewModelProvider(this).get(getClassViewModel());
        viewModel.setCallBack(this);
        initViews();
        return binding.getRoot();
    }

    @Override
    public final void onClick(View view) {
//        view.startAnimation(AnimationUtils.loadAnimation(context, androidx.appcompat.R.anim.abc_fade_in));
        clickView(view);
    }

    protected void clickView(View view) {
        // do nothing
    }

    public final void setCallBack(OnMainCallBack callBack) {
        this.callBack = callBack;
    }

    protected abstract void initViews();

    protected abstract Class<V> getClassViewModel();

    protected abstract B initViewBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container);

    public void setData(Object data) {
        mData = data;
    }

    protected final void notify(String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    protected final void notify(int message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void apiSuccess(String key, Object data) {
        // do nothing
    }

    @Override
    public void apiFailure(String key, int code, Object data) {
            Toast.makeText(context, "Error: " + code + ", " + data, Toast.LENGTH_SHORT).show();
    }
}

package com.sang.mvvmtemplate.view.activity;

import android.speech.tts.TextToSpeech;

import com.sang.mvvmtemplate.databinding.ActivityMainBinding;
import com.sang.mvvmtemplate.viewmodel.BaseViewModel;

public class MainActivity extends BaseActivity<ActivityMainBinding, BaseViewModel> {

    private TextToSpeech t1;
    private static final String TAG = MainActivity.class.getName();
    @Override
    protected void initViews() {

    }

    @Override
    protected ActivityMainBinding initViewBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    @Override
    protected Class<BaseViewModel> initViewModel() {
        return BaseViewModel.class;
    }

    @Override
    public void backToPrevious() {
        onBackPressed();
    }
}
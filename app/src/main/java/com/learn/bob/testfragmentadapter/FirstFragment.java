package com.learn.bob.testfragmentadapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/1/7.
 */

public class FirstFragment extends BaseFragment {

    private Context mContext;
    private TextView mTvFirst;
    private String txtStr;

    public FirstFragment(){}

    public FirstFragment(String str){
        this.txtStr = str;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getActivity();
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTvFirst = (TextView)getActivity().findViewById(R.id.txt_first);
        initView();
    }

    private void initView(){
        if(null != onChangePageListener){
            onChangePageListener.onFloatButtonClick();
        }
        mTvFirst.setText(txtStr);
    }

    public interface OnChangePageListener{
        public void onFloatButtonClick();
    }

    private OnChangePageListener onChangePageListener;

    public void setOnChangePageListener(OnChangePageListener onChangePageListener){
        this.onChangePageListener = onChangePageListener;
    }

    public void setText(String str){
        mTvFirst.setText(str);
    }

}

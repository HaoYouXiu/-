package com.bwei.model.fangjingdong.viewpager.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwei.model.fangjingdong.R;

/**
 * date:2018/11/29
 * author:郝仁（Thinkpad)
 * function:
 */
public class CategoryFragement extends Fragment{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categoty, container, false);
        return view;
    }
}

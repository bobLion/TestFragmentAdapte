package com.learn.bob.testfragmentadapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;


public class BaseFragment extends Fragment {

	public int dialogTheme;

	public Context mContext;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onResume() {
		super.onResume();
	}

}

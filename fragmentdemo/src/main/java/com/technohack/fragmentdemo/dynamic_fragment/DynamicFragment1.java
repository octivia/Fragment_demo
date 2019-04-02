package com.technohack.fragmentdemo.dynamic_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technohack.fragmentdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DynamicFragment1 extends Fragment {


    public DynamicFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dynamic_fragment1, container, false);
    }

}

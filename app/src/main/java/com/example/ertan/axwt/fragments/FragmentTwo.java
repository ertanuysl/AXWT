package com.example.ertan.axwt.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ertan.axwt.R;

public class FragmentTwo extends Fragment {

    public FragmentTwo() {
        Log.i("EMRE", "Fragment Two Oluşturuldu");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_two, container, false);
    }
}

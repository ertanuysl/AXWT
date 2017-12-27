package com.example.ertan.axwt.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ertan.axwt.R;
import com.example.ertan.axwt.wf_List.wf_Adapter;
import com.example.ertan.axwt.wf_List.wf_data;


public class FragmentOne extends Fragment {


    private static final String TAG = "RecyclerViewFragment";
    public FragmentOne() {
        Log.i("ERTAN", "Fragment One Oluşturuldu");
    }
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       // View rootView = inflater.inflate(R.layout.fragment_one,container, false);
        //Recylview çağırıyoruz
        View view = inflater.inflate(R.layout.fragment_one, container, false);

            recyclerView= (RecyclerView) view.findViewById(R.id.recyclerview1);

            wf_Adapter wf_ertan=new wf_Adapter(getContext(), wf_data.getData());
            recyclerView.setAdapter(wf_ertan);

            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);


        return view;

    }

}

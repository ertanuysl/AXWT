package com.example.ertan.axwt.wf_List;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ertan.axwt.R;

import com.example.ertan.axwt.wf_Detail_List.wf_Detail_List;

import java.util.ArrayList;

public class wf_Adapter extends RecyclerView.Adapter<wf_Adapter.MyViewHolder> {

    ArrayList<wf_data> mDataList;
    LayoutInflater inflater;

    public wf_Adapter(Context context, ArrayList<wf_data> data) {

        //inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater = LayoutInflater.from(context);

        this.mDataList = data;


    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View v = inflater.inflate(R.layout.wf_list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        wf_data tiklanilanManzara = mDataList.get(position);
        holder.setData(tiklanilanManzara, position);

    }

    /*public void deleteItem(int position) {
        mDataList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mDataList.size());

        //Aşağıdaki method yukarıdaki iki satır kodun yaptığı işi yapar,
        //Ama çok kaynak tüketilir. ve de animasyonları göremeyiz.
        //notifyDataSetChanged();
    }

    public void addItem(int position, wf_data kopyalanacakManzara) {
        mDataList.add(position, kopyalanacakManzara);
        notifyItemInserted(position);
        notifyItemRangeChanged(position, mDataList.size());

        //Aşağıdaki method yukarıdaki iki satır kodun yaptığı işi yapar,
        //Ama çok kaynak tüketilir. ve de animasyonları göremeyiz.
        //notifyDataSetChanged();
    }
*/

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView wfDataTitle, wfDataName,wfDataPrice,wfDataDate;
        RecyclerView wfRecyclerView;
        int tiklanilanOgeninPositionDegeri = 0;
        wf_data kopyalanacakManzara;

        public wf_data data;
        MyViewHolder(View itemView) {
            super(itemView);

            wfDataTitle = (TextView) itemView.findViewById(R.id.wf_title);
            wfDataName= (TextView) itemView.findViewById(R.id.wf_name);
            wfDataPrice = (TextView) itemView.findViewById(R.id.wf_price);
            wfDataDate= (TextView) itemView.findViewById(R.id.wf_date);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(v.getContext(), wf_Detail_List.class);
                    v.getContext().startActivity(intent);
                    Toast.makeText(v.getContext(), "os version is: "+ tiklanilanOgeninPositionDegeri, Toast.LENGTH_SHORT).show();
                }
            });

           /* mSilResmi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });*/

           /* mKopyalaResmi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                 }
            });*/


        }

        public void setData(wf_data tiklanilanManzara, int position) {
            this.wfDataTitle.setText(tiklanilanManzara.getWf_title());
            this.wfDataName.setText(tiklanilanManzara.getWf_name());
            this.wfDataPrice.setText(tiklanilanManzara.getWf_price());
            this.tiklanilanOgeninPositionDegeri = position;
            this.kopyalanacakManzara = tiklanilanManzara;
        }
    }
}
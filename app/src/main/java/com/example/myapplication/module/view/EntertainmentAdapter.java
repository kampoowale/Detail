package com.example.myapplication.module.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.module.model.EntertainmentzModel;
import com.example.myapplication.module.model.Item;

import java.util.List;

public class EntertainmentAdapter extends RecyclerView.Adapter<EntertainmentAdapter.CustomViewHolder> {

    private List<Item> dataList;
    private Context context;

    public EntertainmentAdapter(Context context,List<Item> dataList){
        this.context = context;
        this.dataList = dataList;
    }



    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        TextView txtTitle;
        TextView category;
        TextView media;


        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            txtTitle = (TextView) mView.findViewById(R.id.title);
            category = (TextView) mView.findViewById(R.id.category);
            media = (TextView) mView.findViewById(R.id.media);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.entertainment_adapter, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.txtTitle.setText(dataList.get(position).getTitle());
        try {
           holder.category.setText(String.valueOf(dataList.get(position).getCategory()));
        }
        catch(Exception e){

        }
        try {
            holder.media.setText(dataList.get(position).getMedia());
        }
        catch(Exception e){

        }

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

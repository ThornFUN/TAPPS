package com.demo.thorn.tapps.ui.adapter;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.demo.thorn.tapps.R;
import com.demo.thorn.tapps.databean.PhotoBean;

import java.util.ArrayList;


/**
 * Created by pengj on 2018-6-20.
 * Github https://github.com/ThornFUN
 * Function:
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder>{

    ArrayList<PhotoBean.ResultsBean> resultsBeans;
    Context context;

    public GalleryAdapter(ArrayList<PhotoBean.ResultsBean> resultsBeans) {
        this.resultsBeans = resultsBeans;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(context == null){
            this.context = parent.getContext();
        }
        View itemview = LayoutInflater.from(context).inflate(R.layout.item_gallery,parent,false);

        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PhotoBean.ResultsBean resultsBean = resultsBeans.get(position);
        holder.textView.setText(resultsBean.get_id());
        Glide.with(context).load(resultsBean.getUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return resultsBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView)itemView;
            imageView = itemView.findViewById(R.id.iv_item_image);
            textView = itemView.findViewById(R.id.tv_item_text);
        }
    }
}

package com.example.daytona.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.daytona.R;
import com.example.daytona.bean.HotBean;

import java.util.ArrayList;

public class RlvHotAdapter extends RecyclerView.Adapter<RlvHotAdapter.ViewHolder> {

    private Context context;
    private ArrayList<HotBean.RecentBean> list;

    public RlvHotAdapter(Context context, ArrayList<HotBean.RecentBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.zhihu_hot_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tv.setText(list.get(i).getTitle());
        Glide.with(context).load(list.get(i).getThumbnail()).into(viewHolder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.hotiv);
            tv = itemView.findViewById(R.id.hottv);
        }
    }
}

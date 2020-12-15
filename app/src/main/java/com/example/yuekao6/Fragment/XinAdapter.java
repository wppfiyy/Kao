package com.example.yuekao6.Fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.yuekao6.Ben.XinBen;
import com.example.yuekao6.R;

import java.util.ArrayList;

class XinAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<XinBen.NewsBean> xinList;

    public XinAdapter(Context context, ArrayList<XinBen.NewsBean> xinList) {
        this.context = context;
        this.xinList = xinList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.xin_item, parent, false);
        return new XinViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        XinBen.NewsBean newsBean = xinList.get(position);
        XinViewHolder xinViewHolder= (XinViewHolder) holder;
        xinViewHolder.title.setText(newsBean.getTile());
        xinViewHolder.desc.setText(newsBean.getContent());
        Glide.with(context).load(newsBean.getImageUrl()).into(xinViewHolder.img);
    }

    @Override
    public int getItemCount() {
        return xinList.size();
    }

    private class XinViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title;
        TextView desc;
        public XinViewHolder(View root) {
            super(root);
            img=root.findViewById(R.id.img);
            title=root.findViewById(R.id.title);
            desc=root.findViewById(R.id.desc);
        }
    }
}

package com.example.yuekao6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.yuekao6.Ben.BannerBen;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

class BannAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<BannerBen.BannerlistBean> bannerList;

    public BannAdapter(Context context, ArrayList<BannerBen.BannerlistBean> bannerList) {
        this.context = context;
        this.bannerList = bannerList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.banner_item, parent, false);
        return new BannerViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        BannerViewHolder bannerViewHolder= (BannerViewHolder) holder;
        bannerViewHolder.banner.setImages(bannerList).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                BannerBen.BannerlistBean bannerlistBean = bannerList.get(position);
                BannerBen.BannerlistBean pen= (BannerBen.BannerlistBean) path;
                Glide.with(context).load(bannerlistBean.getImageurl()).into(imageView);
            }
        }).start();
    }

    @Override
    public int getItemCount() {
        return bannerList.size();
    }

    private class BannerViewHolder extends RecyclerView.ViewHolder {
        Banner banner;
        public BannerViewHolder(View root) {
            super(root);
            banner=root.findViewById(R.id.banner);
        }
    }
}

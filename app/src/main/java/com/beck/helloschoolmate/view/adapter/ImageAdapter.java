package com.beck.helloschoolmate.view.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.beck.helloschoolmate.R;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by beck on 2018/8/14.
 */

public class ImageAdapter extends BaseAdapter {

    private List<String> imageList;
    private Context context;

    public ImageAdapter(Context context, List<String> imageList) {
        this.context = context;
        this.imageList = imageList;
    }

    @Override
    public int getCount() {
        return imageList == null ? 0 : imageList.size();
    }

    @Override
    public Object getItem(int position) {
        return imageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        @SuppressLint("ViewHolder") View view = LayoutInflater.from(context).inflate(R.layout.item_my_state_img, parent, false);
        ImageView iv_state_pic = (ImageView) view.findViewById(R.id.iv_item_my_state_pic);
        Glide.with(context).load(imageList.get(position)).error(R.mipmap.user_icon).into(iv_state_pic);
        return view;
    }

}

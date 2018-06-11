package com.beck.helloschoolmate.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.beck.base.adapter.BaseRecyclerViewAdapter;
import com.beck.helloschoolmate.R;
import com.beck.helloschoolmate.model.http.entity.friend.FriendResponse;
import com.beck.helloschoolmate.view.widget.CircleImageView;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by beck on 2018/5/31.
 */

public class MyFriendAdapter extends BaseRecyclerViewAdapter<MyFriendAdapter.ViewHolder> {

    private Context context;
    private List<FriendResponse.ResultBean> resultBeanList;

    public MyFriendAdapter(Context context, List<FriendResponse.ResultBean> resultBean) {
        this.context = context;
        this.resultBeanList = resultBean;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_linkman, parent, false);
        return new ViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FriendResponse.ResultBean resultBean = resultBeanList.get(position);
        Glide.with(context).load(resultBean.getFriendIcon()).error(R.mipmap.user_icon).into(holder.civFriend);
        holder.tvLinkmanRemarkName.setText(resultBean.getFriendName());
        holder.tvLinkmanSignature.setText("4G在线");
    }

    @Override
    public int getItemCount() {
        return resultBeanList != null ? resultBeanList.size() : 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.civ_friend)
        CircleImageView civFriend;

        @BindView(R.id.tv_linkman_remarkName)
        TextView tvLinkmanRemarkName;

        @BindView(R.id.tv_linkman_signature)
        TextView tvLinkmanSignature;

        public ViewHolder(View itemView, MyFriendAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> adapter.onItemHolderClick(ViewHolder.this));
            itemView.setOnLongClickListener(v -> {
                adapter.onItemLongHolderClick(ViewHolder.this);
                return true;
            });
        }
    }
}

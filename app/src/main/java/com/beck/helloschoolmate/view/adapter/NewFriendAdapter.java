package com.beck.helloschoolmate.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.beck.base.adapter.BaseRecyclerViewAdapter;
import com.beck.helloschoolmate.R;
import com.beck.helloschoolmate.model.http.entity.friend.NewFriendResponse;
import com.beck.helloschoolmate.view.widget.CircleImageView;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by beck on 2018/6/7.
 */

public class NewFriendAdapter extends BaseRecyclerViewAdapter<NewFriendAdapter.ViewHolder> {

    private static final String TAG = "NewFriendAdapter";
    private Context context;
    private List<NewFriendResponse.ResultBean> newFriendBeans;

    public NewFriendAdapter(Context context, List<NewFriendResponse.ResultBean> newFriendBeans) {
        this.context = context;
        this.newFriendBeans = newFriendBeans;
    }

    @Override
    public NewFriendAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_newfriend_check, parent, false);
        return new ViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NewFriendResponse.ResultBean resultBean = newFriendBeans.get(position);
        Glide.with(context).load(resultBean.getRequesterIcon()).error(R.mipmap.user_icon).into(holder.civNewFriendIcon);
        holder.tvNewFriendName.setText(resultBean.getRequesterNickName());
        if (resultBean.getMessage() != null && resultBean.getMessage().isEmpty()) {
            holder.tvNewFriendMessage.setText(resultBean.getMessage());
        } else {
            holder.tvNewFriendMessage.setText("请求添加为好友");
        }
        if (resultBean.getRequestStatus() == 1) {
            holder.tvNewFriendState.setVisibility(View.GONE);
        } else {
            holder.tvNewFriendState.setVisibility(View.VISIBLE);
            holder.btnNewFriendAgreed.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return newFriendBeans != null ? newFriendBeans.size() : 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.civ_new_friend_icon)
        CircleImageView civNewFriendIcon;

        @BindView(R.id.tv_new_friend_name)
        TextView tvNewFriendName;

        @BindView(R.id.tv_new_friend_message)
        TextView tvNewFriendMessage;

        @BindView(R.id.btn_new_friend_agreed)
        Button btnNewFriendAgreed;

        @BindView(R.id.tv_new_friend_state)
        TextView tvNewFriendState;

        ViewHolder(View itemView, NewFriendAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            /*itemView.setOnClickListener(v -> adapter.onItemHolderClick(ViewHolder.this));
            itemView.setOnLongClickListener(v -> {
                adapter.onItemLongHolderClick(ViewHolder.this);
                return true;
            });*/
        }
    }
}
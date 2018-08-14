package com.beck.helloschoolmate.view.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.beck.base.adapter.BaseRecyclerViewAdapter;
import com.beck.helloschoolmate.R;
import com.beck.helloschoolmate.model.http.entity.state.StateResponse;
import com.beck.helloschoolmate.view.widget.MyGridView;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by beck on 2018/8/13.
 */

public class StateAdapter extends BaseRecyclerViewAdapter<StateAdapter.ViewHolder> {

    private static final String TAG = "StateAdapter";
    private List<StateResponse.ResultBean> resultBeans;
    private Context context;

    public StateAdapter(Context context, List<StateResponse.ResultBean> resultBeans) {
        this.resultBeans = resultBeans;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_state, parent, false);
        return new ViewHolder(view, this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        StateResponse.ResultBean resultBean = resultBeans.get(position);
        Glide.with(context).load(resultBean.getPublisherIcon()).error(R.mipmap.user_icon).into(holder.ivMyStateIcon);
        holder.tvMyStateName.setText(resultBean.getPublisherName());
        //holder.tvMyStateClass.setText(resultBean.get);
        holder.tvMyState.setText(resultBean.getContent());
        holder.tvMyStateTime.setText(resultBean.getPublishTime());
        holder.tvMyStateCount.setText(resultBean.getViewNum() + "浏览");
        if (resultBean.getPraiseNum() == 0) {
            holder.ivMyStateLike.setVisibility(View.GONE);
            holder.tvMyStatelike.setVisibility(View.GONE);
        } else {
            // TODO: 2018/8/13 多人点赞显示
            holder.tvMyStatelike.setText(resultBean.getPraiserList().get(0).getPraiserName());
        }
        if (resultBean.getImgList() == null) {
            holder.ivMyStatePic.setVisibility(View.GONE);
            holder.gvMyState.setVisibility(View.GONE);
        } else if (resultBean.getImgList().size() == 1) {
            holder.ivMyStatePic.setVisibility(View.VISIBLE);
            holder.gvMyState.setVisibility(View.GONE);
            Glide.with(context).load(resultBean.getImgList().get(0)).error(R.mipmap.user_icon).into(holder.ivMyStatePic);
        } else {
            holder.ivMyStatePic.setVisibility(View.GONE);
            holder.gvMyState.setVisibility(View.VISIBLE);
            ImageAdapter imageAdapter = new ImageAdapter(context, resultBean.getImgList());
            holder.gvMyState.setAdapter(imageAdapter);
        }

    }

    @Override
    public int getItemCount() {
        return resultBeans == null ? 0 : resultBeans.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_my_state_icon)
        ImageView ivMyStateIcon;

        @BindView(R.id.tv_my_state_name)
        TextView tvMyStateName;

        @BindView(R.id.iv_my_state_edit)
        ImageView ivMyStateEdit;

        @BindView(R.id.tv_my_state)
        TextView tvMyState;

        @BindView(R.id.gv_my_state)
        MyGridView gvMyState;

        @BindView(R.id.tv_my_state_time)
        TextView tvMyStateTime;

        @BindView(R.id.iv_my_state_comment)
        ImageView ivMyStateComment;

        @BindView(R.id.iv_my_state_like)
        ImageView ivMyStateLike;

        @BindView(R.id.tv_my_state_count)
        TextView tvMyStateCount;

        @BindView(R.id.tv_my_state_like)
        TextView tvMyStatelike;

        @BindView(R.id.iv_my_state_pic)
        ImageView ivMyStatePic;

        @BindView(R.id.tv_my_state_class)
        TextView tvMyStateClass;

        @BindView(R.id.iv_my_state_my_like)
        ImageView ivMyStateMyLike;

        private LinearLayout main;

        ViewHolder(View itemView, StateAdapter stateAdapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

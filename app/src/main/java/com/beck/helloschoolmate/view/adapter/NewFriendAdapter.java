package com.beck.helloschoolmate.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.beck.base.adapter.BaseRecyclerViewAdapter;
import com.beck.helloschoolmate.R;
import com.beck.helloschoolmate.model.http.entity.friend.NewFriAgreeRequest;
import com.beck.helloschoolmate.model.http.entity.friend.NewFriAgreeResponse;
import com.beck.helloschoolmate.model.http.entity.friend.NewFriCheckResponse;
import com.beck.helloschoolmate.model.repository.NewFriAgreeRepository;
import com.beck.helloschoolmate.util.UserManager;
import com.beck.helloschoolmate.view.widget.CircleImageView;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by beck on 2018/6/7.
 */

public class NewFriendAdapter extends BaseRecyclerViewAdapter<NewFriendAdapter.ViewHolder> {

    private static final String TAG = "NewFriendAdapter";
    private Context context;
    public List<NewFriCheckResponse.ResultBean> newFriendBeans;


    public NewFriendAdapter(Context context, List<NewFriCheckResponse.ResultBean> newFriendBeans) {
        this.context = context;
        this.newFriendBeans = newFriendBeans;
    }

    @Override
    public NewFriendAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_newfriend_check, parent, false);
        return new ViewHolder(view, (resultBean, position) -> {
            String userToken = UserManager.getInstance().getUserToken(context);
            NewFriAgreeRequest newFriAgreeRequest = new NewFriAgreeRequest();
            newFriAgreeRequest.setFriendGroupId(0);
            newFriAgreeRequest.setFriendId(newFriendBeans.get(position).getRequesterId());
            newFriAgreeRequest.setRemarkName("");
            new NewFriAgreeRepository().getNewFriAgreeResponse(context,userToken,newFriAgreeRequest)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new DisposableObserver<NewFriAgreeResponse>() {
                        @Override
                        public void onNext(NewFriAgreeResponse newFriAgreeResponse) {
                            if (newFriAgreeResponse != null && newFriAgreeResponse.isSuccess()) {
                                Log.i(TAG, "onNext: 已同意");
                                notifyItemChanged(position);
                            }else {
                                Toast.makeText(context, "请求出错", Toast.LENGTH_SHORT).show();
                            }
                            assert newFriAgreeResponse != null;
                            Log.i(TAG, "onNext: "+newFriAgreeResponse.getErrorMsg());
                        }

                        @Override
                        public void onError(Throwable e) {
                            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        });
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NewFriCheckResponse.ResultBean resultBean = newFriendBeans.get(position);
        Glide.with(context).load(resultBean.getRequesterIcon()).error(R.mipmap.user_icon).into(holder.civNewFriendIcon);
        holder.tvNewFriendName.setText(resultBean.getRequesterNickName());
        if (resultBean.getMessage() != null && !resultBean.getMessage().isEmpty()) {
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
        holder.btnNewFriendAgreed.setTag(resultBean);
    }

    @Override
    public int getItemCount() {
        return newFriendBeans != null ? newFriendBeans.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        iMyViewHolderClicks myViewHolderClicks;

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

        ViewHolder(View itemView, iMyViewHolderClicks holderClicks) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            myViewHolderClicks = holderClicks;
            btnNewFriendAgreed.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_new_friend_agreed:
                    Log.i(TAG, "onClick: 点击同意"+btnNewFriendAgreed.getTag());
                    myViewHolderClicks.onFollowStatusChange((NewFriCheckResponse.ResultBean) btnNewFriendAgreed.getTag(),getLayoutPosition());
                    break;
                default:
                    break;
            }
        }
    }

    public interface iMyViewHolderClicks {
        void onFollowStatusChange(NewFriCheckResponse.ResultBean resultBean, int position);
    }
}
package com.beck.helloschoolmate.view.fragment.homepage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.beck.helloschoolmate.R;
import com.beck.helloschoolmate.contract.StateContract;
import com.beck.helloschoolmate.model.http.entity.state.StateResponse;
import com.beck.helloschoolmate.view.adapter.StateAdapter;
import com.beck.helloschoolmate.view.fragment.HomeBaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by beck on 2018/5/17.
 */

public class StateFragment extends HomeBaseFragment implements StateContract.View {

    private static final String TAG = "StateFragment";
    @BindView(R.id.rv_state)
    RecyclerView rvState;

    @BindView(R.id.srl_state)
    SwipeRefreshLayout srlState;

    private StateContract.Presenter presenter;

    public static StateFragment newInstance() {
        return new StateFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_state, container, false);
        Log.i(TAG, "onCreateView: ");
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        srlState.setProgressViewOffset(true, 50, 200);
        srlState.setSize(SwipeRefreshLayout.DEFAULT);//下拉圆圈大小
        srlState.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
        );
        srlState.setOnRefreshListener(() -> {
            presenter.subscribe();
        });

        presenter.subscribe();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void requestError(String error) {
        srlState.setRefreshing(false);
        Toast.makeText(activity, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(StateContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public StateContract.Presenter getPresenter() {
        return presenter;
    }

    @Override
    public void displayStateList(List<StateResponse.ResultBean> result) {
        srlState.setRefreshing(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        rvState.setLayoutManager(layoutManager);
        rvState.setItemAnimator(new DefaultItemAnimator());
        rvState.addItemDecoration(new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL));
        StateAdapter stateAdapter = new StateAdapter(this.getContext(), result);
        stateAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(activity, "进入详情页面", Toast.LENGTH_SHORT).show();
            }
        });
        rvState.setAdapter(stateAdapter);
    }
}

package com.beck.helloschoolmate.presenter;

import android.content.Context;
import android.util.Log;

import com.beck.helloschoolmate.contract.StateContract;
import com.beck.helloschoolmate.model.http.entity.state.StateRequest;
import com.beck.helloschoolmate.model.http.entity.state.StateResponse;
import com.beck.helloschoolmate.model.repository.GetStateRepository;
import com.beck.helloschoolmate.util.UserManager;

import java.net.SocketTimeoutException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by beck on 2018/8/11.
 */

public class StatePresenter implements StateContract.Presenter{

    private static final String TAG = "StatePresenter";
    private StateContract.View view;
    private Context context;
    private DisposableObserver<StateResponse> disposableObserver;

    public StatePresenter(Context context, StateContract.View view) {
        this.view = view;
        this.context = context;
        view.setPresenter(this);
    }

    @Override
    public void subscribe() {
        String userToken = UserManager.getInstance().getUserToken(context);
        StateRequest stateRequest = new StateRequest();
        stateRequest.setPage(1);
        stateRequest.setPageCount(6);
        if (disposableObserver!=null){
            disposableObserver.dispose();
        }
        disposableObserver = new GetStateRepository().getStateList(context, userToken, stateRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<StateResponse>() {
                    @Override
                    public void onNext(StateResponse stateResponse) {
                        if (stateResponse.isSuccess()) {
                            List<StateResponse.ResultBean> result = stateResponse.getResult();
                            view.displayStateList(result);
                        }else {
                            view.requestError(stateResponse.getErrorMsg());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError: " + e.toString());
                        if (e instanceof TimeoutException) {
                            view.requestError("请求超时");
                        } else if (e instanceof SocketTimeoutException) {
                            view.requestError("请求超时");
                        } else {
                            view.requestError("服务器异常");
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void refresh() {

    }

    @Override
    public void unSubscribe() {

    }
}

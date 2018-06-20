package com.beck.helloschoolmate.view.fragment.addfriend;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.beck.helloschoolmate.R;
import com.beck.helloschoolmate.activity.friend.AddFriendActivity;
import com.beck.helloschoolmate.contract.AddFriSearchContract;
import com.beck.helloschoolmate.model.http.entity.addfriend.AddFriSearchRequest;
import com.beck.helloschoolmate.model.http.entity.addfriend.AddFriSearchResponse;
import com.beck.helloschoolmate.util.UIUtil;
import com.beck.helloschoolmate.view.fragment.MateBaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by beck on 2018/6/2.
 */

public class AddFriendSearchFragment extends MateBaseFragment<AddFriendActivity> implements AddFriSearchContract.View {

    private AddFriSearchContract.Presenter presenter;
    @BindView(R.id.et_search_fri)
    EditText etSearchFri;
    private Dialog loadingDialog;

    public static AddFriendSearchFragment newInstance() {
        return new AddFriendSearchFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_addfriend_search, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mActivity.setToolbarBackTitle("查找好友");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        UIUtil.hideKeyboard(getView());
    }

    @OnClick(R.id.btn_search_fri)
    public void onViewClicked() {
        String search_id = etSearchFri.getText().toString().trim();
        if (search_id.length() != 0) {
            AddFriSearchRequest addFriSearchRequest = new AddFriSearchRequest();
            addFriSearchRequest.setSearchParam(search_id);
            loadingDialog = UIUtil.createLoadingDialog(this.getContext(), "正在查找...");
            presenter.search(addFriSearchRequest);
        }
    }


    @Override
    public void requestError(String error) {
        UIUtil.closeDialog(loadingDialog);
        Toast.makeText(mActivity, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(AddFriSearchContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public AddFriSearchContract.Presenter getPresenter() {
        return presenter;
    }

    @Override
    public void searchSuccess(AddFriSearchResponse addFriSearchResponse) {
        UIUtil.closeDialog(loadingDialog);
        AddFriendInfoFragment addFriendInfoFragment = AddFriendInfoFragment.newInstance();
        Bundle bundle = new Bundle();
        bundle.putParcelable("addFriSearchResponse", addFriSearchResponse);
        addFriendInfoFragment.setArguments(bundle);
        mActivity.setFragment(addFriendInfoFragment, "addFriend_info", true);

    }
}

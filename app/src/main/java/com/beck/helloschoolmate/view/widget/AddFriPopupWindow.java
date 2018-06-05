package com.beck.helloschoolmate.view.widget;

/**
 * Created by beck on 2018/6/2.
 */

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.beck.helloschoolmate.R;

/**
 * 弹窗视图
 */
public class AddFriPopupWindow extends PopupWindow {

    private Context context;
    private View mMenuView;

    public AddFriPopupWindow(Context context, View.OnClickListener onClickListener) {
        super(context);
        this.context = context;
        initalize(context, onClickListener);
    }

    @SuppressLint("InflateParams")
    private void initalize(Context context, View.OnClickListener onClickListener) {
        LayoutInflater inflater = LayoutInflater.from(context);
        mMenuView = inflater.inflate(R.layout.dialog_addfriend, null);
        View addFridend = mMenuView.findViewById(R.id.ll_addFriend);
        View qrCodeScann = mMenuView.findViewById(R.id.ll_qr_code_scanning);
        setContentView(mMenuView);
        addFridend.setOnClickListener(onClickListener);
        qrCodeScann.setOnClickListener(onClickListener);
        initWindow();
    }

    private void initWindow() {
        DisplayMetrics d = context.getResources().getDisplayMetrics();
        this.setWidth((int) (d.widthPixels * 0.35));
        this.setHeight(LayoutParams.WRAP_CONTENT);
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        this.update();
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0x00000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
        backgroundAlpha((Activity) context, 0.8f);//0.0-1.0
        this.setOnDismissListener(() -> backgroundAlpha((Activity) context, 1f));
        mMenuView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return true;
            }
        });
    }

    //设置添加屏幕的背景透明度
    private void backgroundAlpha(Activity context, float bgAlpha) {
        WindowManager.LayoutParams lp = context.getWindow().getAttributes();
        lp.alpha = bgAlpha;
        context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        context.getWindow().setAttributes(lp);
    }

    public void showAtBottom(View view) {
        //弹窗位置设置
        showAsDropDown(view, Math.abs((view.getWidth() - getWidth()) / 2), 10);
        //showAtLocation(view, Gravity.TOP | Gravity.RIGHT, 10, 110);//有偏差
    }


}
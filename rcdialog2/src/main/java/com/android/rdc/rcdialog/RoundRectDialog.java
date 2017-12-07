package com.android.rdc.rcdialog;


import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class RoundRectDialog extends Dialog {

    private Button mBtnCancel;
    private Button mBtnSure;
    private TextView mTvTitle;
    private TextView mTvMsg;

    private OnClickListener mNegativeButtonListener;
    private OnClickListener mPositiveButtonListener;


    private RoundRectDialog(@NonNull Context context) {
        this(context, R.style.RoundRectStyle);//引入自定义对话框形式
    }

    private RoundRectDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_round_rect);
        initSize();
        initView();
    }

    private void initView() {
        mBtnSure = findViewById(R.id.btn_sure);
        mBtnCancel = findViewById(R.id.btn_cancel);
        mTvTitle = findViewById(R.id.tv_title);
        mTvMsg = findViewById(R.id.tv_msg);
        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();//点击取消按钮默认隐藏窗口
                if (mNegativeButtonListener != null) {
                    mNegativeButtonListener.onClick(RoundRectDialog.this, 0);
                }
            }
        });
        mBtnSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (mPositiveButtonListener != null) {
                    mPositiveButtonListener.onClick(RoundRectDialog.this, 1);
                }
            }
        });
    }

    private void initSize() {
        Window win = getWindow();
        WindowManager.LayoutParams lp = win.getAttributes();
        Point screenSizePoint = DisplayUtil.getScreenSize(getContext());
        lp.width = screenSizePoint.x - DensityUtil.density2px(getContext(), 20);//宽度为屏幕宽度 - 20
        lp.height = DensityUtil.density2px(getContext(), 180);//
        lp.gravity = Gravity.BOTTOM;//显示在底部
        win.setAttributes(lp);
    }

    /**
     * Set the gravity of the dialog, as per the Gravity constants.  This
     * controls how the window manager is positioned in the overall dialog; it
     * is only useful when using WRAP_CONTENT for the layout width or height.
     *
     * @param gravity The desired gravity constant.
     */
    public void setGravity(int gravity) {
        Window win = getWindow();
        if (win != null) {
            win.setGravity(gravity);
        }
    }

    public void setDialogTitle(String title) {
        mTvTitle.setText(title);
    }

    public void setDialogMsg(String msg) {
        mTvMsg.setText(msg);
    }

    void setNegativeButtonListener(OnClickListener negativeButtonListener) {
        mNegativeButtonListener = negativeButtonListener;
    }

    void setPositiveButtonListener(OnClickListener positiveButtonListener) {
        mPositiveButtonListener = positiveButtonListener;
    }

    public final static class Builder {
        private RoundRectDialog mDialog;

        public Builder(Context context) {
            mDialog = new RoundRectDialog(context);
            mDialog.create();
            mDialog.setCanceledOnTouchOutside(true);//默认点击外框可取消
        }

        public Builder setTitle(String title) {
            mDialog.mTvTitle.setText(title);
            return this;
        }

        public Builder setMsg(String msg) {
            mDialog.mTvMsg.setText(msg);
            return this;
        }

        public Builder setNegativeButton(CharSequence text, final OnClickListener listener) {
            mDialog.mBtnCancel.setText(text);
            mDialog.setNegativeButtonListener(listener);
            return this;
        }

        public Builder setPositiveButton(CharSequence text, final OnClickListener listener) {
            mDialog.mBtnSure.setText(text);
            mDialog.setPositiveButtonListener(listener);
            return this;
        }

        public Builder setCanceledOnTouchOutside(boolean canceledOnTouchOutside) {
            mDialog.setCanceledOnTouchOutside(canceledOnTouchOutside);
            return this;
        }

        public Builder setCancelable(boolean cancelable) {
            mDialog.setCancelable(cancelable);
            return this;
        }

        /**
         *
         * */
        public Builder setGravity(int gravity) {
            mDialog.setGravity(gravity);
            return this;
        }

        public RoundRectDialog show() {
            mDialog.show();
            return mDialog;
        }
    }
}

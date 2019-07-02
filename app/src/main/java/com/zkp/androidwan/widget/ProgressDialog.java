package com.zkp.androidwan.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;


import com.zkp.androidwan.R;

import static android.view.KeyEvent.KEYCODE_BACK;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.weight
 * @time: 2019/4/28 14:34
 * @description:
 */
public class ProgressDialog extends Dialog {
    private TextView mMessageTV;

    public ProgressDialog(Context context) {
        super(context, R.style.transparent_Dialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.process_dialog);
        mMessageTV = findViewById(R.id.messagetv);
    }

    @Override
    public boolean onKeyDown(int keyCode, @NonNull KeyEvent event) {
        if (keyCode == KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void showMessage(String message) {
        try {
            super.show();
            if (!TextUtils.isEmpty(message)) {
                mMessageTV.setText(message);
                mMessageTV.setVisibility(View.VISIBLE);
            } else {
                mMessageTV.setText("");
                mMessageTV.setVisibility(View.GONE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

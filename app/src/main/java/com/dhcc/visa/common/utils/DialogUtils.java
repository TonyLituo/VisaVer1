package com.dhcc.visa.common.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;

import com.dhcc.visa.ui.widget.MyDialog;

/**
 * Created by zhanY on 2017/4/6.
 */

public class DialogUtils {

    public static void showDialog(Context context, String msg) {

        MyDialog dialog = new MyDialog(context, MyDialog.NORMAL_TYPE);

        dialog.setContentText(msg).setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    return true;
                } else {
                    return false; // 默认返回 false
                }
            }
        });
        dialog.show();
    }
}

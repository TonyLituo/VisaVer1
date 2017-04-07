package com.dhcc.visa.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

import com.dhcc.visa.R;

/**
 * Created by zhanY on 2017/4/6.
 */

public class DhccProgrssDialog extends Dialog {

    private static DhccProgrssDialog m_progrssDialog;

    public DhccProgrssDialog(Context context, int theme) {
        super(context, theme);
    }

    public static DhccProgrssDialog createProgrssDialog(Context context) {
        m_progrssDialog = new DhccProgrssDialog(context,
                R.style.DhccpressDialog);
        m_progrssDialog.setContentView(R.layout.dhcc_progress_dialog);
        m_progrssDialog.getWindow().getAttributes().gravity = Gravity.CENTER;
        return m_progrssDialog;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (null == m_progrssDialog)
            return;
        ImageView loadingImageView = (ImageView) m_progrssDialog
                .findViewById(R.id.iv_progress_dialog_loading);
        AnimationDrawable animationDrawable = (AnimationDrawable) loadingImageView
                .getBackground();
        animationDrawable.start();
    }

    public DhccProgrssDialog setMessage(String msg) {
        TextView loadingTextView = (TextView) m_progrssDialog
                .findViewById(R.id.tv_progress_dialog_loading);
        if (!TextUtils.isEmpty(msg))
            loadingTextView.setText(msg);
        else
            loadingTextView
                    .setText(R.string.dhcc_progress_dialog_image_loading);
        return m_progrssDialog;
    }

    private DhccProgrssDialog m_customProgrssDialog;

    public final void showCustomProgrssDialog(String msg, Context context) {
        if (null == m_customProgrssDialog)
            m_customProgrssDialog = DhccProgrssDialog
                    .createProgrssDialog(context);
        if (null != m_customProgrssDialog) {
            m_customProgrssDialog.setMessage(msg);
            m_customProgrssDialog.show();
            m_customProgrssDialog.setCancelable(false);
        }
    }

    public final void hideCustomProgressDialog() {
        if (null != m_customProgrssDialog) {
            m_customProgrssDialog.dismiss();
            m_customProgrssDialog = null;
        }
    }

}

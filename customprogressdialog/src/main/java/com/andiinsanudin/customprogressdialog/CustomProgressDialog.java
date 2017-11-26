package com.andiinsanudin.customprogressdialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andiisfh on 26/11/17.
 */

public class CustomProgressDialog {

    static ProgressDialog mProgressDialog;
    static List<ProgressDialog> sProgressDialogList = new ArrayList<ProgressDialog>();

    public static void addDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.show();
        progressDialog.setContentView(R.layout.custom_progressdialog);
        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        progressDialog.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
        progressDialog.setCancelable(false);
        sProgressDialogList.add(progressDialog);
    }

    public static void removeDialog(){
        if(sProgressDialogList.size() > 0){
            sProgressDialogList.get(sProgressDialogList.size() - 1).dismiss();
            sProgressDialogList.remove(sProgressDialogList.size() - 1);
        }
    }

    public static void showDialog(Context context) {
        mProgressDialog = new ProgressDialog(context);
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
        mProgressDialog.setContentView(R.layout.custom_progressdialog);
        mProgressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        mProgressDialog.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
        mProgressDialog.setCancelable(false);
    }

    public static void stopDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }
}

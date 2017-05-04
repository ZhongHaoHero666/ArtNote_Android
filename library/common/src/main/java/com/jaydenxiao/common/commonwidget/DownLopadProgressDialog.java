package com.jaydenxiao.common.commonwidget;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jaydenxiao.common.R;

/**
 * Created by Woolle on 2016/11/24.
 * 下载进度条样式
 */

public class DownLopadProgressDialog extends AlertDialog {

    private ProgressBar mProgress;
    private TextView mProgressNumber;
    private TextView mProgressMessage;

    private boolean mHasStarted;

    public DownLopadProgressDialog(Context context) {

        super(context);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.download_progress_dialog);
        mProgress = (ProgressBar) findViewById(R.id.progress);
        mProgressNumber = (TextView) findViewById(R.id.mProgressNumber);
        mProgressMessage = (TextView) findViewById(R.id.mProgressMessage);

    }

    private void onProgressChanged() {
//        mViewUpdateHandler.sendEmptyMessage(0);


    }

    public void setProgressStyle(int style) {
        //mProgressStyle = style;
    }

    //    public int getMax() {
//        if (mProgress != null) {
//            return mProgress.getMax();
//        }
//        return mMax;
//    }
//    public void setMax(int max) {
//        if (mProgress != null) {
//            mProgress.setMax(max);
//            onProgressChanged();
//        } else {
//            mMax = max;
//        }
//    }
    public void setIndeterminate(boolean indeterminate) {
        if (mProgress != null) {
            mProgress.setIndeterminate(indeterminate);
        }
//      else {
//            mIndeterminate = indeterminate;
//        }
    }

    public void setProgress(int value) {
//        if (mHasStarted) {
        mProgress.setProgress(value);
        mProgressNumber.setText(value + "%");
//            onProgressChanged();
//        } else {
//            mProgressVal = value;
//        }
    }


    @Override
    public void setMessage(CharSequence message) {
        // TODO Auto-generated method stub
        //super.setMessage(message);
        if (mProgressMessage != null) {
            mProgressMessage.setText(message);
        } else {
            mProgressMessage.setText("版本更新");
        }
    }


    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        mHasStarted = true;
    }


    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        mHasStarted = false;
    }

}

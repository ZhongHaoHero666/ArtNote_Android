package com.jaydenxiao.common.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.jaydenxiao.common.R;
import com.jaydenxiao.common.R2;
import com.jaydenxiao.common.baseapp.AppConstant;
import com.jaydenxiao.common.baseapp.BaseApplication;
import com.jaydenxiao.common.commonwidget.NormalTitleBar;

import butterknife.BindView;

/**
 * H5页面
 * Created by RXPC-D252 on 2017/4/5.
 */

public class WebViewActivity extends BaseActivity {

    @BindView(R2.id.normalTitle)
    NormalTitleBar normalTitle;
    @BindView(R2.id.ll_container)
    LinearLayout llContainer;
    private String toUrl;
    private WebView webView;
    private String title;

    @Override
    public int getLayoutId() {
        return R.layout.activity_webview;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        normalTitle.setTvLeftVisiable(false);
        normalTitle.setBackVisibility(true);

        normalTitle.setOnBackListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        init();
    }

    public static void startAction(Context context, String url,String title) {
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra(AppConstant.WEBVIEW_URL, url);
        intent.putExtra(AppConstant.WEBVIEW_TITLE, title);
        context.startActivity(intent);
    }

    @SuppressLint("JavascriptInterface")
    public void init() {
        webView = new WebView(BaseApplication.getAppContext());
        llContainer.addView(webView);
        toUrl = getIntent().getStringExtra(AppConstant.WEBVIEW_URL);
        title = getIntent().getStringExtra(AppConstant.WEBVIEW_TITLE);
        //用于设置标题
        normalTitle.setTitleText(title);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptCanOpenWindowsAutomatically(true);//设置js可以直接打开窗口，如window.open()，默认为false
        settings.setJavaScriptEnabled(true);//启用支持javascript
        settings.setSupportZoom(true);//是否可以缩放，默认true
//        settings.setBuiltInZoomControls(false);//是否显示缩放按钮，默认false
        settings.setUseWideViewPort(true);//设置此属性，可任意比例缩放。大视图模式
        settings.setLoadWithOverviewMode(true);//和setUseWideViewPort(true)一起解决网页自适应问题
        settings.setAppCacheEnabled(false);//设置是否缓存
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        settings.setDomStorageEnabled(true);//DOM Storage

        WebChromeClient wvcc = new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                // txtTitle.setText("ReceivedTitle:" +title);
            }

        };
        // 设置setWebChromeClient对象
        webView.setWebChromeClient(wvcc);

        webView.addJavascriptInterface(this, "yfzy");
        webView.loadUrl(toUrl);

        // 覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stubs
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
//
//        webView.setWebChromeClient(new WebChromeClient() {
//            @Override
//            public void onProgressChanged(WebView view, int newProgress) {
//                // TODO Auto-generated method stub
////                LogUtils.i("text","加载网络"+newProgress);
//                if (newProgress == 100) {
//                    // 网页加载完成
//                    // ToastUtil.showToast("网络加载中");
//                    MyApplication.yfzyutils.ShutdownWindow();
//                } else{
//                    // 加载中
//                    // ToastUtil.showToast("网络加载中");
//                }
//
//            }
//        });
//
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //设置点击返回按钮时不finish Activity
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        webView.removeAllViews();
        webView.destroy();
        llContainer.removeView(webView);
    }
}

package cn.facewar.artnote.ui.activity;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jaeger.library.StatusBarUtil;
import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.bean.LoginBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.facewar.artnote.login.R;
import cn.facewar.artnote.ui.contract.LoginContract;
import cn.facewar.artnote.ui.model.LoginModel;
import cn.facewar.artnote.ui.presenter.LoginPresenter;


/**
 * Created by RXPC-D252 on 2017/5/4.
 */

/**
 * 登录界面
 * Created by RXPC-D252 on 2017/5/4.
 */
//路由跳转
@Route(path = "/login/loginActivity")
public class LoginActivity extends BaseActivity<LoginPresenter, LoginModel> implements LoginContract.View {


    @BindView(R.id.root_layout)
    RelativeLayout rootLayout;
    @BindView(R.id.phone_et)
    EditText phoneEt;
    @BindView(R.id.password_et)
    EditText passwordEt;
    @BindView(R.id.forget_pw_tv)
    TextView forgetPwTv;

    @Override
    public int getLayoutId() {
        return R.layout.login_activity_login;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        StatusBarUtil.setTranslucent(this,76); // 状态栏透明度
        forgetPwTv.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG ); //下划线
        forgetPwTv.getPaint().setAntiAlias(true);//抗锯齿
    }

    @Override
    public void loginSuccess(LoginBean loginBean) {
        showShortToast(loginBean.getUserId());
    }

    @Override
    public void loginFail(String msg) {
        showShortToast(msg);
    }

    @Override
    public void showLoading(String title) {
        startProgressDialog(title);
    }

    @Override
    public void stopLoading() {
        stopProgressDialog();
    }

    @Override
    public void showErrorTip(String msg) {
        showShortToast(msg);
    }

    @OnClick(R.id.forget_pw_tv)
    public void onViewClicked() {
    }
}

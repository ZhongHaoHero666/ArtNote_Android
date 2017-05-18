package cn.facewar.artnote.ui.activity;

import android.graphics.Paint;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.jaeger.library.StatusBarUtil;
import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.baseapp.AppConstant;
import com.jaydenxiao.common.bean.login.LoginBean;
import com.jaydenxiao.common.commonutils.SPUtils;

import butterknife.BindView;
import butterknife.OnClick;
import cn.facewar.artnote.login.R;
import cn.facewar.artnote.login.R2;
import cn.facewar.artnote.ui.contract.LoginContract;
import cn.facewar.artnote.ui.model.LoginModel;
import cn.facewar.artnote.ui.presenter.LoginPresenter;


/**
 * 登录界面
 * Created by RXPC-D252 on 2017/5/4.
 */
//路由跳转
@Route(path = "/login/loginActivity")
public class LoginActivity extends BaseActivity<LoginPresenter, LoginModel> implements LoginContract.View, View.OnClickListener {


    @BindView(R2.id.root_layout)
    RelativeLayout rootLayout;
    @BindView(R2.id.phone_et)
    EditText phoneEt;
    @BindView(R2.id.password_et)
    EditText passwordEt;
    @BindView(R2.id.forget_pw_tv)
    TextView forgetPwTv;
    @BindView(R2.id.register_bt)
    Button registerBt;
    @BindView(R2.id.login_bt)
    Button loginBt;

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
        StatusBarUtil.setTranslucent(this, 76); // 状态栏透明度
        forgetPwTv.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
        forgetPwTv.getPaint().setAntiAlias(true);//抗锯齿
        loginBt.setOnClickListener(this);
        registerBt.setOnClickListener(this);
        forgetPwTv.setOnClickListener(this);
    }

    /**
     * 登录成功
     *
     * @param loginBean
     */
    @Override
    public void loginSuccess(LoginBean loginBean) {
        //登录成功 跳转首页 并保存登录状态
        SPUtils.setSharedBooleanData(AppConstant.LOGIN_STATUS, true);
        ARouter.getInstance().build("/homepage/HomePageActivity").navigation();
        finish();
    }

    /**
     * 登录失败
     *
     * @param msg
     */
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


    @OnClick({R2.id.forget_pw_tv, R2.id.register_bt, R2.id.login_bt})
    public void onClick(View view) {
        if (view.getId() == R.id.forget_pw_tv) {

        } else if (view.getId() == R.id.register_bt) {
            startActivity(RegisterActivity.class);

        } else if (view.getId() == R.id.login_bt) {
            String mobile = phoneEt.getText().toString();
            String pwd = passwordEt.getText().toString();
            //登录前检测用户输入的手机号和密码是否符合规则
            boolean loginEnable = mPresenter.checkBeforeLogin(mobile, pwd);
            if (loginEnable) {
                mPresenter.loginUser(mobile, pwd);
            }
        }
    }


}

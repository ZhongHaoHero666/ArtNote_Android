package DebugResource;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.bean.login.LoginBean;

import cn.facewar.artnote.login.R;
import cn.facewar.artnote.ui.contract.LoginContract;
import cn.facewar.artnote.ui.model.LoginModel;
import cn.facewar.artnote.ui.presenter.LoginPresenter;


/**
 * Created by RXPC-D252 on 2017/5/4.
 */

/** 登录界面
 * Created by RXPC-D252 on 2017/5/4.
 */
//路由跳转
@Route(path = "/login/loginActivity")
public class DebugLoginActivity extends BaseActivity<LoginPresenter, LoginModel> implements LoginContract.View {


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
}

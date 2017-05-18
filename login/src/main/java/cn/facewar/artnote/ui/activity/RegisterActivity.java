package cn.facewar.artnote.ui.activity;

import android.view.View;
import android.widget.Button;

import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.bean.login.RegisterResponse;
import com.jaydenxiao.common.commonutils.ToastUitl;
import com.jaydenxiao.common.commonwidget.CommonToolBarHelper;
import com.rengwuxian.materialedittext.MaterialEditText;

import butterknife.BindView;
import butterknife.OnClick;
import cn.facewar.artnote.login.R;
import cn.facewar.artnote.login.R2;
import cn.facewar.artnote.ui.contract.RegisterContract;
import cn.facewar.artnote.ui.model.RegisterModel;
import cn.facewar.artnote.ui.presenter.RegisterPresenter;

/**
 * 注册界面
 * Created by RXPC-D252 on 2017/5/17.
 */

public class RegisterActivity extends BaseActivity<RegisterPresenter, RegisterModel> implements RegisterContract.View {
    @BindView(R2.id.common_toolbar)
    CommonToolBarHelper commonToolbar;
    @BindView(R.id.et_phone)
    MaterialEditText etPhone;
    @BindView(R.id.et_pwd)
    MaterialEditText etPwd;
    @BindView(R.id.bt_next)
    Button btNext;
    @BindView(R.id.et_verCode)
    MaterialEditText etVerCode;
    private String mobile;
    private String verifyCode;
    private String password;


    @Override
    public int getLayoutId() {
        return R.layout.login_activity_register;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        commonToolbar.setTitle("注册");
        commonToolbar.setOnBackListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(String msg) {

    }

    /**
     * 注册成功
     *
     * @param response
     */
    @Override
    public void getRegisterRep(RegisterResponse response) {
        ToastUitl.showShort("注册成功");
    }

    /**
     * 注册失败
     *
     * @param msg
     */
    @Override
    public void regisFailed(String msg) {
        ToastUitl.showShort("注册成功");
    }

    /**
     * 返回 各项参数检查结果 并提示用户
     * @param msg
     */
    @Override
    public void getCheckValue(String msg) {
        ToastUitl.showShort(msg);
    }

    /**
     * 各项参数检测合法 执行注册
     */
    @Override
    public void checkSuccess() {
        mPresenter.onRegister(mobile, password, verifyCode);
    }


    @OnClick(R.id.bt_next)
    public void onClick() {
        mobile = etPhone.getText().toString();
        verifyCode = etVerCode.getText().toString();
        password = etPwd.getText().toString();
        //检测各参数合法性
        mPresenter.checkBeforeRegister(mobile, password, verifyCode);
    }


}

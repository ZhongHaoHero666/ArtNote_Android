package cn.facewar.artnote.ui.presenter;

import android.text.TextUtils;

import com.jaydenxiao.common.baserx.RxSubscriber;
import com.jaydenxiao.common.bean.login.RegisterResponse;
import com.jaydenxiao.common.commonutils.FormatUtil;

import cn.facewar.artnote.ui.contract.RegisterContract;

/**
 * Created by RXPC-D252 on 2017/5/18.
 */

public class RegisterPresenter extends RegisterContract.Presenter {
    /**
     * 注册账号
     *
     * @param mobile
     * @param password
     * @param verifyCode
     */
    @Override
    public void onRegister(String mobile, String password, String verifyCode) {
        mRxManage.add(mModel.onRegister(mobile, mobile, password, verifyCode).subscribe(new RxSubscriber<RegisterResponse>(mContext, true) {
            @Override
            protected void _onNext(RegisterResponse response) {
                mView.getRegisterRep(response);
            }

            @Override
            protected void _onError(String message) {
                mView.regisFailed(message);
            }
        }));
    }

    /**
     * 检测各项输入合法性
     *
     * @param mobile
     * @param password
     * @param verifyCode
     */
    @Override
    public void checkBeforeRegister(String mobile, String password, String verifyCode) {
        if (!TextUtils.isEmpty(mobile) && FormatUtil.isMobileNO(mobile)) {
            if (!TextUtils.isEmpty(verifyCode) && FormatUtil.StrLength(verifyCode) == 4) {
                int pwdLength = FormatUtil.StrLength(password);
                if (!TextUtils.isEmpty(password) && pwdLength >= 3 && pwdLength <= 20) {
                    mView.checkSuccess();
                }else {
                    mView.getCheckValue("密码格式错误,请输入长度为3到20位的数字或字母");
                }
            } else {
                mView.getCheckValue("请输入4位验证码");
            }
        } else {
            mView.getCheckValue("输入的手机号不合法,请重新输入");
        }

    }
}

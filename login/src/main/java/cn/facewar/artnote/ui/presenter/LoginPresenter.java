package cn.facewar.artnote.ui.presenter;

import com.jaydenxiao.common.baserx.RxSubscriber;
import com.jaydenxiao.common.bean.login.LoginBean;
import com.jaydenxiao.common.commonutils.DevicesUtils;
import com.jaydenxiao.common.commonutils.FormatUtil;
import com.jaydenxiao.common.commonutils.ToastUitl;

import cn.facewar.artnote.ui.contract.LoginContract;

/**
 * Created by Chen on 2017/5/9.
 */

public class LoginPresenter extends LoginContract.Presenter {
    /**
     * 登录
     * @param mobile 输入的手机号
     * @param passWord 输入的密码
     */
    @Override
    public void loginUser(String mobile, String passWord) {
        mRxManage.add(mModel.getLogin(mobile,passWord, DevicesUtils.getDeviceId()).subscribe(new RxSubscriber<LoginBean>(mContext,"正在登陆",true) {
            @Override
            protected void _onNext(LoginBean response) {
                mView.loginSuccess(response);
            }

            @Override
            protected void _onError(String message) {
                mView.loginFail(message);
            }
        }));
    }

    /**
     * 登录前检测用户输入是否正确
     *
     * @param mobile 输入的手机号
     * @param passWord 输入的密码
     */

    @Override
    public boolean checkBeforeLogin(String mobile, String passWord) {
        boolean isMobile = FormatUtil.isMobileNO(mobile);
        if (isMobile) {
            int length = FormatUtil.StrLength(passWord);
            if (3 <= length && length <= 20) {
                return true;
            } else {
                ToastUitl.showShort("密码格式不正确,请输入3~20位数字或字母");
                return false;
            }
        } else {
            ToastUitl.showShort("手机号码格式不正确,请重新输入");
            return false;
        }
    }
}

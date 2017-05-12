package cn.facewar.artnote.ui.presenter;

import com.jaydenxiao.common.baserx.RxSubscriber;
import com.jaydenxiao.common.bean.ArtNoteResponse;
import com.jaydenxiao.common.bean.LoginBean;

import cn.facewar.artnote.ui.contract.LoginContract;

/**
 * Created by Chen on 2017/5/9.
 */

public class LoginPresenter extends LoginContract.Presenter {
    @Override
    public void loginUser(String mobile, String passWord, String IMeiId) {
        mRxManage.add(mModel.getLogin(mobile,passWord,IMeiId).subscribe(new RxSubscriber<LoginBean>(mContext,"正在登陆",true) {
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
}

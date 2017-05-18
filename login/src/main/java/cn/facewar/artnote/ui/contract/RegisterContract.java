package cn.facewar.artnote.ui.contract;

import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;
import com.jaydenxiao.common.bean.login.RegisterResponse;

import rx.Observable;

/**
 * 注册契约
 * Created by RXPC-D252 on 2017/5/18.
 */

public interface RegisterContract {
    interface Model extends BaseModel {
        Observable<RegisterResponse> onRegister(String username, String mobile, String password, String verifyCode);
    }

    interface View extends BaseView {
        //注册成功
        void getRegisterRep(RegisterResponse response);
        //注册失败
        void regisFailed(String msg);
        //返回参数检测结果
        void getCheckValue(String msg);
        //参数检测成功
        void checkSuccess();
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        //注册
        public abstract void onRegister(String mobile, String password, String verifyCode);
        //检测参数
        public abstract void checkBeforeRegister(String mobile, String password, String verifyCode);
    }
}

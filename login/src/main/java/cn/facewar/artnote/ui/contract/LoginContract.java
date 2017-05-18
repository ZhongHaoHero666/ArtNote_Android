package cn.facewar.artnote.ui.contract;

import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;
import com.jaydenxiao.common.bean.login.LoginBean;

import rx.Observable;

/**
 * Created by Chen on 2017/5/9.
 */

public interface LoginContract {

    interface Model extends BaseModel {
        Observable<LoginBean> getLogin(String mobile, String passWord,String IMeiId);

    }

    interface View extends BaseView {
        void loginSuccess(LoginBean loginBean);

        void loginFail(String msg);
    }

    abstract  class Presenter extends BasePresenter<View, Model> {
        //发起登陆请求
        public abstract void loginUser(String mobile, String passWord);

        public abstract boolean checkBeforeLogin(String mobile, String passWord);
    }
}

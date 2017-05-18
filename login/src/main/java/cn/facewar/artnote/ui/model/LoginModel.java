package cn.facewar.artnote.ui.model;

import com.jaydenxiao.common.api.Api;
import com.jaydenxiao.common.baserx.RxHelper;
import com.jaydenxiao.common.baserx.RxSchedulers;
import com.jaydenxiao.common.bean.login.LoginBean;

import cn.facewar.artnote.ui.contract.LoginContract;
import rx.Observable;

/**
 * Created by Chen on 2017/5/9.
 */

public class LoginModel implements LoginContract.Model {

    @Override
    public Observable<LoginBean> getLogin(String mobile, String passWord, String IMeiId) {
        return Api.getDefault().login(Api.getCacheControl(),mobile,passWord,IMeiId)
                .compose(RxHelper.<LoginBean>handleResult())
                .compose(RxSchedulers.<LoginBean>io_main());
    }

}

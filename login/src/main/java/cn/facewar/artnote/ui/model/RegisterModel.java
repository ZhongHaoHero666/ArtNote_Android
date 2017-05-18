package cn.facewar.artnote.ui.model;

import com.jaydenxiao.common.api.Api;
import com.jaydenxiao.common.baserx.RxHelper;
import com.jaydenxiao.common.baserx.RxSchedulers;
import com.jaydenxiao.common.bean.login.RegisterResponse;

import cn.facewar.artnote.ui.contract.RegisterContract;
import rx.Observable;

/** 注册
 * Created by RXPC-D252 on 2017/5/18.
 */

public class RegisterModel implements RegisterContract.Model {
    @Override
    public Observable<RegisterResponse> onRegister(String username, String mobile, String password, String verifyCode) {
        return Api.getDefault().register(Api.getCacheControl(),username,mobile,password,verifyCode)
            .compose(RxHelper.<RegisterResponse>handleResult())
            .compose(RxSchedulers.<RegisterResponse>io_main());
    }
}

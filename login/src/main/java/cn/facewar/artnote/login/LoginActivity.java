package cn.facewar.artnote.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;

import cn.facewar.artnote.login.R;


/** 登录界面
 * Created by RXPC-D252 on 2017/5/4.
 */
//路由跳转
@Route(path = "/login/loginActivity")
public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_login);
    }
}

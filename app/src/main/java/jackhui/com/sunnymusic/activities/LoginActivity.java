package jackhui.com.sunnymusic.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import jackhui.com.sunnymusic.R;
import jackhui.com.sunnymusic.utils.UserUtils;
import jackhui.com.sunnymusic.views.InputView;

public class LoginActivity extends BaseActivity{

    private InputView mInputPhone;
    private InputView mInputPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {

        initNavBar(false, "登录", false);
        mInputPhone = fd(R.id.input_phone);
        mInputPassword = fd(R.id.input_password);

    }

    // 注册事件
    public void onRegisterClick(View v) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void onCommitClick(View v) {
        String phone = mInputPhone.getInputStr();
        String password = mInputPassword.getInputStr();
        if (!UserUtils.validateLogin(this, phone, password)) {
            return;
        }
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}

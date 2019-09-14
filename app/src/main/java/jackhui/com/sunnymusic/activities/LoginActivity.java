package jackhui.com.sunnymusic.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import jackhui.com.sunnymusic.R;

public class LoginActivity extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        initNavBar(false, "登录", false);
    }
}

package jackhui.com.sunnymusic.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import jackhui.com.sunnymusic.R;
import jackhui.com.sunnymusic.utils.UserUtils;

public class MeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        initView();
    }

    private void initView() {
        initNavBar(true, "个人中心", false);
    }

    public void onChangeClick(View v) {
        startActivity(new Intent(this, ChangePasswordActivity.class));
    }

    public void onLogoutClick(View v) {
        UserUtils.logout(this);
    }
}

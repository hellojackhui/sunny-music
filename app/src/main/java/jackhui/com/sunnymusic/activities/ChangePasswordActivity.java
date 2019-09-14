package jackhui.com.sunnymusic.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import jackhui.com.sunnymusic.R;
import jackhui.com.sunnymusic.utils.UserUtils;
import jackhui.com.sunnymusic.views.InputView;

public class ChangePasswordActivity extends BaseActivity {
    private InputView change_old_password;
    private InputView change_new_password;
    private InputView change_confirm_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        initView();
    }
    private void initView() {
        initNavBar(true, "注册", false);
        change_old_password = fd(R.id.change_old_password);
        change_new_password = fd(R.id.change_new_password);
        change_confirm_password = fd(R.id.change_confirm_password);
    }
    public void onChangePasswordClick(View v) {
        String phone = change_old_password.getInputStr();
        String password = change_new_password.getInputStr();
        String confirm = change_confirm_password.getInputStr();
        if (!UserUtils.validateChangePwd(this, phone, password, confirm)) {
            return;
        }
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}

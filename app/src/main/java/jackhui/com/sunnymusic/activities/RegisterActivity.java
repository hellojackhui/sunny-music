package jackhui.com.sunnymusic.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import jackhui.com.sunnymusic.R;
import jackhui.com.sunnymusic.utils.UserUtils;
import jackhui.com.sunnymusic.views.InputView;

public class RegisterActivity extends BaseActivity {

    private InputView regPhone;
    private InputView regPassword;
    private InputView regConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }
    private void initView() {
        initNavBar(true, "注册", false);
        regPhone = fd(R.id.reg_phone);
        regPassword = fd(R.id.reg_password);
        regConfirm = fd(R.id.reg_confirm);
    }
    public void onRegisterClick(View v) {
        String phone = regPhone.getInputStr();
        String password = regPassword.getInputStr();
        String confirm = regConfirm.getInputStr();
        if (!UserUtils.validateRegister(this, phone, password, confirm)) {
            return;
        }
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }


}

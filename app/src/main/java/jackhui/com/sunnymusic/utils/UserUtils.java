package jackhui.com.sunnymusic.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import com.blankj.utilcode.util.RegexUtils;

import jackhui.com.sunnymusic.R;
import jackhui.com.sunnymusic.activities.LoginActivity;

public class UserUtils {
    /**
     * 验证用户输入合法性
     */

    public static boolean validateLogin(Context context, String phone, String password) {
//        RegexUtils.isMobileSimple(phone); // 简单型
        if (!RegexUtils.isMobileExact(phone)) {
            Toast.makeText(context, "无效手机号", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(context, "请输入密码", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public static boolean validateRegister(Context context, String phone, String password, String confirm) {
        if (!RegexUtils.isMobileExact(phone)) {
            Toast.makeText(context, "无效手机号", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(context, "请输入密码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(confirm)) {
            Toast.makeText(context, "请再次输入密码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!password.equals(confirm)) {
            Toast.makeText(context, "密码不一致", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    public static boolean validateChangePwd(Context context, String oldPwd, String newPwd, String confirm) {
        if (TextUtils.isEmpty(oldPwd)) {
            Toast.makeText(context, "请输入原密码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(newPwd)) {
            Toast.makeText(context, "请输入新密码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(confirm)) {
            Toast.makeText(context, "请确认密码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (oldPwd.equals(newPwd)) {
            Toast.makeText(context, "请使用新密码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!newPwd.equals(confirm)) {
            Toast.makeText(context, "确认密码不一致", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


    public static void logout(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        // 定义Activity跳转动画
        ((Activity) context).overridePendingTransition(R.anim.open_enter, R.anim.open_exit);
    }
}

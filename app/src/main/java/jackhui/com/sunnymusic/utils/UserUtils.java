package jackhui.com.sunnymusic.utils;

import android.content.Context;
import android.service.autofill.RegexValidator;
import android.text.TextUtils;
import android.widget.Toast;

import com.blankj.utilcode.util.RegexUtils;

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

}

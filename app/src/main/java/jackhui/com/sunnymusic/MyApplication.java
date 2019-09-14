package jackhui.com.sunnymusic;

import android.app.Application;
import com.blankj.utilcode.util.*;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}

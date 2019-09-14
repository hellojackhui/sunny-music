package jackhui.com.sunnymusic.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import jackhui.com.sunnymusic.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        initNavBar(false, "sunny music", true);
    }

}

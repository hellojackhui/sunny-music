package jackhui.com.sunnymusic.activities;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import jackhui.com.sunnymusic.R;

public class BaseActivity extends AppCompatActivity {
    private ImageView mIvBack, mIvMe;
    private TextView mTvTitle;


    /**
     * findViewById
     * @param id
     * @param <T>
     * @return
     */

    protected <T extends View> T fd(@IdRes int id) {
        return findViewById(id);
    }

    protected void initNavBar(boolean isShowBack, String title, boolean isShowme) {
        mIvBack = fd(R.id.iv_back);
        mIvMe = fd(R.id.iv_me);
        mTvTitle = fd(R.id.tv_title);

        mIvBack.setVisibility(isShowBack ? View.VISIBLE : View.GONE);
        mIvMe.setVisibility(isShowme ? View.VISIBLE : View.GONE);
        mTvTitle.setText(title);
        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}

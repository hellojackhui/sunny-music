package jackhui.com.sunnymusic.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import jackhui.com.sunnymusic.R;
import jackhui.com.sunnymusic.views.PlayMusicView;
import jp.wasabeef.glide.transformations.BlurTransformation;

public class PlayMusicActivity extends BaseActivity {

    private ImageView mIvBg;
    private PlayMusicView mPlayView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initView();
    }

    private void initView() {
        mIvBg = fd(R.id.iv_bg);
//      glide-transformations
        Glide.with(this).load("http://pic1.win4000.com/wallpaper/c/53cdd1ec00d80.jpg")
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(25, 10)))
                .into(mIvBg);
        mPlayView = fd(R.id.play_music_view);
        mPlayView.setMusicIcon("http://pic1.win4000.com/wallpaper/c/53cdd1ec00d80.jpg");

    }

    public void onBackClick(View view) {
        onBackPressed();
    }

}

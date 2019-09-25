package jackhui.com.sunnymusic.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import jackhui.com.sunnymusic.R;

public class PlayMusicView extends FrameLayout {

    private Context mContext;
    private View mView;
    private Boolean isPlaying;
    private ImageView mIvIcon;
    private ImageView mIvPlay;

    private Animation mPlayMusicAnim;
    private FrameLayout mFlPlayMusic;

    public PlayMusicView(Context context) {
        super(context);
        init(context);
    }

    public PlayMusicView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PlayMusicView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public PlayMusicView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        mContext = context;

        mView = LayoutInflater.from(mContext).inflate(R.layout.play_music, this, false);

        mIvIcon = mView.findViewById(R.id.iv_icon);
        mFlPlayMusic = mView.findViewById(R.id.fl_play_music);
        mFlPlayMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trigger();
            }
        });
        mIvPlay = mView.findViewById(R.id.iv_play);


        addView(mView);

        mPlayMusicAnim = AnimationUtils.loadAnimation(mContext, R.anim.play_music_anim);


    }

    public void playMusic() {
        isPlaying = true;
        mFlPlayMusic.startAnimation(mPlayMusicAnim);
        mIvPlay.setVisibility(INVISIBLE);

    }

    private void trigger() {
        if (isPlaying) {
            stopMusic();
        } else {
            playMusic();
        }
    }

    public void stopMusic() {
        isPlaying = false;
        mFlPlayMusic.clearAnimation();
        mFlPlayMusic.startAnimation(mPlayMusicAnim);
        mIvPlay.setVisibility(VISIBLE);
    }

//   设置光盘图片
    public void setMusicIcon(String icon) {
        Glide.with(mContext).load(icon).into(mIvIcon);
    }


}

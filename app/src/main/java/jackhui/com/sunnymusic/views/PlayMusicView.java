package jackhui.com.sunnymusic.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import jackhui.com.sunnymusic.R;

public class PlayMusicView extends FrameLayout {

    private Context mContext;
    private View mView;
    private ImageView mIvIcon;

    public PlayMusicView(Context context) {
        super(context);
        init(context);
    }

    public PlayMusicView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PlayMusicView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public PlayMusicView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(Context context) {
        mContext = context;

        mView = LayoutInflater.from(mContext).inflate(R.layout.play_music, this, false);

        mIvIcon = mView.findViewById(R.id.iv_icon);

        addView(mView);

    }

//   设置光盘图片
    public void setMusicIcon(String icon) {
        Glide.with(mContext).load(icon).into(mIvIcon);
    }


}

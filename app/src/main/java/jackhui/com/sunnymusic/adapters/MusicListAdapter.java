package jackhui.com.sunnymusic.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import jackhui.com.sunnymusic.R;
import jackhui.com.sunnymusic.activities.PlayMusicActivity;

public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.ViewHolder> {

    private Context mContext;
    private View mItemView;
    private RecyclerView mRv;
    private boolean isCalculation;

    public MusicListAdapter(Context context, RecyclerView recyclerView) {
        mContext = context;
        mRv = recyclerView;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        mItemView = LayoutInflater.from(mContext).inflate(R.layout.item_list_music, viewGroup, false);
        return new ViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        setReceiverViewHeight();
        Glide.with(mContext)
                .load("http://pic1.win4000.com/wallpaper/2019-09-12/5d79df1739e7d.jpg")
                .into(viewHolder.ivIcon);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PlayMusicActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    /**
     * 1.获取ItemView高度
     * 2.获取itemView的数量
     * 3.相乘计算高度
     */
    private void setReceiverViewHeight() {
        if (isCalculation || mRv == null) return;
        isCalculation = true;
        RecyclerView.LayoutParams rvLp = (RecyclerView.LayoutParams) mItemView.getLayoutParams();
        int itemCount = getItemCount();
        int recyclerViewHeight = rvLp.height * itemCount;
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mRv.getLayoutParams();
        lp.height = recyclerViewHeight;
        mRv.setLayoutParams(lp);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivIcon;
        View itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            ivIcon = itemView.findViewById(R.id.iv_icon);
        }
    }

}

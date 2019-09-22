package jackhui.com.sunnymusic.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import jackhui.com.sunnymusic.R;
import jackhui.com.sunnymusic.activities.AlbumActivity;

public class MusicGridAdapter extends RecyclerView.Adapter<MusicGridAdapter.ViewHolder> {

    private Context mContext;

    public MusicGridAdapter (Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_grid_music, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(mContext)
                .load("http://pic1.win4000.com/wallpaper/2019-09-12/5d79df18592ee.jpg")
                .into(viewHolder.ivIcon);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, AlbumActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 6;
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

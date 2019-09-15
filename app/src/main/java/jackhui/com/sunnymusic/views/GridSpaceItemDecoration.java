package jackhui.com.sunnymusic.views;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

public class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int mSpace;
    public GridSpaceItemDecoration (int space, RecyclerView parent) {
        mSpace = space;
        getRecyclerViewOffsets(parent);
    }

    /**
     *
     * @param outRect Item的边界
     * @param view  ItemView
     * @param parent RecyclersView
     * @param state RecyclersView状态
     */
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = mSpace;

        // 判断Item是不是当前行的第一个
//        if (parent.getChildLayoutPosition(view) % 3 == 0) {
//            outRect.left = 0;
//        }


    }

    private void getRecyclerViewOffsets(RecyclerView parent) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) parent.getLayoutParams();
        layoutParams.leftMargin = -mSpace;
        parent.setLayoutParams(layoutParams);
    }
}

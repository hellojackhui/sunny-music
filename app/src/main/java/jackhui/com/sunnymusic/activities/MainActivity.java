package jackhui.com.sunnymusic.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import jackhui.com.sunnymusic.R;
import jackhui.com.sunnymusic.adapters.MusicGridAdapter;
import jackhui.com.sunnymusic.adapters.MusicListAdapter;
import jackhui.com.sunnymusic.views.GridSpaceItemDecoration;

public class MainActivity extends BaseActivity {

    private RecyclerView mRvGrid, mRvList;
    private MusicGridAdapter musicGridAdapter;
    private MusicListAdapter musicListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        initNavBar(false, "sunny music", true);
        mRvGrid = fd(R.id.rv_grid);
        mRvGrid.setLayoutManager(new GridLayoutManager(this, 3));
        mRvGrid.addItemDecoration(new GridSpaceItemDecoration(getResources().getDimensionPixelOffset(R.dimen.album_margin_size), mRvGrid));
        mRvGrid.setNestedScrollingEnabled(false);
        musicGridAdapter = new MusicGridAdapter(this);
        mRvGrid.setAdapter(musicGridAdapter);

        mRvList = fd(R.id.rv_list);
        mRvList.setLayoutManager(new LinearLayoutManager(this));
        musicListAdapter = new MusicListAdapter(this, mRvList);
        mRvList.setNestedScrollingEnabled(false);
        mRvList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRvList.setAdapter(musicListAdapter);

    }

}

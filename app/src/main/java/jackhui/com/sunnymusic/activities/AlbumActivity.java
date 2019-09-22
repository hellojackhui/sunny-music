package jackhui.com.sunnymusic.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import jackhui.com.sunnymusic.R;
import jackhui.com.sunnymusic.adapters.MusicListAdapter;

public class AlbumActivity extends BaseActivity {

    private RecyclerView mRvList;
    private MusicListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        initView();
    }

    private void initView() {
        initNavBar(false, "专辑列表", false);
        mRvList = fd(R.id.rv_list);
        mRvList.setLayoutManager(new LinearLayoutManager(this));
        mRvList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mAdapter = new MusicListAdapter(this, null);
        mRvList.setAdapter(mAdapter);
    }

}

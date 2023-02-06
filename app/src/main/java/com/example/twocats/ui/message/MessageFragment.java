package com.example.twocats.ui.message;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.twocats.R;
import com.example.twocats.ui.base.BaseFragment;
import com.example.twocats.ui.message.adapter.RecyclerviewMessageAdapter;

/**
 * @ClassName MessageFragment
 * @Author name
 * @Date 2023/1/7
 * @Description
 */
public class MessageFragment extends BaseFragment {
    @Override
    protected void initViews() {
        RecyclerView recyclerView = find(R.id.recycler_view);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(false);
        RecyclerviewMessageAdapter messageAdapter = new RecyclerviewMessageAdapter();
        recyclerView.setAdapter(messageAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_message;
    }
}

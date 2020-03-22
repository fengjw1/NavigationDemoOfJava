package com.example.navigationdemoofjava.adapter;



import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.navigationdemoofjava.R;

import java.util.List;

public class MyBaseAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public MyBaseAdapter(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String s) {
        baseViewHolder.setText(R.id.tv_item, s);
    }
}

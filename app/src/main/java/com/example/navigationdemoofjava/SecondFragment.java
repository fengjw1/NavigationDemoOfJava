package com.example.navigationdemoofjava;

import android.content.Context;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.navigationdemoofjava.adapter.MyBaseAdapter;
import com.example.navigationdemoofjava.base.BaseFragment;
import com.example.navigationdemoofjava.utils.BaseData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class SecondFragment extends BaseFragment {

    @BindView(R.id.rv_first_fragment)
    RecyclerView recyclerView;

    public List<String> mList;

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        try {
            Bundle bundle = getArguments();
            if (bundle != null){
                List<String> list = (List<String>) bundle.get("datas");
                MyBaseAdapter adapter = new MyBaseAdapter(R.layout.item_layout, list);
                recyclerView.setAdapter(adapter);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @OnClick(R.id.btn_fragment2)
    public void onClickFragment(){
//        Navigation.findNavController(getView()).navigate(R.id.action_secondFragment_to_mainFragment);
    }

}

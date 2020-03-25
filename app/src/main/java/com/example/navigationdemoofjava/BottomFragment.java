package com.example.navigationdemoofjava;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.navigationdemoofjava.base.BaseFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;

public class BottomFragment extends BaseFragment {

    @BindView(R.id.bottomNavigation)
    BottomNavigationView bottomNavigationView;

    public BottomFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bottom, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(getActivity(), R.id.bottomNavFragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);//
    }
}

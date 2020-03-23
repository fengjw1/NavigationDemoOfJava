package com.example.navigationdemoofjava;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.example.navigationdemoofjava.utils.BaseData;

import java.util.List;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //getSupportActionBar().hide();//关闭顶部的actionbar

        NavController navController = Navigation.findNavController(this, R.id.fragment);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                Log.d("fengjw", "MainFragment>>navController>>onDestinationChanged>>destination>>" + destination.getLabel());
                if (destination.getId() == R.id.secondFragment){
                    Log.d("fengjw", "当前在second Fragment！");
                    getSupportActionBar().hide();
                }else {
                    getSupportActionBar().show();
                }
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.d("fengjw", "onFragmentInteraction>>uri>>" + uri.toString());
    }
}

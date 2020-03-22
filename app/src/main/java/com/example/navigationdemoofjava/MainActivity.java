package com.example.navigationdemoofjava;

import androidx.appcompat.app.AppCompatActivity;
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

    }


    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.d("fengjw", "onFragmentInteraction>>uri>>" + uri.toString());
    }
}

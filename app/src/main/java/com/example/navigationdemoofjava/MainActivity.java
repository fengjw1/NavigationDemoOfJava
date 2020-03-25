package com.example.navigationdemoofjava;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.navigationdemoofjava.utils.LogUtils;
import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainFragment.OnFragmentInteractionListener {

    private NavController navController;

    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        initMenu();

        navController = Navigation.findNavController(this, R.id.fragment);
        NavigationView navView = findViewById(R.id.nav_view);
        NavigationUI.setupWithNavController(navView, navController);

        initNav();

    }

    private void initMenu(){

        //绑定toolbar
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        toggle.syncState();
        drawerLayout.addDrawerListener(toggle);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                LogUtils.d("onNavigationItemSelected");
                Toast.makeText(getApplicationContext(), menuItem.getTitle(), Toast.LENGTH_SHORT).show();


                // 关闭侧滑导航栏
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
               LogUtils.d("onDrawerSlide");
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                LogUtils.d("onDrawerOpened");
            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
                LogUtils.d("onDrawerClosed");
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                LogUtils.d("onDrawerStateChanged");
            }
        });

    }

    private void initNav(){
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                Log.d("fengjw", "MainFragment>>navController>>onDestinationChanged>>destination>>" + destination.getLabel());
                if (destination.getId() == R.id.secondFragment){
                    Log.d("fengjw", "当前在second Fragment！");
                    getSupportActionBar().hide();//关闭顶部的actionbar
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

    @Override
    public void onBackPressed() {//返回键处理方法
        if (drawerLayout == null) {
            return;
        }
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

    }
}

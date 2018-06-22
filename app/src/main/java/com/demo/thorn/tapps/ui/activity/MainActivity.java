package com.demo.thorn.tapps.ui.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.demo.thorn.tapps.R;
import com.demo.thorn.tapps.base.BaseActivity;
import com.demo.thorn.tapps.ui.fragment.GalleryFragment;
import com.demo.thorn.tapps.ui.fragment.MusicFragment;
import com.demo.thorn.tapps.ui.fragment.ReadFragment;
import com.demo.thorn.tapps.ui.fragment.SendFragment;
import com.demo.thorn.tapps.ui.fragment.VideoFragment;
import com.demo.thorn.tapps.ui.fragment.WeatherFragment;
import com.demo.thorn.tapps.util.ConstantUtil;
import com.demo.thorn.tapps.util.LogUtil;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentManager fragmentManager;// 用 V4 包里面的 Fragement
    private Toolbar toolbar;
    private NavigationView navigationView;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_gallery);

    }

    @Override
    protected void initData() {
        replaceFragment(R.id.cl_content, GalleryFragment.newInstance(), ConstantUtil.FG_GALLERY);
        toolbar.setTitle("图库");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_gallery) {
            navigationView.setCheckedItem(R.id.nav_gallery);
            replaceFragment(R.id.cl_content, GalleryFragment.newInstance(), ConstantUtil.FG_GALLERY);
            toolbar.setTitle("图库");
        } else if (id == R.id.nav_weather) {
            navigationView.setCheckedItem(R.id.nav_weather);
            replaceFragment(R.id.cl_content, WeatherFragment.newInstance(),ConstantUtil.FG_WEATHER);
            toolbar.setTitle("天气");
        } else if (id == R.id.nav_show) {
            navigationView.setCheckedItem(R.id.nav_show);
            replaceFragment(R.id.cl_content, VideoFragment.newInstance(),ConstantUtil.FG_VEDIO);
            toolbar.setTitle("视频");
        } else if (id == R.id.nav_music) {
            navigationView.setCheckedItem(R.id.nav_music);
            replaceFragment(R.id.cl_content, MusicFragment.newInstance(),ConstantUtil.FG_MUSIC);
            toolbar.setTitle("音乐");
        } else if (id == R.id.nav_read) {
            navigationView.setCheckedItem(R.id.nav_read);
            replaceFragment(R.id.cl_content, ReadFragment.newInstance(),ConstantUtil.FG_READ);
            toolbar.setTitle("读书");
        } else if (id == R.id.nav_send) {
            navigationView.setCheckedItem(R.id.nav_send);
            replaceFragment(R.id.cl_content, SendFragment.newInstance(),ConstantUtil.FG_SEND);
            toolbar.setTitle("消息");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {

    }

    public void replaceFragment(int layoutId,Fragment fragment,String tag){
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(layoutId,fragment,tag);
        fragmentTransaction.commit();
    }
}

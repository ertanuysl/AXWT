package com.example.ertan.axwt.wf_List;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.example.ertan.axwt.R;
import com.example.ertan.axwt.adapters.ViewPagerAdapter;
import com.example.ertan.axwt.fragments.FragmentOne;
import com.example.ertan.axwt.fragments.FragmentThree;
import com.example.ertan.axwt.fragments.FragmentTwo;
import com.example.ertan.axwt.wf_Navigation_Drawer.NavigationDrawerFragment;


public class wf_List extends AppCompatActivity {
    RecyclerView recyclerView;
    private Toolbar toolbar;


    /* This is our viewPager */
    private ViewPager viewPager;


    //Fragments

    FragmentOne fragmentTwo;
    FragmentOne fragmentOne;
    FragmentOne fragmentThree;
    MenuItem prevMenuItem;



    BottomNavigationView bottomNavigationView;

     @Override
     protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_wf__list);
            setUpToolbar();

            setUpDrawer();


         viewPager = (ViewPager) findViewById(R.id.viewpager);
         bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
         bottomNavigationView.setOnNavigationItemSelectedListener(
                 new BottomNavigationView.OnNavigationItemSelectedListener() {
                     @Override
                     public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                         switch (item.getItemId()) {
                             case R.id.action_Request:
                                 viewPager.setCurrentItem(0);
                                 break;
                             case R.id.action_order:
                                 viewPager.setCurrentItem(1);
                                 break;
                             case R.id.action_contact:
                                 viewPager.setCurrentItem(2);
                                 break;
                         }
                         return false;
                     }
                 });

         viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
             @Override
             public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

             }

             @Override
             public void onPageSelected(int position) {
                 if (prevMenuItem != null) {
                     prevMenuItem.setChecked(false);
                 }
                 else
                 {
                     bottomNavigationView.getMenu().getItem(0).setChecked(false);
                 }
                 Log.d("page", "onPageSelected: "+position);
                 bottomNavigationView.getMenu().getItem(position).setChecked(true);
                 prevMenuItem = bottomNavigationView.getMenu().getItem(position);

             }

             @Override
             public void onPageScrollStateChanged(int state) {

             }
         });

       /*  //Disable ViewPager Swipe

       viewPager.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return true;
            }
        });

        */

         setupViewPager(viewPager);

     }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        fragmentOne=new FragmentOne();
        fragmentTwo=new FragmentOne();
        fragmentThree=new FragmentOne();
        adapter.addFragment(fragmentOne);
        adapter.addFragment(fragmentTwo);
        adapter.addFragment(fragmentThree);
        viewPager.setAdapter(adapter);
    }
    private void setUpToolbar(){

        toolbar= (Toolbar) findViewById(R.id.toolbar);
      //  toolbar.setTitle("Approval List");

       // toolbar.setSubtitle("Ertan Uysal");


    }

    private void setUpDrawer(){

        NavigationDrawerFragment navFragment= (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.fragment);
        DrawerLayout drawerLayout= (DrawerLayout) findViewById(R.id.drawerLayout);

        navFragment.setUpNavigationDrawer(drawerLayout, toolbar);



    }





}

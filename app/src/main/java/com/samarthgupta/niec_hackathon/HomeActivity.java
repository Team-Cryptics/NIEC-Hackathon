package com.samarthgupta.niec_hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderLayout.Transformer;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.samarthgupta.niec_hackathon.POJO.GlobalVariables;
import com.samarthgupta.niec_hackathon.POJO.PlaceOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener
{
    SliderLayout mDemoSlider;
    BottomNavigationView bottomNavigationView;
    Fragment fragment;
    RecyclerView rvItems;
    RecyclerView.Adapter rvAdapter;
    RecyclerView.LayoutManager rvLayoutManager;

    List<ImageView> pics;
    List<PlaceOrder> orders;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference ref;

    int count = 0,k=0;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Log.i("TAG","in");


        firebaseDatabase = FirebaseDatabase.getInstance();
        ref=firebaseDatabase.getReference();


        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot dsp : dataSnapshot.child("ADVERTISEMENTS").child(Integer.toString(count)).getChildren()){
                    count++;
                    PlaceOrder order = dsp.getValue(PlaceOrder.class);
                    Log.i("TAG",order.getPhoto());
                    orders.add(k,order);
                    k++;
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        rvItems = (RecyclerView) findViewById(R.id.rv_Items);
        rvLayoutManager = new LinearLayoutManager(this);
        rvItems.setLayoutManager(rvLayoutManager);

        ////////////////////////////////////
    //    rvAdapter = new mAdapter(pics);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                switch (item.getItemId()) {
                    case R.id.navigation_buy:

                        break;
                    case R.id.navigation_sell:
                        GlobalVariables.path = 1;
                        startActivity(new Intent(HomeActivity.this,SelectDeviceType.class));

                        break;
                    case R.id.navigation_donate:
                        GlobalVariables.path = 0;
                        startActivity(new Intent(HomeActivity.this,SelectDeviceType.class));
                        break;
                }
                return true;
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mDemoSlider = (SliderLayout)findViewById(R.id.slider);
        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Buy iPhone 7",R.drawable.iphone);
        file_maps.put("Get 10% Off on Samsung Galaxy Tab",R.drawable.samsungtab);
        file_maps.put("Buy Samsung smart TV",R.drawable.samsungtv);
        file_maps.put("Buy MacBook Air", R.drawable.macair);
        file_maps.put("Buy MacBook Pro", R.drawable.macpro);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);
        //ListView l = (ListView)findViewById(R.id.transformers);
        //l.setAdapter(new TransformerAdapter(this));
//        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                mDemoSlider.setPresetTransformer(((TextView) view).getText().toString());
//                Toast.makeText(HomeActivity.this, ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        } else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home)
        {
            startActivity(new Intent(HomeActivity.this,HomeActivity.class));
            // Handle the camera action
        } else if (id == R.id.sell)
        {
            startActivity(new Intent(HomeActivity.this,SelectDeviceType.class));

        } else if (id == R.id.signout)
        {
            //SIGNOUT

        } else if (id == R.id.abtus)
        {
            startActivity(new Intent(HomeActivity.this,ContactUs.class));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    @Override public void onSliderClick(BaseSliderView slider)
    {
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
    {

    }

    @Override public void onPageSelected(int position)
    {

    }

    @Override public void onPageScrollStateChanged(int state)
    {

    }

    @Override protected void onStop()
    {
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }























}

package com.example.policemodule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.policemodule.map.Map_Fragment;
import com.example.policemodule.police.Police_fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener
{
    @BindView(R.id.act_main_bnv)
    BottomNavigationView botnav;

    private Police_fragment policeFragment;
    private Map_Fragment mapfragment;

    private FragmentManager fragmentManager;

    @BindView(R.id.act_main_toolbar)
    Toolbar toolbar;


   // @BindView(R.id.act_main_drawer_layout)
   // DrawerLayout drawerLayout;

    ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);



        botnav.setOnNavigationItemSelectedListener(this);

        if(policeFragment  == null){
           policeFragment  = new Police_fragment();
        }
        loadFragment(policeFragment);

    }

    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        int colorID;
        Fragment frag;
        switch (id){
            case R.id.nav_home:
                frag = new Police_fragment();
                colorID = R.color.nav_police;
                break;
            case R.id.nav_events:
                frag = new Map_Fragment();
                colorID = R.color.nav_map;
                break;
            default:
                return  false;
        }

        botnav.setBackgroundColor(getResources().getColor(colorID));
        loadFragment(frag);
        return true;
    }

    private void loadFragment(Fragment frag){
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.act_main_fragment_layout, frag).commit();


    }
    /*
    private  void setupToolbar(){

        setSupportActionBar(toolbar);
        actionBarDrawerToggle= new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();*/


}


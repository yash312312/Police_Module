package com.example.policemodule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.policemodule.map.Map_Fragment;
import com.example.policemodule.police.Police_fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener
{


    @BindView(R.id.act_main_bnv)
    BottomNavigationView botnav;

    private Police_fragment policeFragment;
    private Map_Fragment mapfragment;

    private FragmentManager fragmentManager;

    @BindView(R.id.act_main_drawer)
    DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @BindView(R.id.act_main_toolbar1)
    Toolbar toolbar;

    @BindView(R.id.navigation)
    NavigationView navigationView;


    //@BindView(R.id.act_main_drawer_layout)
    //DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    /*   getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Police Module");*/

        setSupportActionBar(toolbar);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        //getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        //navigationView.setNavigationItemSelectedListener(this);
        botnav.setOnNavigationItemSelectedListener(this);

        if (policeFragment == null) {
            policeFragment = new Police_fragment();
        }
        loadFragment(policeFragment);

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
              drawerLayout.closeDrawer(GravityCompat.START);

        }
    else{

    super.onBackPressed();
        }    }



    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        int colorID;
        Fragment frag;
        switch (id) {
            case R.id.nav_home:
                frag = new Police_fragment();
                colorID = R.color.nav_police;
                break;

            case R.id.nav_events:
                frag = new Map_Fragment();
                colorID = R.color.nav_map;
                break;
            default:
                return false;
        }

        botnav.setBackgroundColor(getResources().getColor(colorID));
        loadFragment(frag);
        return true;
    }

    private void loadFragment(Fragment frag) {
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.act_main_fragment_layout, frag).commit();


    }


}

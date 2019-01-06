package com.example.asus.appbanhang.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.example.asus.appbanhang.R;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerView;
    NavigationView navigationView;
    ListView listView;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main
        Anhxa();
        ActionBar();
    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.i)
    }

    private void Anhxa(){
        toolbar= findViewById(R.id.toolbarmanhinhchinh);
        viewFlipper=findViewById(R.id.viewflippermanhinhchinh);
        recyclerView=findViewById(R.id.recyclerview);
        navigationView=findViewById(R.id.navigationviewmanhinhchinh);
        listView=findViewById(R.id.listviewmanhinhchinh);
        DrawerLayout=findViewById(R.id.drawerlayout);
    }
}

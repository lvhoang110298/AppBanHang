package com.example.asus.appbanhang.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.asus.appbanhang.R;
import com.example.asus.appbanhang.adapter.LoaispAdapter;
import com.example.asus.appbanhang.modal.Loaisp;
import com.example.asus.appbanhang.ultil.CheckConnection;
import com.example.asus.appbanhang.ultil.Server;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewmanhinhchinh;
    NavigationView navigationView;
    ListView listViewmanhinhchinh;
    DrawerLayout drawerLayout;
    ArrayList<Loaisp> mangloaisp;
    LoaispAdapter loaispAdapter;
    int maloaisp;
    String tenloaisp = "";
    String hinhanloaisp= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
            ActionBar();
            ActionViewFlipper();
            GetDuLieuLoaisp();
        }else {
            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
            finish();
        }


    }

    private void GetDuLieuLoaisp() {
        final RequestQueue requestQueue =Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.LOAISP_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response !=null) {
                    for (int i=0; i<response.length();i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            maloaisp = jsonObject.getInt("maloaisanpham");
                            tenloaisp = jsonObject.getString("tenloaisanpham");
                            hinhanloaisp = jsonObject.getString("hinhanhloaisanpham");
                            mangloaisp.add(new Loaisp(maloaisp,tenloaisp,hinhanloaisp));
                            loaispAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    mangloaisp.add(5,new Loaisp(0,"Lien He","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTkj-XLO7PYnsgV29GGEDj0mRKZCQcUrcSCYL9PlSbG4lu4AHPCfg"));

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnection.ShowToast_Short(getApplicationContext(),error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void ActionViewFlipper() {
        ArrayList<String> mangquangcao =new ArrayList<>();
        mangquangcao.add("https://philong.com.vn/media/banner/04_Jane19f7bad39c6c928bc271a1618e0430d.jpg");
        mangquangcao.add("https://philong.com.vn/media/banner/26_Dec9d101af650e126107be5550fe922a8e4.jpg");
        mangquangcao.add("https://philong.com.vn/media/banner/28_Dec693a34116fdf33e7d8b64ed4c5c912d8.jpg");
        mangquangcao.add("https://philong.com.vn/media/banner/23_Nov7460282fede3a294dfe25d0b1dbd75d6.jpg");
        for(int i=0; i< mangquangcao.size();i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animation_slide_out= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);
    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_list_48px);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void Anhxa(){
        toolbar= findViewById(R.id.toolbar);
        viewFlipper=findViewById(R.id.viewflipper);
        recyclerViewmanhinhchinh=findViewById(R.id.recyclerviewmanhinhchinh);
        navigationView=findViewById(R.id.navigationview);
        listViewmanhinhchinh=findViewById(R.id.listviewmanhinhchinh);
        drawerLayout = findViewById(R.id.drawerlayout);
        mangloaisp = new ArrayList<>();
        mangloaisp.add(0,new Loaisp(0,"Trang Chinh","https://www.backgroundsy.com/file/large/home-icon.jpg"));

        loaispAdapter = new LoaispAdapter(mangloaisp,getApplicationContext());
        listViewmanhinhchinh.setAdapter(loaispAdapter);
    }
}

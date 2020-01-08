package com.example.shimmingapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //---- set variable view
    RecyclerView recyclerView;
    ShimmerFrameLayout shimmerFrameLayout;
    SwipeRefreshLayout swipeRefreshLayout;

    //----- set variable data
    List<DataResponse> data = new ArrayList<>();
    ListAdapter adapter;

    //-----function android
    @Override
    protected void onResume() {
        super.onResume();
        shimmerFrameLayout.startShimmerAnimation();
    }
    @Override
    protected void onPause() {
        super.onPause();
        shimmerFrameLayout.stopShimmerAnimation();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDataActivity();
        setAdapter();
        getData();
    }

    //----- set views
    private void setDataActivity(){
        recyclerView = findViewById(R.id.rvItem);
        shimmerFrameLayout = findViewById(R.id.shimmerLayout);
        swipeRefreshLayout = findViewById(R.id.swipeLayout);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });
    }

    //---- set Connection
    private void getData(){
        shimmerFrameLayout.setVisibility(View.VISIBLE);
        shimmerFrameLayout.startShimmerAnimation();
        
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                data.add(new DataResponse("https://asset-a.grid.id/crop/0x0:0x0/x/photo/2019/10/31/71888328.jpg","Koceng Oren 1","Ini adalah Koceng oren 1"));
                data.add(new DataResponse("https://asset-a.grid.id/crop/0x0:0x0/x/photo/2019/10/31/71888328.jpg","Koceng Oren 2","Ini adalah Koceng oren 2"));
                data.add(new DataResponse("https://asset-a.grid.id/crop/0x0:0x0/x/photo/2019/10/31/71888328.jpg","Koceng Oren 3","Ini adalah Koceng oren 3"));
                data.add(new DataResponse("https://asset-a.grid.id/crop/0x0:0x0/x/photo/2019/10/31/71888328.jpg","Koceng Oren 4","Ini adalah Koceng oren 4"));
                data.add(new DataResponse("https://asset-a.grid.id/crop/0x0:0x0/x/photo/2019/10/31/71888328.jpg","Koceng Oren 5","Ini adalah Koceng oren 5"));
                data.add(new DataResponse("https://asset-a.grid.id/crop/0x0:0x0/x/photo/2019/10/31/71888328.jpg","Koceng Oren 6","Ini adalah Koceng oren 6"));
                data.add(new DataResponse("https://asset-a.grid.id/crop/0x0:0x0/x/photo/2019/10/31/71888328.jpg","Koceng Oren 7","Ini adalah Koceng oren 7"));
                data.add(new DataResponse("https://asset-a.grid.id/crop/0x0:0x0/x/photo/2019/10/31/71888328.jpg","Koceng Oren 8","Ini adalah Koceng oren 8"));
                data.add(new DataResponse("https://asset-a.grid.id/crop/0x0:0x0/x/photo/2019/10/31/71888328.jpg","Koceng Oren 9","Ini adalah Koceng oren 9"));
                data.add(new DataResponse("https://asset-a.grid.id/crop/0x0:0x0/x/photo/2019/10/31/71888328.jpg","Koceng Oren 10","Ini adalah Koceng oren 10"));

                adapter.notifyDataSetChanged();

                shimmerFrameLayout.stopShimmerAnimation();
                shimmerFrameLayout.setVisibility(View.GONE);
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 2000);

    }

    //----- set adapter
    private void setAdapter(){
        adapter = new ListAdapter(data, MainActivity.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
}

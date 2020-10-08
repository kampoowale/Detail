package com.example.myapplication.module.view;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.base.RecyclerViewClickListener;
import com.example.myapplication.module.model.EntertainmentzModel;
import com.example.myapplication.module.model.Item;
import com.example.myapplication.module.view_model.EntertainmentDataViewModel;

import java.util.List;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {

    private EntertainmentDataViewModel postViewModel;
    TextView title, description, link, count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView callApi = (TextView) findViewById(R.id.textHello);
        callApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initilizePostViewModel();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        initilizePostViewModel();

    }

    private void initilizePostViewModel() {
        postViewModel = ViewModelProviders.of(this).get(EntertainmentDataViewModel.class);
        postViewModel.getPostMutableLiveData().observe(this, new Observer<EntertainmentzModel>() {
            @Override
            public void onChanged(@Nullable EntertainmentzModel response) {
                setDetails(response);
            }
        });
    }

    private EntertainmentAdapter adapter;
    private RecyclerView recyclerView;

    private void setDetails(EntertainmentzModel response) {
        title = (TextView) findViewById(R.id.title);
        description = findViewById(R.id.txt_description);
        count = findViewById(R.id.count);
        link = findViewById(R.id.txt_link);
        recyclerView = findViewById(R.id.customRecyclerView);
        title.setText(response.channel.getTitle());
        description.setText(response.channel.getDescription());
        link.setText(response.channel.getLink());

        count.setText(String.valueOf(response.channel.getItem().size()));

        generateDataList(response.channel.getItem());
    }

    private void generateDataList(final List<Item> responseData) {


        recyclerView.addOnItemTouchListener(
                new RecyclerViewClickListener(DashboardActivity.this,
                        recyclerView, new RecyclerViewClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(DashboardActivity.this, DetailsActivity.class);
                        intent.putExtra("url", responseData.get(position).getUrl());
                        intent.putExtra("title", responseData.get(position).getTitle());
                        intent.putExtra("description", responseData.get(position).getCategory());
                        intent.putExtra("content", responseData.get(position).getDescription());
                        intent.putExtra("date", responseData.get(position).getPubDate());
                        intent.putExtra("link", responseData.get(position).getLink());

                        startActivity(intent);

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );

        adapter = new EntertainmentAdapter(this, responseData);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DashboardActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {

    }
}



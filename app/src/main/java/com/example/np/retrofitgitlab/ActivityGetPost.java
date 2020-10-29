package com.example.np.retrofitgitlab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityGetPost extends AppCompatActivity {

    RecyclerView recyclerView;
    ActivityGetPostAdapter adapter;
    List<ActivityListPost> listPost=new ArrayList<>();

    RequestInterface request;

    String url="https://jsonplaceholder.typicode.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_post);

        request =ActivityApiClient.getApiClient(url).create(RequestInterface.class);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        request.getListPost().enqueue(new Callback<List<ActivityListPost>>() {
            @Override
            public void onResponse(Call<List<ActivityListPost>> call, Response<List<ActivityListPost>> response) {

                listPost=response.body();
                adapter=new ActivityGetPostAdapter(getApplicationContext(),listPost);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<ActivityListPost>> call, Throwable t) {

                Toast.makeText(ActivityGetPost.this,"ERROR", Toast.LENGTH_SHORT).show();

            }
        });


    }
}

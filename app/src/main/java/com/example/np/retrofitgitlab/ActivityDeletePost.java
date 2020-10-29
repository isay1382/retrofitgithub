package com.example.np.retrofitgitlab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityDeletePost extends AppCompatActivity {

    public static String ID="";
    String Id;

    String url="https://jsonplaceholder.typicode.com";

    DeleteInterface deleteInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_post);

        Id=getIntent().getStringExtra(ID);

        deleteInterface=DeleteApiClient.getDeleteApiClient(url).create(DeleteInterface.class);

        deleteInterface.getDeletePost(Id).enqueue(new Callback<ListDeletePost>() {
            @Override
            public void onResponse(Call<ListDeletePost> call, Response<ListDeletePost> response) {

                if (response.isSuccessful()){
                    Intent intent=new Intent(ActivityDeletePost.this,ActivityGetPost.class);
                    startActivity(intent);
                    Toast.makeText(ActivityDeletePost.this, "SUCSSES", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ListDeletePost> call, Throwable t) {
                Toast.makeText(ActivityDeletePost.this, "ERROR", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

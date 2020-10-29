package com.example.np.retrofitgitlab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityCommentPost extends AppCompatActivity {

    public static String ID="";

    RecyclerView recyclerViewComment;
    ActivityCommentAdapter commentAdapter;
    List<ActivityListComment> listComment=new ArrayList<>();

    String Id;

    TextView txtCountComment;

    CommentInterface anInterface;

    String url="https://jsonplaceholder.typicode.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_post);

        recyclerViewComment=(RecyclerView)findViewById(R.id.recyclerComment);
        recyclerViewComment.setHasFixedSize(true);
        recyclerViewComment.setLayoutManager(new LinearLayoutManager(this));

        Id=getIntent().getStringExtra(ID);

        txtCountComment=(TextView)findViewById(R.id.txtCountComment);
        txtCountComment.setText(Id);

        anInterface=CommentApiClient.getCommentApiClient(url).create(CommentInterface.class);

        anInterface.getlistComment(Id).enqueue(new Callback<List<ActivityListComment>>() {
            @Override
            public void onResponse(Call<List<ActivityListComment>> call, Response<List<ActivityListComment>> response) {
                    listComment=response.body();
                    commentAdapter=new ActivityCommentAdapter(getApplicationContext(),listComment);
                    recyclerViewComment.setAdapter(commentAdapter);

            }

            @Override
            public void onFailure(Call<List<ActivityListComment>> call, Throwable t) {

                Toast.makeText(ActivityCommentPost.this,"ERROR", Toast.LENGTH_SHORT).show();

            }
        });



    }
}

package com.example.np.retrofitgitlab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityNewPost extends AppCompatActivity {

    EditText edtTitle;
    EditText edtBody;
    Button btnSendPost;

    String url="https://jsonplaceholder.typicode.com";

    NewPostInterface newPostInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        edtTitle=(EditText)findViewById(R.id.edtTitle);
        edtBody=(EditText)findViewById(R.id.edtBody);
        btnSendPost=(Button)findViewById(R.id.btnSendPost);

        btnSendPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title=edtTitle.getText().toString();
                String body=edtBody.getText().toString();
                if (title.isEmpty() || body.isEmpty()){
                    Toast.makeText(ActivityNewPost.this, "اطلاعات کامل نیست", Toast.LENGTH_SHORT).show();
                }else {
                    newPostInterface=NewPostApiClient.getNewPostClient(url).create(NewPostInterface.class);

                    NewListPost newListPost=new NewListPost(title,body);

                    Call<NewListPost> callNew=newPostInterface.getNewPost(newListPost);

                    callNew.enqueue(new Callback<NewListPost>() {
                        @Override
                        public void onResponse(Call<NewListPost> call, Response<NewListPost> response) {

                            if (response.isSuccessful()){
                                bildNewPost(response.body());
                                Toast.makeText(ActivityNewPost.this, "SUCSSES", Toast.LENGTH_SHORT).show();
                                Log.i("LOG", String.valueOf(response.body()));
                            }

                        }

                        @Override
                        public void onFailure(Call<NewListPost> call, Throwable t) {
                            Toast.makeText(ActivityNewPost.this, "ERROR", Toast.LENGTH_SHORT).show();
                        }
                    });

                }

            }
        });

    }

    private void bildNewPost(NewListPost newListPost){

        newListPost.getTitle();
        newListPost.getBody();
    }

}

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

public class ActivityEditPost extends AppCompatActivity {

    public static String id = "";
    public static String userId = "";
    String Id;
    String UserId;

    EditInterface editInterface;
    String url = "https://jsonplaceholder.typicode.com";

    EditText edtTitleEdit;
    EditText edtBodyEdit;
    Button btnUpdatePost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_post);

        edtTitleEdit = (EditText) findViewById(R.id.edtTitleEdit);
        edtBodyEdit = (EditText) findViewById(R.id.edtBodyEdit);
        btnUpdatePost = (Button) findViewById(R.id.btnUpdatePost);
        Id = getIntent().getStringExtra(id);
        UserId = getIntent().getStringExtra(userId);

        btnUpdatePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String title = edtTitleEdit.getText().toString();
                final String body = edtBodyEdit.getText().toString();

                if (title.isEmpty() || body.isEmpty()) {
                    Toast.makeText(ActivityEditPost.this, "اطلاعات کامل نیست", Toast.LENGTH_SHORT).show();
                } else {


                    editInterface=EditApiClient.geteditApiClient(url).create(EditInterface.class);

                    ActivityListEditPost editListPost=new ActivityListEditPost(title,body);
                    Call<ActivityListEditPost> callEdit=editInterface.getEditPost(Id,editListPost);

                    callEdit.enqueue(new Callback<ActivityListEditPost>() {
                        @Override
                        public void onResponse(Call<ActivityListEditPost> callEdit, Response<ActivityListEditPost> response) {
                            if (response.isSuccessful()){
                                showEdit(response.body());
                                Log.i(response.body().title,body);
                                Toast.makeText(ActivityEditPost.this, "SUCSSES", Toast.LENGTH_SHORT).show();

                            }
                        }

                        @Override
                        public void onFailure(Call<ActivityListEditPost> callEdit, Throwable t) {

                        }
                    });

                }


            }
        });
    }

    private void showEdit(ActivityListEditPost activityListEditPost){
        activityListEditPost.getTitle();
        activityListEditPost.getBody();
    }

}

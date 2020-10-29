package com.example.np.retrofitgitlab;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface NewPostInterface {

    @POST("/posts")
    Call<NewListPost> getNewPost(@Body NewListPost newListPost);

}

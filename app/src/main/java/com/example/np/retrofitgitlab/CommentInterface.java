package com.example.np.retrofitgitlab;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface CommentInterface{

    @GET("/posts/{id}/comments")
    Call<List<ActivityListComment>> getlistComment(@Path("id") String id);

}
















package com.example.np.retrofitgitlab;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("/posts")
    Call<List<ActivityListPost>> getListPost();

}

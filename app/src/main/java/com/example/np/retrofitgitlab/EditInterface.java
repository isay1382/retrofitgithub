package com.example.np.retrofitgitlab;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

public interface EditInterface {

    @PATCH("/posts/{id}")
    Call<ActivityListEditPost> getEditPost(@Path("id") String id, @Body ActivityListEditPost editListPost);


}

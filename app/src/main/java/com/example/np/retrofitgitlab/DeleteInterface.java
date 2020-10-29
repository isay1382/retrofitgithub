package com.example.np.retrofitgitlab;


import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Path;

public interface DeleteInterface {

    @DELETE("/posts/{id}")
    Call<ListDeletePost> getDeletePost(@Path("id") String id);
}

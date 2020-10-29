package com.example.np.retrofitgitlab;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CommentApiClient {

    public static Retrofit retrofit=null;

    public static Retrofit getCommentApiClient(String url){

        if (retrofit==null){

            retrofit=new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }

        return retrofit;

    }

}

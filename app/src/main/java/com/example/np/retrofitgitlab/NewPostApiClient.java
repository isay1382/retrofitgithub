package com.example.np.retrofitgitlab;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewPostApiClient {

    public static Retrofit retrofit=null;

    public static Retrofit getNewPostClient(String urlNew){

        if (retrofit==null){

            retrofit=new Retrofit.Builder()
                    .baseUrl(urlNew)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }

}

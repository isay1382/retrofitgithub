package com.example.np.retrofitgitlab;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActivityApiClient {

    public static Retrofit retrofit=null;

    public static Retrofit getApiClient(String url){

        if (retrofit==null){

            retrofit=new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }

        return retrofit;

    }

}

package com.example.np.retrofitgitlab;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DeleteApiClient {

    public static Retrofit retrofit=null;

    public static Retrofit getDeleteApiClient(String urlDelete){

        if (retrofit==null){

            retrofit=new Retrofit.Builder()
                    .baseUrl(urlDelete)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }
}

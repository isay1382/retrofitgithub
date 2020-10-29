package com.example.np.retrofitgitlab;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EditApiClient {

    public static Retrofit retrofit=null;

    public static Retrofit geteditApiClient(String urlEdit){

        if (retrofit==null){

            retrofit=new Retrofit.Builder()
                    .baseUrl(urlEdit)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;

    }

}

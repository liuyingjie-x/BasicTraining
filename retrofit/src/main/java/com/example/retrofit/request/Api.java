package com.example.retrofit.request;

import com.example.retrofit.model.Repo;
import com.example.retrofit.model.WanAndroid;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
    @GET("/wxarticle/chapters/json")
    Call<WanAndroid> requestTest();

    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);
}

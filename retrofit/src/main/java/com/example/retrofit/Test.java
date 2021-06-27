package com.example.retrofit;

import android.util.Log;

import com.example.retrofit.model.Repo;
import com.example.retrofit.request.Api;
import com.example.retrofit.request.GithubService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Test {
    public void request() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        GithubService githubService = retrofit.create(GithubService.class);
        Call<List<Repo>> repos = githubService.listRepos("liuyingjie-x");
        Call<List<Repo>> repos1 = githubService.listRepos("liuyingjie-x");

//        githubService.listRepos("liuyingjie-x").enqueue(new Callback<List<Repo>>() {
//            @Override
//            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
//                Log.e("response", response.body().toString());
//            }
//
//            @Override
//            public void onFailure(Call<List<Repo>> call, Throwable t) {
//                Log.e("response", t.toString());
//            }
//        });
    }
}

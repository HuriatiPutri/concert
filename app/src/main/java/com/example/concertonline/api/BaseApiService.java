package com.example.concertonline.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface BaseApiService {
    @GET("home_page")
    Call<ResponseBody> HomeRequest();
}
package com.example.concertonline.api;

public class UtilsApi {

    // 10.0.2.2 ini adalah localhost.
//      public static final String BASE_URL_API = "http://internal.iramachannel.com/api/";
    public static final String BASE_URL_API = "http://me-play.herokuapp.com/api/v1/ ";

    public static BaseApiService getAPIService  (){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
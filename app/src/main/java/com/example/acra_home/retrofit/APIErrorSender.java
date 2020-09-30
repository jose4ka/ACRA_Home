package com.example.acra_home.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIErrorSender {

    public static final String PREFIX = "/errors";

    @POST(PREFIX)
    Call<String> sendErrorMessage(@Body String message);
}

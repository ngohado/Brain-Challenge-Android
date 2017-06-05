package com.hado.brainchallenge.network;

import com.hado.brainchallenge.model.UserInfo;
import com.hado.brainchallenge.network.response.ApiResponse;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Hado on 5/25/17.
 */

public interface ApiClient {

    @POST("login")
    @FormUrlEncoded
    Single<ApiResponse<UserInfo>> login(@Field("username") String username, @Field("password") String password);
}

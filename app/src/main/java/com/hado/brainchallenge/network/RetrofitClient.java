package com.hado.brainchallenge.network;

import com.hado.brainchallenge.constant.AppConstant;

import java.io.File;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hado on 5/25/17.
 */

@Singleton
public class RetrofitClient {

  private Retrofit mRetrofit;

  private ApiClient mApiClient;

  @Inject
  public RetrofitClient() {
    mRetrofit = new Retrofit.Builder()
        .baseUrl(AppConstant.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
    mApiClient = mRetrofit.create(ApiClient.class);
  }

  public ApiClient getApiClient() {
    if (mApiClient == null) {
      mRetrofit.create(ApiClient.class);
    }
    return mApiClient;
  }

  public static MultipartBody.Part prepareFilePart(String path) {
    if (path == null) {
      return null;
    }
    File file = new File(path);

    if (!file.exists()) {
      return null;
    }
    RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);

    return MultipartBody.Part.createFormData("image", file.getName(), requestFile);
  }

}

package com.example.takeretrofit.api;


import com.example.takeretrofit.Config;
import com.example.takeretrofit.retrofit.httpsubscriber.httpwithoutdata.HttpResultWithoutData;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by price on 1/14/2017.
 */

public interface AuthenticationApi {
    String BASE_URL = Config.USER_URL;
    @FormUrlEncoded
    @POST("updateStuMsg")
    Observable<HttpResultWithoutData> authenticate(@Field(Config.KEY_TOKEN) String token,
                                                   @Field(Config.KEY_STU_ID) String stu_id,
                                                   @Field(Config.KEY_STU_PASSWORD) String stu_password);
}

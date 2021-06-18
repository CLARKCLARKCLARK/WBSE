package com.skypan.wbse.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {
    @FormUrlEncoded
    @POST("signIn")
    Call<Ack> signIn(@Field("email") String email,
                     @Field("password") String password);

    @FormUrlEncoded
    @POST("signUp")
    Call<Ack> signUp(@Field("email") String email,
                     @Field("password") String password);

    @POST("newArticle")
    Call<Ack> newEvent(@Body article e);

    @DELETE("deleteActicle/{articleId}")
    Call<Ack> deleteEvent(@Path("articleId") String articleId);


    @PUT("editActicle")
    Call<Ack> editActicle(@Body article e);

    @GET("userArticle")
    Call<List<article>> userArticle(@Query("userId") String userId);

    @GET("lastArticle")
    Call<List<article>> lastArticle();

    @GET("popularArticle")
    Call<List<article>> popularArticle();


}
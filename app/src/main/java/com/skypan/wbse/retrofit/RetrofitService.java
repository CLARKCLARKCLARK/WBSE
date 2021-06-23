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
    Call<Ack> newEvent(@Body Article e);

    @DELETE("deleteActicle/{articleId}")
    Call<Ack> deleteEvent(@Path("articleId") String articleId);


    @PUT("editActicle")
    Call<Ack> editActicle(@Body Article e);


    @POST("{articleId}/newComment")
    Call<Ack> newComment(@Body CommentRequest e, @Path("articleId") String articleId);


    @GET("userArticle")
    Call<List<Article>> userArticle(@Query("userId") String userId);

    @GET("lastArticle")
    Call<List<Article>> lastArticle();

    @GET("popularArticle")
    Call<List<Article>> popularArticle();

    @GET("FavRequest/{userId}")
    Call<List<Article>> favorite(@Path("userId") String userId);


    @FormUrlEncoded
    @POST("newFavorite")
    Call<Ack> newFavorite(@Field("userId") String userId,
                     @Field("articleId") String articleId);

    @FormUrlEncoded
    @POST("removeFavorite")
    Call<Ack> removeFavorite(@Field("userId") String userId,
                     @Field("articleId") String articleId);
}
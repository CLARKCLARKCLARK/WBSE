package com.skypan.wbse.retrofit;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {

    //gg
    @POST("signIn")
    Call<Response> signIn(@Body user e);
//gg
    @POST("signUp")
    Call<Response> signUp(@Body user e);


    @POST("newArticle")
    Call<Ack> newEvent(@Body Article e);

    @DELETE("deleteArticle/{articleId}")
    Call<Ack> deleteEvent(@Path("articleId") String articleId);


    @PUT("editArticle")
    Call<Ack> editArticle(@Body ReplaceArticleRequest e);


    @POST("{articleId}/newComment")
    Call<Ack> newComment(@Body CommentRequest e, @Path("articleId") String articleId);


    @GET("userArticles/{id}")
    Call<List<Article>> userArticle( @Path("id") String id);

    @GET("searchNewArticles")
    Call<List<Article>> lastArticle();

    @GET("searchHotArticles")
    Call<List<Article>> popularArticle();

    @GET("favorite/{userId}")
    Call<List<Article>> favorite(@Path("userId") String userId);


    @POST("newFavorite")
    Call<Ack> newFavorite(@Body FavRequest e);

    @FormUrlEncoded
    @POST("removeFavorite")
    Call<Ack> removeFavorite(@Field("userId") String userId,
                     @Field("articleId") String articleId);
}
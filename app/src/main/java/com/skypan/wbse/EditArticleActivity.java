package com.skypan.wbse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.skypan.wbse.retrofit.Ack;
import com.skypan.wbse.retrofit.Article;
import com.skypan.wbse.retrofit.RetrofitManager;
import com.skypan.wbse.retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditArticleActivity extends AppCompatActivity {

    private EditText title,content;
    private Article article =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_article);
        Button send = findViewById(R.id.send);
        title =findViewById(R.id.article_title);
        content = findViewById(R.id.article_content);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                article.setArticleName(title.getText().toString());
                article.setArticleContent(content.getText().toString());
                article.setAuthorId("");

                //todo
                RetrofitService retrofitService = RetrofitManager.getInstance().getService();
                Call<Ack> call = retrofitService.editActicle(article);
                call.enqueue(new Callback<Ack>() {
                    @Override
                    public void onResponse(Call<Ack> call, Response<Ack> response) {

                    }

                    @Override
                    public void onFailure(Call<Ack> call, Throwable t) {

                    }
                });


                Intent intent = new Intent(EditArticleActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
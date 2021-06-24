package com.skypan.wbse;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.skypan.wbse.retrofit.Ack;
import com.skypan.wbse.retrofit.Article;
import com.skypan.wbse.retrofit.ReplaceArticleRequest;
import com.skypan.wbse.retrofit.RetrofitManager;
import com.skypan.wbse.retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditArticleActivity extends AppCompatActivity {

    private EditText title,content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_article);

        SharedPreferences sharedPreferences = getSharedPreferences("userId" , MODE_PRIVATE);
        String id = sharedPreferences.getString("Id" ,"");
        Button send = findViewById(R.id.send);
        title =findViewById(R.id.article_title);
        content = findViewById(R.id.article_content);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(title.getText().toString());

               ReplaceArticleRequest article = new ReplaceArticleRequest();
                Intent intent = getIntent();
                String ArticleId = intent.getStringExtra("ArticleId");
                article.setArticleName(title.getText().toString());
                article.setArticleContent(content.getText().toString());
                article.setAuthorId(id);
                article.setArticleId(ArticleId);

                //todo
                RetrofitService retrofitService = RetrofitManager.getInstance().getService();
                Call<Ack> call = retrofitService.editArticle(article);
                call.enqueue(new Callback<Ack>() {
                    @Override
                    public void onResponse(Call<Ack> call, Response<Ack> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(EditArticleActivity.this, "伺服器錯誤，請稍後再試", Toast.LENGTH_SHORT).show();
                        }
                        else{
                        }
                    }

                    @Override
                    public void onFailure(Call<Ack> call, Throwable t) {

                    }
                });


                Intent intent2 = new Intent(EditArticleActivity.this, MainActivity.class);
                startActivity(intent2);


            }
        });
    }
}
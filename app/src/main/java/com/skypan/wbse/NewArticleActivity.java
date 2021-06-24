package com.skypan.wbse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.skypan.wbse.retrofit.Ack;
import com.skypan.wbse.retrofit.RetrofitManager;
import com.skypan.wbse.retrofit.RetrofitService;
import com.skypan.wbse.retrofit.Article;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewArticleActivity extends AppCompatActivity {

    private EditText title,content;
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
                SharedPreferences sharedPreferences = getSharedPreferences("userId" , MODE_PRIVATE);
                String id = sharedPreferences.getString("Id" ,"");
                System.out.println("id" + id);
                Article article = new Article();
                article.setArticleName(title.getText().toString());
                article.setArticleContent(content.getText().toString());
                article.setAuthorId(id);

                //todo
                RetrofitService retrofitService = RetrofitManager.getInstance().getService();
                Call<Ack> call = retrofitService.newEvent(article);
                call.enqueue(new Callback<Ack>() {
                    @Override
                    public void onResponse(Call<Ack> call, Response<Ack> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(NewArticleActivity.this, "伺服器錯誤，請稍後再試", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(NewArticleActivity.this, "success", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(NewArticleActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();

                        }
                    }

                    @Override
                    public void onFailure(Call<Ack> call, Throwable t) {

                    }
                });


                Intent intent = new Intent(NewArticleActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
package com.skypan.wbse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.skypan.wbse.retrofit.Account;
import com.skypan.wbse.retrofit.Ack;
import com.skypan.wbse.retrofit.Response;
import com.skypan.wbse.retrofit.RetrofitManager;
import com.skypan.wbse.retrofit.RetrofitService;
import com.skypan.wbse.retrofit.user;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

public class SignUpActivity extends AppCompatActivity {

    private TextInputLayout email, password,passwordAgain;
    private Button btnSendMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email = findViewById(R.id.etEmailLayout);
        password = findViewById(R.id.etPassword);
        passwordAgain = findViewById(R.id.etPasswordAgain);
        btnSendMail = findViewById(R.id.btnSendVerifyEmail);

        //todo:
        btnSendMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("FFFFFF");
                String email_text = email.getEditText().getText().toString();
                String password1 = password.getEditText().getText().toString();
                String password2 = passwordAgain.getEditText().getText().toString();
                if (password1.equals(password2)) {

                    user user = new user();
                    user.setUserId(email_text);
                    user.setPassword(password1);

                    RetrofitService retrofitService = RetrofitManager.getInstance().getService();
                    Call<Response> call = retrofitService.signUp(user);
                    call.enqueue(new Callback<Response>() {
                        @Override
                        public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                            if(!response.isSuccessful()){
                                Toast.makeText(SignUpActivity.this, "伺服器錯誤，請稍後再試", Toast.LENGTH_SHORT).show();
                            }
                            else{

                                SharedPreferences sharedPreferences = getSharedPreferences("userId" , MODE_PRIVATE);
                                sharedPreferences.edit().putString("Id" , email_text).apply();


                                Toast.makeText(SignUpActivity.this, "請重新登入", Toast.LENGTH_SHORT).show();//去信箱收信
                                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onFailure(Call<Response> call, Throwable t) {

                        }
                    });
                } else {
                    Toast.makeText(SignUpActivity.this, "密碼不一致", Toast.LENGTH_SHORT).show();
                }




            }
        });
    }
}
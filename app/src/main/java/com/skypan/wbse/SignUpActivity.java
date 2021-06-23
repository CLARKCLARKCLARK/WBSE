package com.skypan.wbse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.skypan.wbse.retrofit.Ack;
import com.skypan.wbse.retrofit.RetrofitManager;
import com.skypan.wbse.retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                String email_text = email.getEditText().getText().toString();
                String password1 = password.getEditText().getText().toString();
                String password2 = passwordAgain.getEditText().getText().toString();
                if (password1.equals(password2)) {
                    RetrofitService retrofitService = RetrofitManager.getInstance().getService();
                    Call<Ack> call = retrofitService.signUp(email_text, password1);
                    call.enqueue(new Callback<Ack>() {
                        @Override
                        public void onResponse(Call<Ack> call, Response<Ack> response) {
                            if (!response.isSuccessful()) {
                                Toast.makeText(SignUpActivity.this, "伺服器錯誤，請稍後再試", Toast.LENGTH_SHORT).show();
                            } else {
                                Ack ack = response.body();
                                if (ack.getCode() == 200) {
                                    Intent intent = new Intent(SignUpActivity.this, LoginFragment.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(SignUpActivity.this, "錯誤訊息: " + ack.getMsg(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<Ack> call, Throwable t) {
                            Toast.makeText(SignUpActivity.this, "連線錯誤，請稍後再試", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Toast.makeText(SignUpActivity.this, "密碼不一致", Toast.LENGTH_SHORT).show();
                }




            }
        });
    }
}
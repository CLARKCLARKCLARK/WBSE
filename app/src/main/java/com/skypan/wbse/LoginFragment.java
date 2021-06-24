package com.skypan.wbse;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.skypan.wbse.retrofit.Ack;
import com.skypan.wbse.retrofit.Response;
import com.skypan.wbse.retrofit.RetrofitManager;
import com.skypan.wbse.retrofit.RetrofitService;
import com.skypan.wbse.retrofit.user;

import retrofit2.Call;
import retrofit2.Callback;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private Button register,login;
    private TextInputEditText loginEmail,password;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        SharedPreferences sharedPreferences = getContext().getSharedPreferences("userId", MODE_PRIVATE);
        String id = sharedPreferences.getString("Id", "");
        if(id==""){
            View root = inflater.inflate(R.layout.fragment_login, container, false);

            login = root.findViewById(R.id.btnLogin);
            register = root.findViewById(R.id.btnregister);
            loginEmail = root.findViewById(R.id.etLoginEmail);
            password = root.findViewById(R.id.etLoginPassword);

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    user user = new user();
                    user.setUserId(loginEmail.getText().toString());
                    user.setPassword(password.getText().toString());
                    RetrofitService retrofitService = RetrofitManager.getInstance().getService();
                    Call<Response> call = retrofitService.signIn(user);
                    call.enqueue(new Callback<Response>() {
                        @Override
                        public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                            if (!response.isSuccessful()) {
                                Toast.makeText(getContext(), "伺服器錯誤，請稍後再試", Toast.LENGTH_SHORT).show();
                            } else {

                                Toast.makeText(getContext(), "login success", Toast.LENGTH_SHORT).show();
                                SharedPreferences sharedPreferences = getContext().getSharedPreferences("userId", MODE_PRIVATE);
                                sharedPreferences.edit().putString("Id", loginEmail.getText().toString()).apply();
                                String id = sharedPreferences.getString("Id", "");
                                System.out.println("id"+id);

                                Intent intent = new Intent(getContext(), MainActivity.class);
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onFailure(Call<Response> call, Throwable t) {

                        }
                    });

                }
            });

            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), SignUpActivity.class);
                    startActivity(intent);
                }
            });


            return root;
        }
        else {
            View root = inflater.inflate(R.layout.fragment_out, container, false);

            SharedPreferences preferences = getActivity().getSharedPreferences("userId", 0);
            preferences.edit().remove("Id").commit();

            Button logout ;

            logout = root.findViewById(R.id.logout);

            logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    startActivity(intent);

                    Toast.makeText(getContext(), "logout success", Toast.LENGTH_SHORT).show();
                }
            });

            return root;
        }
    }


}

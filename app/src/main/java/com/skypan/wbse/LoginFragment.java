package com.skypan.wbse;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private Button register,login;
    private EditText loginEmail,password;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_login, container, false);

        login = root.findViewById(R.id.btnLogin);
        register = root.findViewById(R.id.btnregister);
        loginEmail =root.findViewById(R.id.etLoginEmail);
        password =root.findViewById(R.id.etPassword);

        //todo:
//        RetrofitService retrofitService = RetrofitManager.getInstance().getService();
//        Call<Ack> call = retrofitService.signIn(loginEmail.getText().toString(),password.getText().toString());
//        call.enqueue(new Callback<Ack>() {
//            @Override
//            public void onResponse(Call<Ack> call, Response<Ack> response) {
//                if (!response.isSuccessful()) {
//                    Toast.makeText(getActivity(), "伺服器錯誤，請稍後再試", Toast.LENGTH_SHORT).show();
//                }
//
//
//            }
//
//            @Override
//            public void onFailure(Call<Ack> call, Throwable t) {
//
//            }
//        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SignUpActivity.class);
                startActivity(intent);
            }
        });


        return root;
    }

}

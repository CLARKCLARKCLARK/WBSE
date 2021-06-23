package com.skypan.wbse;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.skypan.wbse.adapter.cardAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_main, container, false);
        RecyclerView rv_1 = root.findViewById(R.id.rv_1);
        FloatingActionButton add_article = root.findViewById(R.id.add_article);
//
//        RetrofitService retrofitService = RetrofitManager.getInstance().getService();
//        Call<List<Article>> call = retrofitService.lastArticle();
//        //todo:
//        call.enqueue(new Callback<List<Article>>() {
//            @Override
//            public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {
//                if (!response.isSuccessful()) {
//                    Toast.makeText(getActivity(), "伺服器錯誤，請稍後再試", Toast.LENGTH_SHORT).show();
//                }
//                List<Article> articles = response.body();
//
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Article>> call, Throwable t) {
//
//            }
//        });


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_1.setLayoutManager(linearLayoutManager);
        rv_1.setAdapter(new cardAdapter(getActivity()));

        add_article.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NewArticleActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }

}

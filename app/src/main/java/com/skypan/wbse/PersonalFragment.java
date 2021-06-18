package com.skypan.wbse;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.skypan.wbse.adapter.cardAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalFragment extends Fragment {
    public PersonalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_personal, container, false);
        RecyclerView rv_1 = root.findViewById(R.id.rv_1);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_1.setLayoutManager(linearLayoutManager);
        rv_1.setAdapter(new cardAdapter(getActivity()));

        return root;
    }

}

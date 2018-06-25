package com.example.eslam.wheretogo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eslam.wheretogo.Adapter.Recycler_Adapter_Community;
import com.example.eslam.wheretogo.Model.Community_Model;

import java.util.ArrayList;
import java.util.List;


public class Community_Fragment extends Fragment {
    public Community_Fragment() {
    }


    private Recycler_Adapter_Community adapter_community;
    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.community, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_community);

        List<Community_Model> community_models = new ArrayList<>();

        community_models.add(new Community_Model("Giza Football", R.drawable.football));
        community_models.add(new Community_Model("Cairo Runners", R.drawable.cairo));
        community_models.add(new Community_Model("GDG Cairo", R.drawable.udacity));
        community_models.add(new Community_Model("Cairo Movie Club", R.drawable.cairo_movie));

        adapter_community = new Recycler_Adapter_Community(getActivity(), community_models);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter_community);

        return rootView;
    }

}

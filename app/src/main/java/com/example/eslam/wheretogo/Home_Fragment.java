package com.example.eslam.wheretogo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eslam.wheretogo.Adapter.Recycler_Adapter_Category;
import com.example.eslam.wheretogo.Model.Category_Model;

import java.util.ArrayList;
import java.util.List;

public class Home_Fragment extends Fragment {
    public Home_Fragment() {
    }

    private Recycler_Adapter_Category adapter_category;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_home);

        List<Category_Model> category_models = new ArrayList<>();

        category_models.add(new Category_Model("Sport & Fitness", R.drawable.sports));
        category_models.add(new Category_Model("Family", R.drawable.family));
        category_models.add(new Category_Model("Tech", R.drawable.tech));
        category_models.add(new Category_Model("Film", R.drawable.film));
        category_models.add(new Category_Model("Health & Wellness", R.drawable.health));
        category_models.add(new Category_Model("Food & Drink", R.drawable.food));

        adapter_category = new Recycler_Adapter_Category(getActivity(), category_models);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(adapter_category);

        return rootView;
    }
}

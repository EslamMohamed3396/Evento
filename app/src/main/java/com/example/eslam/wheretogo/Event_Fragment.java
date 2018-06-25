package com.example.eslam.wheretogo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eslam.wheretogo.Adapter.Recycler_Adapter_Event;
import com.example.eslam.wheretogo.Model.Event_Model;

import java.util.ArrayList;
import java.util.List;

public class Event_Fragment extends Fragment {
    public Event_Fragment() {
    }

    private Recycler_Adapter_Event adapter_event;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.event, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_event);

        List<Event_Model> event_models = new ArrayList<>();

        event_models.add(new Event_Model("Cairo Football ", R.drawable.football));
        event_models.add(new Event_Model("Cairo Runners ", R.drawable.cairo));


        adapter_event = new Recycler_Adapter_Event(getActivity(), event_models);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter_event);

        return rootView;
    }
}


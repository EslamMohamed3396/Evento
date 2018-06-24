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

        event_models.add(new Event_Model("The objective of the Football Match Event Database (FMED) is to create a schema that maintains the individual micro events within a football match that lead to its macro events in order to support football research activities for the benefit of analysts, clubs, league organizations, media organizations, and other members of the football industry", R.drawable.football));
        event_models.add(new Event_Model("Cairo Runners is the first street running initiative in Cairo, providing Cairenes with exhilarating mini marathon experience every Friday morning. Let's Join With Us", R.drawable.cairo));
        event_models.add(new Event_Model("This is funny Yaaaaaaaay", R.drawable.ime));
        event_models.add(new Event_Model("This is funny Yaaaaaaaay", R.drawable.ime));
        event_models.add(new Event_Model("This is funny Yaaaaaaaay", R.drawable.ime));
        event_models.add(new Event_Model("This is funny Yaaaaaaaay", R.drawable.ime));
        event_models.add(new Event_Model("This is funny Yaaaaaaaay", R.drawable.ime));
        event_models.add(new Event_Model("This is funny Yaaaaaaaay", R.drawable.ime));
        event_models.add(new Event_Model("This is funny Yaaaaaaaay", R.drawable.ime));
        event_models.add(new Event_Model("This is funny Yaaaaaaaay", R.drawable.ime));
        event_models.add(new Event_Model("This is funny Yaaaaaaaay", R.drawable.ime));


        adapter_event = new Recycler_Adapter_Event(getActivity(), event_models);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter_event);

        return rootView;
    }
}


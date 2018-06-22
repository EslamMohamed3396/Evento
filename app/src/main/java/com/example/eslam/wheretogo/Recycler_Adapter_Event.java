package com.example.eslam.wheretogo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Recycler_Adapter_Event extends RecyclerView.Adapter<Recycler_Adapter_Event.ItemViewHolder> {
    private List<Event_Model> eventModels;

    public Recycler_Adapter_Event(List<Event_Model> eventModels) {
        this.eventModels = eventModels;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_event, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (eventModels == null) {
            return 0;
        }
        return eventModels.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        public ItemViewHolder(View itemView) {
            super(itemView);
            TextView tv_desc = (TextView) itemView.findViewById(R.id.tv_description_event);

        }

    }
}

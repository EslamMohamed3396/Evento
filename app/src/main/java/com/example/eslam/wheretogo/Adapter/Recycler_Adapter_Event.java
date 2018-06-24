package com.example.eslam.wheretogo.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eslam.wheretogo.Adapter.Recycler_Adapter_Event.ItemViewHolder;
import com.example.eslam.wheretogo.Model.Event_Model;
import com.example.eslam.wheretogo.R;

import java.util.List;

public class Recycler_Adapter_Event extends RecyclerView.Adapter<ItemViewHolder> {
    private List<Event_Model> eventModels;
    //private final EventAdapterOnClick movieAdapterOnClick;
    private Context context;

    public interface EventAdapterOnClick {
        void onClick(Event_Model event);
    }

    public Recycler_Adapter_Event(Context context, List<Event_Model> eventModels) {
        this.context = context;
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
        Event_Model event_model = eventModels.get(position);
        holder.tv_desc.setText(event_model.getmDescreption());
        holder.im_event.setImageResource(event_model.getmImage());
    }

    @Override
    public int getItemCount() {
        if (eventModels == null) {
            return 0;
        }
        return eventModels.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_desc;
        ImageView im_event;

        public ItemViewHolder(View itemView) {
            super(itemView);
            tv_desc = (TextView) itemView.findViewById(R.id.tv_description_event);
            im_event = (ImageView) itemView.findViewById(R.id.im_event);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
           /* int adapterPosition = getAdapterPosition();
            Event_Model event_model = eventModels.get(adapterPosition);
            movieAdapterOnClick.onClick(event_model);*/
        }
    }
}

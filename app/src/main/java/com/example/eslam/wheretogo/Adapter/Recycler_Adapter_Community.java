package com.example.eslam.wheretogo.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eslam.wheretogo.Adapter.Recycler_Adapter_Community.ItemViewHolder;
import com.example.eslam.wheretogo.Model.Community_Model;
import com.example.eslam.wheretogo.R;

import java.util.List;

public class Recycler_Adapter_Community extends RecyclerView.Adapter<ItemViewHolder> {
    private List<Community_Model> community_models;
    //  public final CommunityOnClick communityOnClick;
    private Context context;

    public Recycler_Adapter_Community(Context context, List<Community_Model> community_models) {
        this.context = context;
        this.community_models = community_models;
    }

    @Override
    public Recycler_Adapter_Community.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_community, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    public interface CommunityOnClick {
        void OnClick(Community_Model community_model);
    }

    @Override
    public void onBindViewHolder(Recycler_Adapter_Community.ItemViewHolder holder, int position) {
        Community_Model community_model = community_models.get(position);
        holder.tv_desc.setText(community_model.getmDescreption());
        holder.im_event.setImageResource(community_model.getmImage());
    }

    @Override
    public int getItemCount() {
        if (community_models == null) {
            return 0;
        }
        return community_models.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_desc;
        ImageView im_event;

        public ItemViewHolder(View itemView) {
            super(itemView);
            tv_desc = (TextView) itemView.findViewById(R.id.tv_description_community);
            im_event = (ImageView) itemView.findViewById(R.id.im_community);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
           /* int adpdterPostion = getAdapterPosition();
            Community_Model community_model = community_models.get(adpdterPostion);
            communityOnClick.OnClick(community_model);*/
        }
    }
}

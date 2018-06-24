package com.example.eslam.wheretogo.Adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eslam.wheretogo.Adapter.Recycler_Adapter_Category.CategoryItem;
import com.example.eslam.wheretogo.Model.Category_Model;
import com.example.eslam.wheretogo.R;

import java.util.List;

public class Recycler_Adapter_Category extends RecyclerView.Adapter<CategoryItem> {
    private List<Category_Model> category_models;
    //   private  final CategoryOnClick categoryOnClick;
    private Context context;

    public Recycler_Adapter_Category(Context context, List<Category_Model> category_models) {
        this.context = context;
        this.category_models = category_models;
    }

    @Override
    public CategoryItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootview = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_home, parent, false);
        CategoryItem categoryItem = new CategoryItem(rootview);
        return categoryItem;
    }

    @Override
    public void onBindViewHolder(CategoryItem holder, int position) {

        Category_Model category_model = category_models.get(position);
        holder.im_category.setImageResource(category_model.getmImage());
        holder.tv_category.setText(category_model.getmName());
    }

    @Override
    public int getItemCount() {
        if (category_models == null) {
            return 0;
        }
        return category_models.size();
    }

    private interface CategoryOnClick {
        void OnClick(Category_Model community_model);
    }

    class CategoryItem extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_category;
        ImageView im_category;

        public CategoryItem(View itemView) {
            super(itemView);
            im_category = (ImageView) itemView.findViewById(R.id.im_category);
            tv_category = (TextView) itemView.findViewById(R.id.tv_category);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
          /*  int adpdterPostion = getAdapterPosition();
            Category_Model category_model = category_models.get(adpdterPostion);
            categoryOnClick.OnClick(category_model);*/
        }
    }
}

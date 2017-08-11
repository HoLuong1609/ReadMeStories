package ominext.com.readmestories.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ominext.com.readmestories.BR;
import ominext.com.readmestories.R;
import ominext.com.readmestories.databinding.ItemCategoryBinding;
import ominext.com.readmestories.models.Category;

/**
 * Created by LuongHH on 6/21/2017.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private Context mContext;
    private List<Category> mCategories;

    public CategoryAdapter(Context context, List<Category> list) {
        this.mContext = context;
        this.mCategories = list;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_category, parent, false);
        ItemCategoryBinding binding = ItemCategoryBinding.bind(itemView);
        return new CategoryViewHolder(binding.getRoot(), binding);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        Category category = mCategories.get(position);
        holder.mBinding.setCategory(category);
        holder.mBinding.setHandlers(this);
        holder.mBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mCategories == null ? 0 : mCategories.size();
    }

    public void onCategoryClick(View view, Category category) {

    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {

        ItemCategoryBinding mBinding;

        CategoryViewHolder(View itemView, ItemCategoryBinding binding) {
            super(itemView);
            mBinding = binding;
        }
    }
}
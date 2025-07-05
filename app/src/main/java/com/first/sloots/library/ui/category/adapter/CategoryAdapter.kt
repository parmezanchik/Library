package com.first.sloots.library.ui.category.adapter


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.first.sloots.library.R
import com.first.sloots.library.ui.category.model.CategoryDM

class CategoryAdapter(
    private val onClick: (CategoryDM) -> Unit
) : ListAdapter<CategoryDM, CategoryAdapter.CategoryViewHolder>(DiffCallback) {

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val categoryTitle: TextView = itemView.findViewById(R.id.tvCategoryTitle)

        fun bind(item: CategoryDM) {
            categoryTitle.text = item.displayName
            itemView.setOnClickListener {
                Log.d("CategoryAdapter", "Clicked category: ${item.displayName}, ID: ${item.listNameEncoded}")
                onClick(item)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object DiffCallback : DiffUtil.ItemCallback<CategoryDM>() {
        override fun areItemsTheSame(oldItem: CategoryDM, newItem: CategoryDM): Boolean {
            return oldItem.displayName == newItem.displayName
        }

        override fun areContentsTheSame(oldItem: CategoryDM, newItem: CategoryDM): Boolean {
            return oldItem == newItem
        }
    }
}
package com.first.sloots.library.ui.book.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.first.sloots.library.databinding.ItemBookBinding
import com.first.sloots.library.ui.book.model.BooksDM
class BooksAdapter(
    private val onItemClick: (BooksDM) -> Unit
) : ListAdapter<BooksDM, BooksAdapter.BooksViewHolder>(BooksDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BooksViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        val book = getItem(position)
        holder.bind(book)
    }

    inner class BooksViewHolder(private val binding: ItemBookBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(book: BooksDM) {
            binding.textViewTitle.text = book.title ?: "No title"
            binding.root.setOnClickListener {
                onItemClick(book)
            }
        }
    }

    class BooksDiffCallback : DiffUtil.ItemCallback<BooksDM>() {
        override fun areItemsTheSame(oldItem: BooksDM, newItem: BooksDM): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: BooksDM, newItem: BooksDM): Boolean {
            return oldItem == newItem
        }
    }
}
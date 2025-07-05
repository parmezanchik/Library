package com.first.sloots.library.ui.book

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.first.sloots.library.databinding.FragmentBooksListBinding
import com.first.sloots.library.ui.book.adapter.BooksAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class BooksListFragment : Fragment() {

    private var _binding: FragmentBooksListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BooksViewModel by viewModel()

    private lateinit var adapter: BooksAdapter

    private val args: BooksListFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBooksListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        adapter = BooksAdapter { book ->
            val action = BooksListFragmentDirections
                .actionBooksListFragmentToBookDetailsFragment(book)
            findNavController().navigate(action)
        }

        binding.recyclerViewBooks.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewBooks.adapter = adapter

        viewModel.books.observe(viewLifecycleOwner) { books ->
            android.util.Log.d("BooksListFragment", "Кількість книжок: ${books.size}")
            adapter.submitList(books)
        }
        Log.d("BooksListFragment", "Передано categoryId: ${args.categoryId}")


        viewModel.loadBooks(categoryId = args.categoryId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

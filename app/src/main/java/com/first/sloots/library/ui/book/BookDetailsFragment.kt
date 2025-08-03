package com.first.sloots.library.ui.book


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.first.sloots.library.data.network.model.BuyLinksItem
import com.first.sloots.library.databinding.FragmentBookDetailsBinding
import com.google.common.reflect.TypeToken
import com.google.gson.Gson

class BookDetailsFragment : Fragment() {

    private var _binding: FragmentBookDetailsBinding? = null
    private val binding get() = _binding!!

    private val args: BookDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.textViewTitle.text = args.title
        binding.textViewDescription.text = args.description
        Glide.with(this).load(args.imageUrl).into(binding.imageViewCover)

//        binding.textViewBuyLink.setOnClickListener {
//            val url = args.buyLink
//            if (url.isNotEmpty()) {
//                val intent = Intent(Intent.ACTION_VIEW)
//                intent.data = url.toUri()
//                startActivity(intent)
//            }
//        }
        val type = object : TypeToken<List<BuyLinksItem>>() {}.type
        val links: List<BuyLinksItem> = Gson().fromJson(args.buyLink, type)
        links.forEach { item ->
            item.url?.takeIf {
                it.isNotEmpty()
            }?.apply {
                val tv = TextView(requireContext())
                tv.apply {
                    text = item.name
                    setOnClickListener {
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = toUri()
                        startActivity(intent)
                    }
                }
                binding.llLinks.addView(tv)

            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

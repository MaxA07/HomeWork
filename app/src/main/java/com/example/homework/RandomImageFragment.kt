package com.example.homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.homework.databinding.FragmentRandomImageBinding
import java.net.URLEncoder
import java.nio.charset.StandardCharsets



class RandomImageFragment : Fragment() {

    lateinit var binding: FragmentRandomImageBinding
    private var useKeyword: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRandomImageBinding.inflate(layoutInflater, container, false)

        binding.RandomImageButton.setOnClickListener {
            onGetRandomImagePressed()
        }

        binding.setText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                return@setOnEditorActionListener onGetRandomImagePressed()
            }
            return@setOnEditorActionListener false
        }

        binding.keyWordCheckBox.setOnClickListener {
            this.useKeyword = binding.keyWordCheckBox.isChecked
            updateUi()
        }
        updateUi()


        return binding.root
    }

    private fun onGetRandomImagePressed(): Boolean {

        val keyword = binding.setText.text.toString()
        if (useKeyword && keyword.isBlank()) {
            binding.setText.error = "KeyWord is empty"
            return true
        }

        val encodedKeyWord = URLEncoder.encode(keyword, StandardCharsets.UTF_8.name())
        Glide.with(this)
            .load("https://source.unsplash.com/random/800x600?${if (useKeyword) "?$encodedKeyWord" else ""}")
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(binding.testImageView)
        return false
    }

    private fun updateUi() = with(binding) {
        keyWordCheckBox.isChecked = useKeyword
        if (useKeyword) {
            setText.visibility = View.VISIBLE
        }
        else {
            setText.visibility = View.GONE
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = RandomImageFragment()
    }
}
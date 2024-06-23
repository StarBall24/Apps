package com.example.starball24.ViewModel

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.starball24.R

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    Glide.with(view.context)
        .load(url)
        .placeholder(R.drawable.placeholder_svgrepo_com) // placeholder image
        .error(R.drawable.error_alt_svgrepo_com) // error image
        .into(view)
}

package com.example.learning.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("setURL")
fun ImageView.setURL(url:String) {
    Glide.with(this.context).load(url).into(this)
}
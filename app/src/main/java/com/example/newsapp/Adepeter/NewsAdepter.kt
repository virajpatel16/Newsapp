package com.example.newsapp.Adepeter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.newsapp.Model.Newsmodel
import com.example.newsapp.R
import com.example.newsapp.databinding.NewsItemBinding

class NewsAdepter(Newslist: ArrayList<Newsmodel>) : RecyclerView.Adapter<NewsAdepter.Newsholder>() {
    var list = Newslist
    lateinit var context:Context


    class Newsholder(itemView: NewsItemBinding) : ViewHolder(itemView.root) {

        var binding = itemView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Newsholder {
        var binding = NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Newsholder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("ResourceType")
    override fun onBindViewHolder(holder: Newsholder, position: Int) {
        holder.binding.apply {
            id.text = list.get(position).id.toString()
            name.text = list.get(position).name
            content.text = list.get(position).content
            totalResults.text= list.get(position).totalResults.toString()
            url.text=list.get(position).url
            title.text=list.get(position).title
            description.text=list.get(position).description
            authore.text=list.get(position).author
            publishedat.text= list.get(position).publishedAt.toString()


Glide.with(context)
    .load("https://techcrunch.com/wp-content/uploads/2023/06/Alok-Siddharth-1.jpg?resize=1200,801")
    .into(img)

        }
    }
}
package com.kotlin.news_api.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.kotlin.news_api.data.model.Article
import com.kotlin.news_api.databinding.ListItemBinding

class NewsAdapter() : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<Article>() {

        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url;
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem;
        }

    }
    val differ = AsyncListDiffer(this, callback)

    inner class NewsViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.title.text = article.title;
            Glide.with(binding.articleImage.context).
            load(article.urlToImage).into(binding.articleImage)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false);
        return NewsViewHolder(binding);
    }

    override fun getItemCount(): Int {
        return differ.currentList.size;
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.bind(article)

    }

}
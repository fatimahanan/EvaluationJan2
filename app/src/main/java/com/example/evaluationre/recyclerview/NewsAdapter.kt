package com.example.evaluationre.recyclerview

import com.example.evaluationre.R
import com.example.evaluationre.SecondFragment
import com.example.evaluationre.api.NewsModel
import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(mainActivity: SecondFragment) : RecyclerView.Adapter<NewsViewHolder>() {

    private var mClickListener: ItemClickListener = mainActivity

    private var newsList = listOf<NewsModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        Log.e("Adapter viewType", viewType.toString())
        val mContext = parent.context
        val layoutInflater = LayoutInflater.from(mContext)
        val view = layoutInflater.inflate(R.layout.recycler_view_item, parent, false)
        return NewsViewHolder(view, mClickListener)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        Log.e("Adapter position", position.toString())

        val newsModel = newsList[position]

        holder.textViewTitle.text = newsModel.title
        holder.textViewDescription.text = newsModel.description
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    fun updateData(newsModel: List<NewsModel>) {
        newsList = newsModel
        notifyDataSetChanged()
    }

    interface ItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }
}

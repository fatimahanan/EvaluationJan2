    package com.example.evaluationre.recyclerview

    import android.view.View
    import android.widget.TextView
    import androidx.recyclerview.widget.RecyclerView
    import com.example.evaluationre.R

    class NewsViewHolder(itemView: View, mClickListener: NewsAdapter.ItemClickListener) :
        RecyclerView.ViewHolder(itemView) {

        var textViewTitle: TextView = itemView.findViewById<TextView>(R.id.title_text_view)
        var textViewDescription: TextView = itemView.findViewById<TextView>(R.id.description_text_view)

        init {
            itemView.setOnClickListener { view ->
                mClickListener.onItemClick(view, adapterPosition)
            }
        }
    }
package com.example.news_app.ui.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.news_app.R
import com.example.news_app.databinding.ItemNewsBinding
import com.example.news_app.model.ArticlesItem

class NewsAdapter(var items:List<ArticlesItem?>?= null):Adapter<NewsAdapter.viewholder>() {
    class viewholder(val itemBinding:ItemNewsBinding):ViewHolder(itemBinding.root){
//        val author:TextView=itemview.findViewById(R.id.title_author)
//        val Image:ImageView=itemview.findViewById(R.id.image_news)
//        val date:TextView=itemview.findViewById(R.id.date_time)
//        val title:TextView=itemview.findViewById(R.id.title_news)

        fun bind(items: ArticlesItem?){
            itemBinding.item=items
            itemBinding.invalidateAll()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
//       val view =LayoutInflater.from(parent.context)
//           .inflate(R.layout.item_news,parent,false)
//        return  viewholder(view)
        val viewBinding:ItemNewsBinding =DataBindingUtil
            .inflate(LayoutInflater.from(parent.context),R.layout.item_news,parent,false)
        return viewholder(viewBinding)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
       val item =items!![position]
       holder.bind(item)

            onItemClickListener.let {
                holder.itemView.setOnClickListener {
                    onItemClickListener?.onClick(position,item!!)
                }
            }

    }

    override fun getItemCount(): Int =items?.size ?:0

    var onItemClickListener: OnItemClickListener?=null
    interface OnItemClickListener{
        fun onClick(position: Int,items: ArticlesItem)
    }
    fun changeData(data: List<ArticlesItem?>?){
        this.items=data

         notifyDataSetChanged()
    }
}
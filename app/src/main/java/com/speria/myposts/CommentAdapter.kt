package com.speria.myposts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.speria.myposts.databinding.CommentsListItemBinding

class CommentsAdapter(var comment: List<comment>) : RecyclerView.Adapter<RetrofitViewsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewsHolder {
        var binding=CommentsListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  RetrofitViewsHolder(binding)
    }
    override fun onBindViewHolder(holder: RetrofitViewsHolder, position: Int) {
        var currentcomment=comment.get(position)
        with(holder.binding){
            tvId.text=currentcomment.name.toString()
            tvTitle.text=currentcomment.body.toString()
            tvbody.text=currentcomment.body.toString()

        }
    }

    override fun getItemCount(): Int {
        return comment.size
    }

}

class RetrofitViewsHolder(var binding: CommentsListItemBinding) :
    RecyclerView.ViewHolder(binding.root)
package com.speria.myposts

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.speria.myposts.databinding.ListItemsBinding
import retrofit2.Retrofit

class PostAdapter(var context: Context, var post: List<Post>):
    RecyclerView.Adapter<RetrofitViewHolder>() {



    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        var current = post.get(position)
        with(holder.bindingView) {
            tvid.text= current.id.toString()
            tvUserId.text = current.userId.toString()
            tvTitle.text= current.title
            tvBody.text = current.body
        }
    }
    override fun getItemCount(): Int {
        return post.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
        var binding =ListItemsBinding.inflate(LayoutInflater.from(context), parent, false)
        return RetrofitViewHolder(binding)
    }
}
class RetrofitViewHolder(var bindingView: ListItemsBinding):
    RecyclerView.ViewHolder(bindingView.root)
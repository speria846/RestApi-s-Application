package com.speria.myposts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.speria.myposts.databinding.ListItemsBinding
import org.w3c.dom.Comment
import retrofit2.Retrofit

class PostAdapter( var post: List<Post>): RecyclerView.Adapter<RetrofitViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
        var binding=ListItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RetrofitViewHolder(binding)
    }
    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        var current = post.get(position)
            holder.binding.tvid.text = current.id.toString()
        holder.binding.tvUserId.text = current.userId.toString()
        holder.binding.tvTitle.text = current.title
        holder.binding.tvBody.text = current.body

            val context = holder.itemView.context
            holder.binding.cvPosts.setOnClickListener {
                val intent = Intent(context, CommentActivity::class.java)
                intent.putExtra("POST_ID", current.id)
                context.startActivity(intent)
            }
        }
        override fun getItemCount(): Int {
            return post.size
        }
    }
class RetrofitViewHolder(var binding: ListItemsBinding): RecyclerView.ViewHolder(binding.root)
    
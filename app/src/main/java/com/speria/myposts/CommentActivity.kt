package com.speria.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.speria.myposts.databinding.ActivityCommentBinding
import com.speria.myposts.databinding.ActivityMainBinding
import org.w3c.dom.Comment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentActivity : AppCompatActivity() {
    lateinit var binding: ActivityCommentBinding
    var postId = 0
    var commentId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainPostId()
        getPostById()
        obtainPostId2()
        fetchComments()
    }

    fun obtainPostId() {
        postId = intent.extras?.getInt("POST_ID") ?: 0
    }

    fun getPostById() {
        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getPostById(postId)
        request.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful) {
                    var post = response.body()

                    binding.textView.text = post?.title
                    binding.textView2.text = post?.body

                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

        })
    }

    fun obtainPostId2() {
        commentId = intent.extras?.getInt("commentId") ?: 0
    }

    fun fetchComments() {
        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getcomments()
        request.enqueue(object : Callback<List<comment>> {
            override fun onResponse(
                call: Call<List<comment>>,
                response: Response<List<comment>>
            ) {
                if (response.isSuccessful) {
                    var comment = response.body()
                    Toast.makeText(
                        baseContext,
                        "fetched ${comment!!.size} comment",
                        Toast.LENGTH_LONG
                    ).show()
                    binding.rvComments.adapter = CommentsAdapter(comment)
                    binding.rvComments.layoutManager = LinearLayoutManager(baseContext)
                }
            }

            override fun onFailure(call: Call<List<comment>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()

            }
        })
    }
}








package com.p7k.retrofithomework.Adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.p7k.retrofithomework.R
import kotlinx.android.synthetic.main.item_post.view.*
import java.lang.reflect.Type

class PostAdapter(var postList: List<com.p7k.retrofithomework.model.Type>, context: Context) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun  bindPost(type: com.p7k.retrofithomework.model.Type) {
            itemView.txtTitle.text= type.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.PostViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostAdapter.PostViewHolder, position: Int) {
        holder.bindPost(postList[position])
    }

}

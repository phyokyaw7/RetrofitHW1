package com.p7k.retrofithomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.p7k.retrofithomework.Adaptor.PostAdapter
import com.p7k.retrofithomework.api.TypeApiInterface
import com.p7k.retrofithomework.model.Type
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getPost()
    }

    fun loadpostList(postList:List<Type>){
    recyclerPost.apply {
        layoutManager=LinearLayoutManager(context)
        val postAdapter=PostAdapter(postList,context)
        adapter=postAdapter
    }
    }
    fun getPost(){
        var BASE_URL="https://jsonplaceholder.typicode.com/"
        var retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var retrofitService=retrofit.create(TypeApiInterface::class.java)

//        var apiCall=retrofitService.getPost()
        var apiCall=retrofitService.getPost()

        apiCall.enqueue(object: Callback<List<Type>>{
            override fun onFailure(call: Call<List<Type>>, t: Throwable) {
            Log.d("failure>>>>>>>>",t.toString())
            }

            override fun onResponse(
                call: Call<List<Type>>,
                response: Response<List<Type>>
            ) {
                var postList = response.body()
                Log.d("Response>>>>>", postList.toString())

                if (postList != null) {
                    loadpostList(postList)
                }
            }


        })
    }
}

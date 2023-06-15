package com.example.newsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.newsapp.Adepeter.NewsAdepter
import com.example.newsapp.Model.Newsmodel
import com.example.newsapp.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    var url =
        "https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=de9738db78ec41e0bcebc4d76be7060a&authuser=0"
  var Newslist=ArrayList<Newsmodel>()
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var volley = StringRequest(Request.Method.GET, url, {

        var obj=JSONObject(it)
        for (i in 0 .. obj.length()-1){


        }
            var array=obj.getJSONArray("articles")
            var source=obj.getJSONObject("source")

            for (j in 0..array.length()-1){
                var Obj=array.getJSONObject(j)


                var author=Obj.getString("author")
                var title=Obj.getString("title")
                var description=Obj.getString("description")
                var url=Obj.getString("url")
                var urlToImage=Obj.getInt("urlToImage")
                var publishedAt=Obj.getString("publishedAt")
                var content=Obj.getString("content")
                var id=Obj.getInt("id")
                var name=Obj.getString("name")
                var totalResults=Obj.getInt("totalResults")
                var status=Obj.getString("status")




              var model=Newsmodel(id,name,urlToImage,description,author,title,url, content, totalResults,publishedAt,status)

                for (news in Newslist){
                    binding.rcvnews.layoutManager=GridLayoutManager(this,2)
                    binding.rcvnews.adapter=NewsAdepter(Newslist)
                }


            }


        }, {


        })
        var que=Volley.newRequestQueue(this)
        que.add(volley)
    }
}
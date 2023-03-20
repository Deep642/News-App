package com.example.recyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class myrecycleadapter(val context:Activity,val newsArrayList: ArrayList<News>):
    RecyclerView.Adapter<myrecycleadapter.MyViewHolder>()
{
    lateinit var myListener:onclickListener
    interface onclickListener{
        fun onItemClicking(position: Int)
    }

    fun setItemClicking(listener:onclickListener){
     myListener=listener
    }

//to create new view instance when layout manager fails to find a suitable view for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myrecycleadapter.MyViewHolder {
      val itemView=LayoutInflater.from(parent.context).inflate(R.layout.eachrowitem,parent,false)
      return MyViewHolder(itemView,myListener)
    }
//    populate items with data
    override fun onBindViewHolder(holder: myrecycleadapter.MyViewHolder, position: Int) {
       val currentItem=newsArrayList[position]
        holder.hTitle.text=currentItem.newsHeading
        holder.hImage.setImageResource(currentItem.newsImage)
    }
    //how many list items are present in the array
    override fun getItemCount(): Int {
       return newsArrayList.size
    }
// it holds the view so views are not created everytime, so memory can be saved everytime, so memory can be saved
class MyViewHolder (itemView:View,listener:onclickListener):RecyclerView.ViewHolder(itemView){
       val hTitle=itemView.findViewById<TextView>(R.id.headingTitle)
        val hImage=itemView.findViewById<ShapeableImageView>(R.id.headingImage)

     init {
         itemView.setOnClickListener {
             listener.onItemClicking(adapterPosition)
         }
     }
    }

}
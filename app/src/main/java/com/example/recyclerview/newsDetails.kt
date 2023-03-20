package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class newsDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)

        supportActionBar?.hide()

        val heading=intent.getStringExtra("heading")
        val img=intent.getIntExtra("imageId",R.drawable.img1)
        val content=intent.getStringExtra("news-content")

        val headingTV = findViewById<TextView>(R.id.newsHeadingIn)
        val headingIV = findViewById<ImageView>(R.id.newsImageIn)
        val newsContentTV = findViewById<TextView>(R.id.newsContentIn)

        headingTV.text=heading
        newsContentTV.text = content
        headingIV.setImageResource(img)
    }
}
package com.personalproj.moviecatalog

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.raizlabs.android.dbflow.config.FlowManager
import com.raizlabs.android.dbflow.kotlinextensions.save
import com.raizlabs.android.dbflow.sql.language.SQLite
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity() : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val title: String? = intent.getStringExtra("title")
        val plot: String? = intent.getStringExtra("plot")
        val release: String? = intent.getStringExtra("release_date")
        val id: String? = intent.getStringExtra("id")

        detail_title.setText(title)
        detail_plot.setText(plot)
        detail_release.setText("Release date: " + release)

        back_button.setOnClickListener {
            intent = Intent(this, MainActivity()::class.java)
            startActivity(intent)
        }

        val review = Review()
        review.id = 1
        review.movieName = "UP"
        review.reviewText = "bello"
        try {
            review.save()
        } catch (e: Exception) {
            println(e)
        }

        try {
            val reviewRetrieved: Review? = SQLite.select()
                .from(Review::class.java)
                .querySingle()
            println(reviewRetrieved?.reviewText)
        }catch (e:Exception){
            println(e)
        }
        /*

        */

    }

}
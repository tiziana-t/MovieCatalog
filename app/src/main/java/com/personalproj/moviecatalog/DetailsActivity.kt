package com.personalproj.moviecatalog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.personalproj.moviecatalog.listeners.MovieClickListener
import com.personalproj.moviecatalog.models.Movie
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity() : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val title : String? = intent.getStringExtra("title")
        val plot : String? = intent.getStringExtra("plot")
        val release : String? = intent.getStringExtra("release_date")

        detail_title.setText(title)
        detail_plot.setText(plot)

        back_button.setOnClickListener {
            intent = Intent(this, MainActivity()::class.java)
            startActivity(intent)
        }
    }
}
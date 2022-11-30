package com.personalproj.moviecatalog

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.personalproj.moviecatalog.listeners.MovieClickListener
import com.personalproj.moviecatalog.models.Movie
import com.personalproj.moviecatalog.models.MovieResponse
import com.personalproj.moviecatalog.services.MovieApiInterface
import com.personalproj.moviecatalog.services.MovieApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), MovieClickListener{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        search_bar.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    searchMovie(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                    getMovieDAta { movies : List<Movie> ->
                        rv_movies_list.adapter = MovieAdapter(movies, MainActivity())
                    }

                return false
            }
        })

        rv_movies_list.layoutManager = LinearLayoutManager(this)
        rv_movies_list.setHasFixedSize(true)
        getMovieDAta { movies : List<Movie> ->
            rv_movies_list.adapter = MovieAdapter(movies, this )
        }

    }

    private fun getMovieDAta(callback : (List<Movie>) -> Unit){
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

        })

    }

    private fun searchMovie(keyword : String){

        getMovieDAta {
                movies : List<Movie>->
            val searchedMovies = movies.filter { m : Movie -> m.title?.lowercase()?.contains(keyword.lowercase())
                ?: false }
                rv_movies_list.adapter = MovieAdapter(searchedMovies, this)

    }

    }

    private fun getDetails(movie : Movie){
        intent = Intent(this, DetailsActivity()::class.java)
        intent.putExtra("title", movie.title)
        intent.putExtra("plot", movie.overview)
        intent.putExtra("release_date", movie.release)
        startActivity(intent)

        }

    override fun onMovieClicked(movie: Movie) {
        getDetails(movie)
    }

}



package com.personalproj.moviecatalog.services

import com.personalproj.moviecatalog.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface{

    @GET("/3/movie/popular?api_key=79895f6aa304179d99b6bd86c5eb4b82")
    fun getMovieList() : Call<MovieResponse> //mi restituisce un oggetto di tipo call


}
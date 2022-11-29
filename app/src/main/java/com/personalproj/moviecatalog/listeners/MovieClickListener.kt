package com.personalproj.moviecatalog.listeners

import com.personalproj.moviecatalog.models.Movie

interface MovieClickListener {

    public fun onMovieClicked(movie : Movie)
}
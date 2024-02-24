package com.example.random_movies

data class Movie (val name: String, val year: Int, val rating: Float, val genres: Array<String>, val director: String) {
    // поля будут описаны автоматически, так как data class
}
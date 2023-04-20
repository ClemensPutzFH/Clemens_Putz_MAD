package com.example.lectureexamples.db
import kotlinx.coroutines.flow.Flow

class MovieRepository(private val movieDao: MovieDao) {
    suspend fun add(movie: Movie) = movieDao.add(movie = movie)

    suspend fun update(movie: Movie) = movieDao.update(movie = movie)

    suspend fun delete(movie: Movie) = movieDao.delete(movie = movie)

    fun getAllMovies() : Flow<List<Movie>> = movieDao.getAllMovies()

    fun getFavoriteMovies() : Flow<List<Movie>> = movieDao.getFavoriteMovies()

    fun getMovieById(id: Int) : Flow<Movie> = movieDao.getMovieById(id)
}
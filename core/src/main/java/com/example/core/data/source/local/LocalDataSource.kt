package com.example.core.data.source.local

import com.example.core.data.source.local.entity.GenreEntity
import com.example.core.data.source.local.entity.MoviesEntity
import com.example.core.data.source.local.entity.ReviewEntity
import com.example.core.data.source.local.entity.VideosEntity
import com.example.core.data.source.local.room.MoviesDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class LocalDataSource @Inject constructor (private val moviesDao: MoviesDao) {

    fun getAllGenre(): Flow<List<GenreEntity>> = moviesDao.getAllGenre()
    suspend fun insertGenre(genreList: List<GenreEntity>) = moviesDao.insertGenre(genreList)

    fun getAllReview(): Flow<List<ReviewEntity>> = moviesDao.getAllReview()
    suspend fun insertReview(review: List<ReviewEntity>) = moviesDao.insertReview(review)

    fun getAllVideo(): Flow<List<VideosEntity>> = moviesDao.getAllVideo()
    suspend fun insertVideo(video: List<VideosEntity>) = moviesDao.insertVideo(video)
}
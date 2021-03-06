package my.maroqi.application.moviecatalogue.data.source.local.db

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import my.maroqi.application.moviecatalogue.data.model.MovieItem

@Dao
interface MovieItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(movie: MovieItem)

    @Query("DELETE FROM movie_item WHERE title=:title")
    fun delete(title: String)

    @Query("SELECT * from movie_item")
    fun getAllPaged(): DataSource.Factory<Int, MovieItem>

    @Query("SELECT * from movie_item")
    fun getAll(): List<MovieItem>

    @Query("SELECT * from movie_item")
    fun getLiveData(): LiveData<List<MovieItem>>
}
package com.yaramobile.batmanmovies.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MovieDao{

    @Query("select * from databasemoviedetail")
    fun getMovies() : LiveData<List<DatabaseMovieDetail>>


    @Query("select * from databasemoviedetail WHERE imdbID = :id")
    fun getMovieDetail(id : String) : LiveData<DatabaseMovieDetail>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg movies : DatabaseMovieDetail)


    @Update
    fun updateMovieDetail(movie : DatabaseMovieDetail)
}


@Database(entities = [DatabaseMovieDetail::class] , version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase(){
    abstract val movieDao:MovieDao }

    private lateinit var movieDatabaseInstance : MovieDatabase

    fun getDatabaseInstance(context: Context) : MovieDatabase{
        synchronized(MovieDatabase::class.java){
            if(!::movieDatabaseInstance.isInitialized){
                movieDatabaseInstance=Room.databaseBuilder(context.applicationContext,
                    MovieDatabase::class.java ,
                    "movies").build()

            }
        }
            return movieDatabaseInstance
    }






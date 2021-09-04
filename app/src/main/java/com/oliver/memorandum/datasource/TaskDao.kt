package com.oliver.memorandum.datasource

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.oliver.memorandum.model.Task

@Dao
interface TaskDao {

    @Query("SELECT * FROM Task")
    fun getAll(): LiveData<List<Task>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(task: Task)
}
package com.bor96dev.speakeasy.diaryapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TaskDao {

    @Query("SELECT * FROM events WHERE date = :date")
    suspend fun getEventsForDay(date: String) : List<EventEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(events: List<EventEntity>)

    @Delete
    suspend fun delete(event: EventEntity)
}
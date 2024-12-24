package com.bor96dev.speakeasy.diaryapp.data

import android.content.Context
import androidx.room.Room
import com.bor96dev.speakeasy.diaryapp.domain.Event
import com.google.gson.Gson
import java.time.LocalDate

class EventRepositoryImpl(context: Context) : EventRepository {
    private val database = Room.databaseBuilder(
        context,
        DiaryDatabase::class.java, "diary-database"
    ).build()

    private val eventDao = database.eventDao()
    private val gson = Gson()

    override suspend fun getEventsForDay(date: LocalDate): List<Event> {
        val events = eventDao.getEventsForDay(date.toString())
        return events.toListEvents()
    }

    override suspend fun saveEventsForDay(date: LocalDate, events: List<Event>) {
        eventDao.insertAll(events.toListEntity(date))
    }

}
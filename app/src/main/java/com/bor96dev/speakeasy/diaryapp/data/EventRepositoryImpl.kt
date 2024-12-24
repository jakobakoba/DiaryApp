package com.bor96dev.speakeasy.diaryapp.data

import android.content.Context
import androidx.room.Room
import com.bor96dev.speakeasy.diaryapp.domain.Event
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(@ApplicationContext context: Context) : EventRepository {
    private val database = Room.databaseBuilder(
        context,
        DiaryDatabase::class.java, "diary-database"
    ).build()

    private val eventDao = database.eventDao()
    private val gson = Gson()
    private val formatter = DateTimeFormatter.ISO_LOCAL_DATE

    override suspend fun getEventsForDay(date: LocalDate): List<Event> =
        withContext(Dispatchers.IO) {
            val events = eventDao.getEventsForDay(date.toString())
            events.toListEvents()
        }

    override suspend fun saveEventsForDay(date: LocalDate, events: List<Event>) =
        withContext(Dispatchers.IO) {
        eventDao.insertAll(events.toListEntity(date))
    }

    override suspend fun loadSampleData(context: Context) =
        withContext(Dispatchers.IO) {
            val sampleEventsJson =
                context.assets.open("sample_events.json").bufferedReader().use{
                    it.readText()
                }
            val listType = object : TypeToken<List<Event>>() {}.type
            val sampleEvents = gson.fromJson<List<Event>>(sampleEventsJson, listType)
            val today = LocalDate.now()
            eventDao.insertAll(sampleEvents.toListEntity(today))
        }

}
package com.bor96dev.speakeasy.diaryapp.data

import android.content.Context
import com.bor96dev.speakeasy.diaryapp.domain.Event
import java.time.LocalDate

interface EventRepository {
    suspend fun getEventsForDay(date: LocalDate): List<Event>
    suspend fun saveEventsForDay(date:LocalDate, events: List<Event>)
    suspend fun loadSampleData(context: Context)
}
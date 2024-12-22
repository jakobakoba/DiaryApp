package com.bor96dev.speakeasy.diaryapp.data

import com.bor96dev.speakeasy.diaryapp.domain.Event
import java.util.Date

interface EventRepository {
    suspend fun getEventsForDay(date: Date): List<Event>
}
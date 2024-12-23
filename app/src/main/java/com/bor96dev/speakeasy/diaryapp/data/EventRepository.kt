package com.bor96dev.speakeasy.diaryapp.data

import com.bor96dev.speakeasy.diaryapp.domain.Task
import java.time.LocalDate

interface EventRepository {
    suspend fun getEventsForDay(date: LocalDate): List<Task>
}
package com.bor96dev.speakeasy.diaryapp.domain

import com.bor96dev.speakeasy.diaryapp.data.EventRepository
import java.time.ZoneId
import java.util.Date

class GetTaskForDayUseCase(private val repository: EventRepository) {
    suspend operator fun invoke(date: Date): List<Event> {
        val localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        return repository.getEventsForDay(localDate)
    }
}
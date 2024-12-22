package com.bor96dev.speakeasy.diaryapp.domain

import com.bor96dev.speakeasy.diaryapp.data.EventRepository
import java.util.Date

class GetEventsForDayUseCase(private val repository: EventRepository) {
    suspend operator fun invoke(date: Date): List<Event> = repository.getEventsForDay(date)
}
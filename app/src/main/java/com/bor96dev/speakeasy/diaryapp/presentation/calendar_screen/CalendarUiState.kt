package com.bor96dev.speakeasy.diaryapp.presentation.calendar_screen

import com.bor96dev.speakeasy.diaryapp.domain.Event
import java.util.Date

data class CalendarUiState(
    val selectedDate: Date = Date(),
    val eventsForDay: List<Event> = emptyList(),
)
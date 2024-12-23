package com.bor96dev.speakeasy.diaryapp.presentation.calendar_screen

import com.bor96dev.speakeasy.diaryapp.domain.Task
import java.util.Date

data class CalendarUiState(
    val selectedDate: Date = Date(),
    val tasksForDay: List<Task> = emptyList(),
)
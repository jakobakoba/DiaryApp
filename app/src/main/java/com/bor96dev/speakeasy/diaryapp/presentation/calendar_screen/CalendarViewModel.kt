package com.bor96dev.speakeasy.diaryapp.presentation.calendar_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bor96dev.speakeasy.diaryapp.domain.Task
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject constructor(
//    private val getTaskForDayUseCase: GetTaskForDayUseCase,
): ViewModel() {
    private val _uiState = MutableStateFlow(CalendarUiState())
    val uiState: StateFlow<CalendarUiState> = _uiState

    init{
        viewModelScope.launch{
            val today = LocalDate.now()
            val sampleTasks = listOf(
                Task(1, today.atStartOfDay().plusHours(9).toEpochMilli(), today.atStartOfDay().plusHours(10).toEpochMilli(), "Morning Meeting"),
                Task(2, today.atStartOfDay().plusHours(12).toEpochMilli(), today.atStartOfDay().plusHours(13).toEpochMilli(), "Lunch"),
                Task(3, today.atStartOfDay().plusHours(15).toEpochMilli(), today.atStartOfDay().plusHours(16).toEpochMilli(), "Code Review"),
                Task(4, today.atStartOfDay().plusHours(10).toEpochMilli(), today.atStartOfDay().plusHours(11).toEpochMilli(), "Design Meeting")
            )
            _uiState.value = CalendarUiState(selectedDate = Date(), tasksForDay = sampleTasks)
        }
    }

    fun selectDate(date: Date) {
        viewModelScope.launch {
//            val tasks = getTaskForDayUseCase(date)
//            _uiState.value = CalendarUiState(selectedDate = date, tasksForDay = tasks)
        }
    }
}

fun LocalDate.atStartOfDay(): LocalDateTime {
    return atStartOfDay(ZoneId.systemDefault()).toLocalDateTime()
}
fun LocalDateTime.toEpochMilli(): Long {
    return this.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
}


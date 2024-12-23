package com.bor96dev.speakeasy.diaryapp.presentation.calendar_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bor96dev.speakeasy.diaryapp.domain.GetTaskForDayUseCase
import com.bor96dev.speakeasy.diaryapp.domain.SelectDateUseCase
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.Date

//@HiltViewModel
class CalendarViewModel(
    private val getTaskForDayUseCase: GetTaskForDayUseCase,
    private val selectDateUseCase: SelectDateUseCase,
    private val gson: Gson
): ViewModel() {
    private val _uiState = MutableStateFlow(CalendarUiState())
    val uiState: StateFlow<CalendarUiState> = _uiState

    fun selectDate(date: Date) {
        viewModelScope.launch {
            val tasks = getTaskForDayUseCase(date)
            _uiState.value = CalendarUiState(selectedDate = date, tasksForDay = tasks)
        }
    }
}


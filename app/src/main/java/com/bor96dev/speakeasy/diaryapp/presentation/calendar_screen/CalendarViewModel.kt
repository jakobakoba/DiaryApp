package com.bor96dev.speakeasy.diaryapp.presentation.calendar_screen

import androidx.lifecycle.ViewModel
import com.bor96dev.speakeasy.diaryapp.domain.GetEventsForDayUseCase
import com.bor96dev.speakeasy.diaryapp.domain.SelectDateUseCase
import kotlinx.coroutines.flow.MutableStateFlow

class CalendarViewModel(
    private val getEventsForDayUseCase: GetEventsForDayUseCase,
    private val selectDateUseCase: SelectDateUseCase
): ViewModel() {
    private val _uiState = MutableStateFlow(CalendarUiState())
}


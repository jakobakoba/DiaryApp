package com.bor96dev.speakeasy.diaryapp.presentation.calendar_screen

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bor96dev.speakeasy.diaryapp.data.EventRepository
import com.bor96dev.speakeasy.diaryapp.domain.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val eventRepository: EventRepository,
    private val context: Context
): ViewModel() {
    private val _uiState = MutableStateFlow(CalendarUiState())
    val uiState: StateFlow<CalendarUiState> = _uiState

    init{
        viewModelScope.launch{

        }
    }

    private suspend fun loadEventsForToday(){
        val today = LocalDate.now()
        val events = eventRepository.getEventsForDay(today)
        _uiState.value = CalendarUiState(selectedDate = Date(),
            eventsForDay = events)
    }

    fun selectDate(date: Date){
        viewModelScope.launch{
            val localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
            val events = eventRepository.getEventsForDay(localDate)
            _uiState.value = CalendarUiState(selectedDate = date, eventsForDay = events)
        }
    }
    fun saveEvent(event: Event){
        viewModelScope.launch{
            val date = Date(event.dateStart)
            val localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
            val currentEvents = eventRepository.getEventsForDay(localDate).toMutableList()
            currentEvents.add(event)
            eventRepository.saveEventsForDay(localDate, currentEvents)
            loadEventsForToday()
        }
    }


}



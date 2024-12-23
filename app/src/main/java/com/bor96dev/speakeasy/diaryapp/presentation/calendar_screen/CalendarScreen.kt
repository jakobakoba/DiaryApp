package com.bor96dev.speakeasy.diaryapp.presentation.calendar_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.boguszpawlowski.composecalendar.SelectableCalendar
import io.github.boguszpawlowski.composecalendar.rememberSelectableCalendarState

@Composable
fun CalendarScreen(
    innerPaddingValues: PaddingValues
) {
    val calendarState = rememberSelectableCalendarState()
    Column(modifier = Modifier.padding(innerPaddingValues)) {
        SelectableCalendar(calendarState = calendarState)

        Spacer(modifier = Modifier.height(4.dp))

//        HourlyTimeline(tasks = uiState.tasksForDay)
    }
}


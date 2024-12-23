package com.bor96dev.speakeasy.diaryapp.presentation.calendar_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bor96dev.speakeasy.diaryapp.presentation.calendar_screen.components.TasksTimeline
import io.github.boguszpawlowski.composecalendar.SelectableCalendar
import io.github.boguszpawlowski.composecalendar.rememberSelectableCalendarState
import java.time.LocalDate

@Composable
fun CalendarScreen(
    innerPaddingValues: PaddingValues,
    uiState: CalendarUiState
) {
    val calendarState = rememberSelectableCalendarState()
    val selectedDate = calendarState.selectionState.selection.firstOrNull() ?: LocalDate.now()
    Column(modifier = Modifier.padding(innerPaddingValues)) {
        SelectableCalendar(calendarState = calendarState)

        Spacer(modifier = Modifier.height(4.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ){

                TasksTimeline(
                    tasks = uiState.tasksForDay,
                    currentDate = selectedDate
                )
            }
        }

    }
}


package com.bor96dev.speakeasy.diaryapp.presentation.calendar_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bor96dev.speakeasy.diaryapp.domain.Task
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

@Composable
fun TasksTimeline(
    tasks: List<Task>,
    currentDate: LocalDate,
    modifier: Modifier = Modifier,
) {

    val tasksForDay = tasks.filter { task ->
        val taskDate = Instant.ofEpochMilli(task.dateStart).atZone(ZoneId.systemDefault()).toLocalDate()
        taskDate == currentDate
    }

    LazyColumn(modifier = modifier) {
        items(24) { hour ->

            val hourTasks = tasks.filter { task ->
                val startTime = Instant.ofEpochMilli(task.dateStart).atZone(ZoneId.systemDefault()).toLocalDateTime()
                startTime.hour == hour
            }

            HourlyTimeline(
                hour = hour,
                tasks = hourTasks,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            )
            HorizontalDivider(thickness = 1.dp, color = Color.LightGray)
        }
    }
}

@Composable
fun HourlyTimeline(
    hour: Int,
    tasks: List<Task>,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text("Hour: $hour:00")
        tasks.forEach { task ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Text(task.title)
            }
        }
    }
}
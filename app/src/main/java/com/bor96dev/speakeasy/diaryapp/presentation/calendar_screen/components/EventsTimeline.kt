package com.bor96dev.speakeasy.diaryapp.presentation.calendar_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bor96dev.speakeasy.diaryapp.domain.Event
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

@Composable
fun EventsTimeline(
    events: List<Event>,
    currentDate: LocalDate,
    modifier: Modifier = Modifier,
) {

    LazyColumn(modifier = modifier) {
        items(24) { hour ->

            val hourEvents = events.filter { event ->
                val startTime = Instant.ofEpochMilli(event.dateStart).atZone(ZoneId.systemDefault()).toLocalDateTime()
                startTime.hour == hour
            }

            HourlyTimeline(
                hour = hour,
                events = hourEvents,
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
    events: List<Event>,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("${hour.toString().padStart(2, '0')}:00", modifier = Modifier.weight(1f))

        Column(modifier = Modifier.weight(3f)) {
                    events.forEach { event ->
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                        ) {
                            Text(event.title, modifier = Modifier.padding(8.dp))
                        }
                    }

                }
            }
            }



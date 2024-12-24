package com.bor96dev.speakeasy.diaryapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bor96dev.speakeasy.diaryapp.domain.Event
import com.google.gson.Gson
import java.time.LocalDate

@Entity(tableName = "events")
data class EventEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val date: String,
    val eventJson: String
)

fun Event.toEventEntity(date: LocalDate): EventEntity {
    return EventEntity(date = date.toString(), eventJson = Gson().toJson(this))
}

fun EventEntity.toEvent(): Event = Gson().fromJson(eventJson, Event::class.java)

fun List<EventEntity>.toListEvents(): List<Event> = map {it.toEvent()}

fun List<Event>.toListEntity(date: LocalDate): List<EventEntity> = map {it.toEventEntity(date)}


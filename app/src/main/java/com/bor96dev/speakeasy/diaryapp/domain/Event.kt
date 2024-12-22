package com.bor96dev.speakeasy.diaryapp.domain

data class Event(
    val id: Int,
    val title: String,
    val startTime: Long,
    val endTime: Long,
    val description: String? = null,
)

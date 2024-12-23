package com.bor96dev.speakeasy.diaryapp.domain

data class Event(
    val id: Int,
    val dateStart: Long,
    val dateFinish: Long,
    val title: String,
    val description: String? = null,
)

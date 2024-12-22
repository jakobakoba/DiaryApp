package com.bor96dev.speakeasy.diaryapp.domain

data class Task(
    val id: Int,
    val dateStart: Long,
    val dateFinish: Long,
    val name: String,
    val description: String? = null,
)

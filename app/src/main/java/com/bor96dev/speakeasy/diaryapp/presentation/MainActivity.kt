package com.bor96dev.speakeasy.diaryapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.bor96dev.speakeasy.diaryapp.presentation.calendar_screen.CalendarScreen
import com.bor96dev.speakeasy.diaryapp.presentation.calendar_screen.CalendarUiState
import com.bor96dev.speakeasy.diaryapp.presentation.calendar_screen.CalendarViewModel
import com.bor96dev.speakeasy.diaryapp.presentation.ui.theme.DiaryAppTheme
import java.util.Date

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiaryAppTheme {
                val viewModel: CalendarViewModel = hiltViewModel()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val uiState = CalendarUiState(
                        selectedDate = Date(),
                        emptyList()
                    )
                    CalendarScreen(innerPadding, uiState)
                }
            }
        }
    }
}


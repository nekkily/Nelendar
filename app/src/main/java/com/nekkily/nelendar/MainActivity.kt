package com.nekkily.nelendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nekkily.nelendar.ui.CalendarState
import com.nekkily.nelendar.ui.FirstDayOfWeek
import com.nekkily.nelendar.ui.theme.*
import com.nekkily.nelendar.ui.view.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(
                        color = colorResource(id = R.color.main_background)
                    )
            ) {
                val defaultFontFamily = FontFamily.Serif
                Calendar(
                    firstDayOfWeek = FirstDayOfWeek.MONDAY,
                    monthTextColor = White,
                    monthFontFamily = defaultFontFamily,
                    monthFontSize = 32.sp,
                    dayOfMonthBackgroundColor = Gray,
                    dayOfMonthCurrentTextColor = White,
                    dayOfMonthOtherTextColor = Lavender,
                    dayOfMonthFontFamily = defaultFontFamily,
                    dayOfMonthFontSize = 20.sp,
                    dayOfWeekColor = Gray,
                    dayOfWeekFontFamily = defaultFontFamily,
                    dayOfWeekFontSize = 17.sp,
                    dayOfMonthBackgroundShape = RoundedCornerShape(7.dp),
                    currentDayBackgroundColor = LightGray,
                    selectedDayBackgroundColor = LavenderGray,
                    calendarHorizontalPadding = 26.dp,
                    calendarChildrenVerticalPadding = 14.dp,
                    horizontalDaysPadding = 8.dp,
                    verticalDaysPadding = 8.dp,
                    calendarState = CalendarState.MONTH,
                    onMonthChange = {

                    },
                    onDaySelected = {

                    }
                )
            }
        }
    }
}
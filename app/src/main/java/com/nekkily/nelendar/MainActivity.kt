package com.nekkily.nelendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nekkily.nelendar.model.DayModel
import com.nekkily.nelendar.model.params.CalendarParams
import com.nekkily.nelendar.model.params.DayParams
import com.nekkily.nelendar.ui.CalendarState
import com.nekkily.nelendar.ui.FirstDayOfWeek
import com.nekkily.nelendar.ui.theme.Gray
import com.nekkily.nelendar.ui.theme.Lavender
import com.nekkily.nelendar.ui.theme.LavenderGray
import com.nekkily.nelendar.ui.theme.LightGray
import com.nekkily.nelendar.ui.theme.White
import com.nekkily.nelendar.ui.view.Calendar
import java.util.Date

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
                val selectedDay = remember { mutableStateOf(DayModel(Date(), true)) }

                val defaultFontFamily = FontFamily.Serif
                Calendar(
                    params = CalendarParams(
                        firstDayOfWeek = FirstDayOfWeek.MONDAY,
                        monthTitleTextColor = White,
                        monthTitleFontFamily = defaultFontFamily,
                        monthTitleFontSize = 32.sp,
                        calendarHorizontalPadding = 26.dp,
                        calendarMonthTitleBottomPadding = 14.dp,
                        horizontalDaysPadding = 8.dp,
                        verticalDaysPadding = 8.dp,
                        calendarState = CalendarState.WEEK,
                        selectedDay = selectedDay,
                        onMonthChange = {},

                        dayParams = DayParams(
                            dayBackgroundColor = Gray,
                            dayCurrentMonthTextColor = White,
                            dayOtherMonthTextColor = Lavender,
                            dayFontFamily = defaultFontFamily,
                            dayFontSize = 20.sp,
                            dayOfWeekColor = Gray,
                            dayOfWeekFontFamily = defaultFontFamily,
                            dayOfWeekFontSize = 15.sp,
                            dayBackgroundShape = RoundedCornerShape(7.dp),
                            currentDayBackgroundColor = LightGray,
                            selectedDayBackgroundColor = LavenderGray,
                            onDaySelected = {}
                        ),
                    )
                )
            }
        }
    }
}
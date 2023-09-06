package com.nekkily.nelendar.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.nekkily.nelendar.model.DayModel
import com.nekkily.nelendar.model.params.DayParams
import com.nekkily.nelendar.util.CalendarUtil
import com.nekkily.nelendar.util.GetDateInMidnight
import java.util.*

/**
 * Day cell composable view when calendar displayed as months.
 *
 * @param day [DayModel] model of displayed day.
 * @param selectedDay [MutableState][DayModel] remember state of selected day.
 * @param params [DayParams] params model for detailed day settings.
 * @param onItemClick callback informs about the day selection.
 * Returns the [DayModel] of the selected day.
 */
@Composable
fun MonthDay(
    day: DayModel,
    selectedDay: MutableState<DayModel>,
    params: DayParams,
    onItemClick: (DayModel) -> Unit
) {
    params.apply {
        DayCard(
            day = day,
            height = 64.dp,
            backgroundShape = dayBackgroundShape,
            backgroundColor = dayBackgroundColor,
            currentDayBackgroundColor = currentDayBackgroundColor,
            selectedDayBackgroundColor = selectedDayBackgroundColor,
            selectedDay = selectedDay,
            onItemClick = onItemClick
        ) {
            DayText(
                day,
                dayFontFamily,
                dayFontSize,
                if (day.isCurrentMonth) {
                    dayCurrentMonthTextColor
                } else {
                    dayOtherMonthTextColor
                }
            )
        }
    }
}

/**
 * Day cell composable view when calendar displayed as weeks.
 *
 * @param day [DayModel] model of displayed day.
 * @param dayName [String] day of week name corresponding to the day.
 * @param selectedDay [MutableState][DayModel] remember state of selected day.
 * @param params [DayParams] params model for detailed day settings.
 * @param onItemClick callback informs about the day selection.
 * Returns the [DayModel] of the selected day.
 */
@Composable
fun WeekDay(
    day: DayModel,
    dayName: String,
    selectedDay: MutableState<DayModel>,
    params: DayParams,
    onItemClick: (DayModel) -> Unit
) {
    params.apply {
        DayCard(
            day = day,
            height = 86.dp,
            backgroundShape = dayBackgroundShape,
            backgroundColor = dayBackgroundColor,
            currentDayBackgroundColor = currentDayBackgroundColor,
            selectedDayBackgroundColor = selectedDayBackgroundColor,
            selectedDay = selectedDay,
            onItemClick = onItemClick
        ) {
            Column {
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                ) {
                    DayName(
                        day = dayName,
                        color = dayOfWeekColor,
                        fontFamily = dayOfWeekFontFamily,
                        fontSize = dayOfWeekFontSize
                    )
                }
                DayText(
                    day,
                    dayFontFamily,
                    dayFontSize,
                    if (day.isCurrentMonth) {
                        dayCurrentMonthTextColor
                    } else {
                        dayOtherMonthTextColor
                    }
                )
            }
        }
    }
}

/**
 * Day cell composable view.
 *
 * @param day [DayModel] model of displayed day.
 * @param height [Dp] height of view.
 * @param backgroundShape [RoundedCornerShape] background shape of cell.
 * @param backgroundColor [Color] to apply to the cell.
 * @param currentDayBackgroundColor [Color] to apply to the today cell.
 * @param selectedDayBackgroundColor [Color] to apply to the selected day cell.
 * @param selectedDay [MutableState][DayModel] remember state of selected day.
 * Contains the [DayModel] of the selected day.
 * @param onItemClick callback informs about the day selection.
 * Returns the [DayModel] of the selected day.
 * @param content [Composable][ColumnScope].
 */
@Composable
fun DayCard(
    day: DayModel,
    height: Dp,
    backgroundShape: RoundedCornerShape,
    backgroundColor: Color,
    currentDayBackgroundColor: Color,
    selectedDayBackgroundColor: Color,
    selectedDay: MutableState<DayModel>,
    onItemClick: (DayModel) -> Unit,
    content: @Composable ColumnScope.() -> Unit
) {
    val isDayCurrent = GetDateInMidnight().invoke(Date()) == GetDateInMidnight().invoke(day.date)
    val isSelectedDay = GetDateInMidnight().invoke(selectedDay.value.date) == GetDateInMidnight().invoke(day.date)

    Card(
        modifier = Modifier
            .size(40.dp, height)
            .clickable {
                onItemClick(day)
            },
        shape = backgroundShape,
        colors = CardDefaults.cardColors(
            containerColor = if (isSelectedDay) {
                selectedDayBackgroundColor
            } else if (isDayCurrent) {
                currentDayBackgroundColor
            } else {
                backgroundColor
            }
        )
    ) {
        content()
    }
}

/**
 * Number of the day of the month composable view.
 *
 * @param day [DayModel] model of displayed day.
 * @param fontFamily [FontFamily] to apply to the text.
 * @param fontSize [TextUnit] font size of text.
 * @param textColor [Color] to apply to the text.
 */
@Composable
fun ColumnScope.DayText(
    day: DayModel,
    fontFamily: FontFamily,
    fontSize: TextUnit,
    textColor: Color
) {
    val dayOfMonth = CalendarUtil.getDayOfMonth(day.date)

    Box(
        modifier = Modifier
            .size(30.dp, 30.dp)
            .align(Alignment.CenterHorizontally)
    ) {
        Text(
            modifier = Modifier
                .fillMaxSize(),
            text = dayOfMonth,
            fontFamily = fontFamily,
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = fontSize,
                color = textColor
            )
        )
    }
}
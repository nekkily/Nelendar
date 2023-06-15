package com.nekkily.nelendar.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.nekkily.nelendar.ui.DAYS_IN_WEEK
import com.nekkily.nelendar.util.DayModel
import com.nekkily.nelendar.util.LocaleDefault

@Composable
fun CalendarMonthCard(
    days: List<Any>,
    dayView: @Composable (DayModel) -> Unit,
    dayOfWeekColor: Color,
    dayOfWeekFontFamily: FontFamily,
    dayOfWeekFontSize: TextUnit,
    horizontalDaysPadding: Dp,
    verticalDaysPadding: Dp
) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxWidth()
            .padding(26.dp, 0.dp),
        columns = GridCells.Fixed(DAYS_IN_WEEK),
        horizontalArrangement = Arrangement.spacedBy(horizontalDaysPadding),
        verticalArrangement = Arrangement.spacedBy(verticalDaysPadding)
    ) {
        items(days.size) {
            if (days[it] is String) {
                Text(
                    textAlign = TextAlign.Center,
                    fontSize = dayOfWeekFontSize,
                    fontFamily = dayOfWeekFontFamily,
                    text = (days[it] as String).lowercase(LocaleDefault.get()),
                    color = dayOfWeekColor,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            } else if (days[it] is DayModel) {
                Box {
                    dayView(days[it] as DayModel)
                }
            }
        }
    }
}
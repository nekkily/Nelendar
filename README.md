![Group 4 (31)](https://github.com/nekkily/Nelendar/assets/29834920/22b0e8c0-af81-45b2-977c-e404b145c367)

Simple calendar library for android

# Usage

Сalendar can be displayed in two versions - monthly and weekly. You can also set up the first day of the week of your calendar - Monday or Sunday. Customize its appearance as you like it best!

```

val selectedDay = remember { mutableStateOf(DayModel(Date(), true)) }

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
  selectedDay = selectedDay,
  onMonthChange = {

  },
  onDaySelected = {

  }
)

```

# Download

```

dependencies {
  implementation 'com.jakewharton.timber:timber:5.0.1'
}

```

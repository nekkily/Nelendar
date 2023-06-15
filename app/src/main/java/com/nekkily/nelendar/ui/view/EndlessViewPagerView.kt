package com.nekkily.nelendar.ui.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun EndlessViewPagerPreview() {
    EndlessViewPager(
        { initialPage, page ->
            val color = if (page % 2 == 0) {
                Color.Red
            } else {
                Color.Blue
            }
            Box(
                modifier = Modifier
                    .background(color)
                    .size(50.dp)
            )
        },
        {

        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EndlessViewPager(
    contentView: @Composable (Int, Int) -> Unit,
    onPageChange: (Int) -> Unit
) {
    val initialPage = Int.MAX_VALUE / 2
    val pagerState = rememberPagerState(initialPage)

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            onPageChange(page)
        }
    }

    HorizontalPager(
        pageCount = Int.MAX_VALUE,
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
    ) { page ->
        contentView(initialPage, page)
    }
}
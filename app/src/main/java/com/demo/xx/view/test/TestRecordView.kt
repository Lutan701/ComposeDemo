package com.demo.xx.view.test

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.demo.xx.viewmodel.TestViewModel

@OptIn(ExperimentalFoundationApi::class) // 实验性API
@Composable
fun TestRecordView(testViewModel: TestViewModel) {

    val lazyItems = testViewModel.userPager.collectAsLazyPagingItems()

    Column {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp, end = 10.dp)
        ) {

            stickyHeader {  // 固定表头
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(Color.White),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        Text(text = "No.")
                    }
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        Text(text = "UID")
                    }
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        Text(text = "Name")
                    }
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        Text(text = "Age")
                    }
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        Text(text = "Sex")
                    }
                }

                HorizontalDivider()
            }

            item {

            }

            items(lazyItems.itemCount) { index ->
                lazyItems[index]?.let {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(text = (index + 1).toString(), modifier = Modifier.weight(1f))
                        Text(text = it.uid.toString(), modifier = Modifier.weight(1f))
                        Text(text = it.name.toString(), modifier = Modifier.weight(1f))
                        Text(text = it.age.toString(), modifier = Modifier.weight(1f))
                        Text(text = it.sex.toString(), modifier = Modifier.weight(1f))
                    }
                }

            }
        }
    }

}
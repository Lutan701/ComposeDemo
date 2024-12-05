package com.demo.xx.view.test

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.xx.model.UserModel
import com.demo.xx.view.test.apply.ItemSelectView
import com.demo.xx.view.test.apply.RackSelectView
import com.demo.xx.view.test.apply.TubeSelectView
import com.demo.xx.viewmodel.TestViewModel


@Composable
fun TestApplyView(viewModel: TestViewModel) {

    Column(modifier = Modifier.fillMaxSize()) {
        RackSelectView(viewModel = viewModel)
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp)
        ) {
            TubeSelectView(modifier = Modifier.weight(2f))
            Spacer(modifier = Modifier.width(10.dp))
            ItemSelectView(modifier = Modifier.weight(1f))
        }
    }
}

@Preview
@Composable
fun TestApplyViewPreview() {
    TestApplyView(viewModel = TestViewModel(UserModel()))
}
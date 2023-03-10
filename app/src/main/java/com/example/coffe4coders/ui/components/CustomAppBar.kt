package com.example.coffe4coders.ui.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffe4coders.ui.theme.Coffe4codersTheme

typealias NavigationAction = () -> Unit

@Composable
fun CustomAppBar(title: String? = null,
                 navigationIcon: ImageVector? = null,
                 navigationAction: NavigationAction? = null) {
    val titleText = title ?: ""
    if(navigationIcon != null && navigationAction != null) {
        TopAppBar(
            title = {Text(titleText)},
            navigationIcon = {
                IconButton(onClick = {
                    navigationAction()
                }) {
                    Icon(navigationIcon, "")
                }
            },
            backgroundColor = MaterialTheme.colors.primary
        )
    } else {
        TopAppBar(
            title = {Text(titleText)},
            backgroundColor = MaterialTheme.colors.primary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CustomAppBarPreview() {
    Coffe4codersTheme {
        CustomAppBar("Coffee4Coders")
    }
}
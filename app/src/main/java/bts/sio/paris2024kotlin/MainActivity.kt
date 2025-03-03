package bts.sio.paris2024kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import bts.sio.paris2024kotlin.ui.theme.Paris2024kotlinTheme
import bts.sio.paris2024kotlin.views.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    Paris2024kotlinTheme {
        MainScreen()
    }
}
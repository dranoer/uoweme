package com.dranoer.uoweme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dranoer.uoweme.ui.theme.UoweMETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UoweMETheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ExpenseList()
                }
            }
        }
    }
}

@Composable
fun ExpenseList() {

}

@Preview
@Composable
fun ExpenseListPreview() {
    UoweMETheme {
        ExpenseList()
    }
}
package com.dranoer.uoweme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dranoer.uoweme.model.Expense
import com.dranoer.uoweme.model.mockExpenses
import com.dranoer.uoweme.ui.theme.UoweMETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UoweMETheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    ExpenseList(mockExpenses)
                }
            }
        }
    }
}

@Composable
fun ExpenseList(expenses: List<Expense>) {
    Column() {
        for (item in expenses) {
            ExpenseCart(expense = item)
        }
    }
}

@Composable
fun ExpenseCart(expense: Expense) {
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color(0xFF866EE1),
    ) {
        Text(text = expense.title, modifier = Modifier.padding(8.dp))
    }
}

@Preview
@Composable
fun ExpenseListPreview() {
    UoweMETheme {
        ExpenseList(mockExpenses)
    }
}

@Preview
@Composable
fun ExpenseCartPreview() {
    ExpenseCart(expense = mockExpenses[0])
}
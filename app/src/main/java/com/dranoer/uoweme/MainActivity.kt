package com.dranoer.uoweme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    Column(modifier = Modifier.padding(start = 8.dp, top = 4.dp, end = 8.dp, bottom = 4.dp)) {
        for (item in expenses) {
            ExpenseCart(expense = item)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun ExpenseCart(expense: Expense) {
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color(0xFF866EE1),
    ) {
        Column {
            Text(
                text = expense.title, modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.h4
            )
            Text(
                text = "total cost: $" + expense.totalCost.toString(),
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = "my cost: $" + expense.userCost.toString(),
                modifier = Modifier.padding(8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            for (people in expense.peopleList) {
                Chip(text = people, modifier = Modifier.padding(2.dp))
            }
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Composable
fun Chip(modifier: Modifier = Modifier, text: String) {
    Card(
        modifier = modifier,
        border = BorderStroke(color = Color.Black, width = Dp.Hairline),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(start = 4.dp, top = 2.dp, end = 4.dp, bottom = 2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.phoebe),
                contentDescription = "profile picture",
                modifier = Modifier
                    .size(20.dp)
                    .clip(CircleShape)
            )
            Spacer(Modifier.width(4.dp))
            Text(text = text, fontSize = 8.sp)
        }
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
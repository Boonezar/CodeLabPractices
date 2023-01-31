package com.example.codelabpractices

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.codelabpractices.ui.theme.CodeLabPracticesTheme

class ComposeDynamicList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodeLabPracticesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DynamicList()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DynamicList() {
    // based off of https://medium.com/geekculture/add-remove-in-lazycolumn-list-aka-recyclerview-jetpack-compose-7c4a2464fc9f
    val myDynamicList = remember {
        mutableStateListOf<String>()
    }
    val inputValue = remember { mutableStateOf(TextFieldValue()) }

    Column {
        Row(
            Modifier
                .fillMaxWidth()
                .height(60.dp)
        ) {
            TextField(
                value = inputValue.value,
                onValueChange = { inputValue.value = it},
                modifier = Modifier.weight(0.8f),
                placeholder = { Text(text = "Enter text") },
                textStyle = TextStyle(color = Color.White, fontSize =  TextUnit.Unspecified, fontFamily = FontFamily.SansSerif),
                maxLines = 1,
                singleLine = true
            )
            Button(
                onClick = { myDynamicList.add(inputValue.value.text); inputValue.value = TextFieldValue() },
                modifier = Modifier
                    .weight(0.2f)
                    .fillMaxHeight()
            ) {
                Text(text = "Add")
            }
        }

        Spacer(modifier = Modifier.height(1.dp))

        Surface(modifier = Modifier.padding(all = 5.dp)) {
            LazyColumn {
                itemsIndexed(myDynamicList) { index, item ->
                    val annotatedText = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color.Blue, fontWeight = FontWeight.Bold)) {
                            append("Delete")
                        }
                    }
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(50.dp)) {
                        Text(text = item, Modifier.weight(0.85f))
                        ClickableText(
                            text = annotatedText,
                            onClick = { myDynamicList.remove(item) },
                            modifier = Modifier.weight(0.15f)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CodeLabPracticesTheme {
        DynamicList()
    }
}
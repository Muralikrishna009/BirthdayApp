package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.happybirthday.ui.theme.HappyBirthDayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthDayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithText(message: String, from: String){
    Column {
        Text(text = message, fontSize = 36.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.Start)
                .padding(start = 16.dp, top = 16.dp)
        )
        Text(text = from, fontSize = 24.sp,
            modifier = Modifier
                .padding(end=16.dp, bottom = 16.dp)
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.End)
        )

    }
}

@Composable
fun BottomText(bottom: String){
    Text(text = bottom,
        modifier = Modifier
            .padding(bottom = 16.dp, end = 16.dp)
            .fillMaxWidth()
    )
}

@Composable
fun BirthdayImage(message: String, from: String){
    val image = painterResource(R.drawable.androidparty)
    Box {
        Image(
            painter = image,
            contentDescription =null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithText(message , from)
        BottomText(bottom = "-Created By Murali Krishna")
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayGreetingWithTextPreview() {
    HappyBirthDayTheme {
        BirthdayImage(message = stringResource(R.string.happy_birthday_text), from = stringResource(
                    R.string.from_text)
                )
    }
}
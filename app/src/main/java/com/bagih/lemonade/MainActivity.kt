package com.bagih.lemonade

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bagih.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LemonadeWithImageAndText(modifier: Modifier = Modifier){
    var numberOfClicks: Int by remember {
        mutableStateOf(1)
    }

    if (numberOfClicks > 14){
        numberOfClicks = 1
    }

    val imageResource = when(numberOfClicks){
        in (1..2) -> R.drawable.lemon_tree
        in (3..10) -> R.drawable.lemon_squeeze
        in (11..12) -> R.drawable.lemon_drink
        in (13..14) -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }

    val textResourceDesc = when(numberOfClicks){
        in (1..2) -> R.string.lemon_tree_desc
        in (3..10) -> R.string.lemon_squeeze_desc
        in (11..12) -> R.string.lemon_drink_desc
        in (13..14) -> R.string.empty_glass_desc
        else -> R.string.lemon_tree_desc
    }

    val textContentDescription = when(numberOfClicks){
        in (1..2) -> R.string.lemon_tree
        in (3..10) -> R.string.lemon
        in (11..12) -> R.string.glass_of_lemonade
        in (13..14) -> R.string.empty_glass
        else -> R.string.lemon_tree
    }

    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = stringResource(id = textResourceDesc), fontSize = 18.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Surface(onClick = { numberOfClicks += 2 }) {
            Image(painter = painterResource(id = imageResource), contentDescription = stringResource(
                id = textContentDescription
            ), Modifier.border(BorderStroke(width = 1.dp, color = Color(red = 105, green = 205, blue = 216))))
        }

    }
}

@Preview
@Composable
fun LemonadeApp(){
    LemonadeWithImageAndText(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}

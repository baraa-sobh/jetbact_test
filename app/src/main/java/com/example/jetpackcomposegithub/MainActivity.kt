package com.example.jetpackcomposegithub

import android.graphics.drawable.Icon
import android.icu.text.AlphabeticIndex.Bucket.LabelType
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.net.PasswordAuthentication
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyList()
        }
    }
}

@Composable
fun MyListGrid() {
    LazyVerticalGrid(columns = GridCells.Fixed(3), contentPadding = PaddingValues(8.dp)) {
        items(count = 200){
            CardLazy(num = "$it")
        }
    }
}

@Composable
fun CardLazy(num :String) {
    Card(modifier = Modifier.padding(10.dp).width(50.dp).height(70.dp),
        backgroundColor = Color(
            Random.nextFloat(),
            Random.nextFloat(),
            Random.nextFloat(),
            1f


        )) {

        Column(modifier = Modifier,
            verticalArrangement = Arrangement.Center
            , horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text(text = num)
        }
    }

}

@Preview
@Composable
fun MYListGridPreview() {

    MyListGrid()
}

@Composable
fun MyList() {
    var arr = listOf(
        "ali", "baraa", "alaa", "jana", "nemar", "abood", "azz", "mohamed",
        "ali", "baraa", "alaa", "jana", "nemar", "abood", "azz", "mohamed"
    )
    Column(modifier = Modifier.background(Color.Gray)) {
        LazyRow(contentPadding = PaddingValues(10.dp)) {
            items(arr) {
                MyCardList(name = it)
            }
        }
        LazyColumn(contentPadding = PaddingValues(10.dp), reverseLayout = true) {
            items(arr) {
                MyCardList(name = it)
            }
        }

    }

}

@Composable
fun MyCardList(name: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(100.dp),
        elevation = 10.dp, shape = RoundedCornerShape(15.dp)
    ) {

        Row(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = name, fontSize = 25.sp)
        }
    }
}

//@Preview
//@Composable
//fun MyListPreview() {
//    MyList()
//}

@Composable
fun MyCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(270.dp),
            shape = RoundedCornerShape(15.dp),
            backgroundColor = Color.White,
            elevation = 10.dp
        ) {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "",
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth(), contentScale = ContentScale.Crop

                )
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "title", fontSize = 25.sp, fontFamily = FontFamily.SansSerif
                    )
                    Text(
                        text = "hi, welcome baraa sobh : I,am happy and i miss you vvvvv",
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(top = 8.dp)
                    )


                }

            }

        }
    }
}

//@Preview
//@Composable
//fun MyCardPreview() {
//    MyCard()
//}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Login() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        var text by remember {
            mutableStateOf("")
        }
        var keyboardController = LocalSoftwareKeyboardController.current

        TextField(value = text,
            onValueChange = { text = it },
            label = { Text(text = "enter your email") },
            placeholder = { Text(text = "baraa@gmail.com") },
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "icon email"
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { keyboardController?.hide() }
            )


        )
    }
}
//
//@Preview
//@Composable
//fun loginPreview() {
//    Login()
//}


@Composable
fun image() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center


    ) {

        Text(text = "baraa sobh".repeat(30), overflow = TextOverflow.Ellipsis, maxLines = 3)

        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "image",
            modifier = Modifier
                .size(200.dp)
                .padding(bottom = 20.dp)
                .clip(RoundedCornerShape(40.dp)),
            contentScale = ContentScale.Crop

        )

        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "image",
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop

        )

    }
}
//@Preview
//@Composable
//fun imgePreview() {
//    image()
//}


@Composable
fun testState() {
    var count = rememberSaveable {
        mutableStateOf(0)
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {

        var arr = arrayListOf("baraa", "ali", "jana", "abood")

        arr.forEach { it: String ->
            var chicked by remember {
                mutableStateOf(false)
            }
            Row {
                Checkbox(
                    checked = chicked,
                    onCheckedChange = { chicked = it }, Modifier.background(Color.Gray)
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(text = it)

            }
        }


//        Checkbox(checked =chicked.value ,
//            onCheckedChange = { chicked.value = it },Modifier.background(Color.Gray))


    }
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White),
//        contentAlignment = Alignment.Center
//
//    )
//    {
//        Button(onClick = { count.value++ }) {
//            Text(text = "click : ${count.value}")
//        }
//
//    }
}
//
//@Preview
//@Composable
//fun testStatePreview() {
//    testState()
//}


@Composable
fun Btn() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(topStart = 8.dp, bottomEnd = 8.dp)
        ) {
            Text(text = "Go")
        }
        Button(
            onClick = { /*TODO*/ },
            shape = CutCornerShape(9.dp)

        ) {
            Text(text = "Button cut Corner")
        }

        Button(
            onClick = { Toast.makeText(context, "welcome", Toast.LENGTH_LONG).show() },
            modifier = Modifier.size(100.dp),
            shape = CircleShape,
            elevation = ButtonDefaults.elevation(
                defaultElevation = 20.dp,
                pressedElevation = 100.dp
            ),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF75CBF1)
            )
        ) {

            Text(text = "circle")
        }

    }
}
//
//@Preview
//@Composable
//fun BtnPreview() {
//    Btn()
//}


@Composable
fun MyButton() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Start")
        }

        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "OutlinedButton")
        }

        TextButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.Favorite, contentDescription = null,
                modifier = Modifier.size(ButtonDefaults.IconSize),
                tint = Color.Red

            )
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "TextButton")

        }

        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.Call, contentDescription = null)
        }

        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(10.dp), colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Green,
                contentColor = Color.White
            )

        )

        {
            Icon(imageVector = Icons.Filled.Add, null)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "ADD")

        }

    }


}
//
//@Preview("MyButton")
//@Composable
//fun MybuttonPreview() {
//    MyButton()
//}

@Composable
fun Test() {
    Surface(
        modifier = Modifier
            .background(color = Color.Gray)
            .height(150.dp)
            .width(250.dp)
            .padding(20.dp),
        shape = RoundedCornerShape(4.dp), color = Color.Cyan
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "baraa",
                modifier = Modifier.padding(12.dp), textAlign = TextAlign.Center
            )
            Text(
                text = "Sobh",
                modifier = Modifier.padding(12.dp), textAlign = TextAlign.Center
            )
        }

    }
}

//@Preview
//@Composable
//fun TestPreview() {
//    Test()
//}
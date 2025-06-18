package com.example.revising.Screens

import android.graphics.drawable.shapes.Shape
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Shapes
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.revising.R
import com.example.revising.Datas.Routes
import com.example.revising.ui.theme.Purple40
import org.intellij.lang.annotations.JdkConstants

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailedScreen(
    navController: NavHostController, text: String, age: Int?, desc: String
) {

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        content = { contentpadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(contentpadding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                OutlinedCard(
                    modifier = Modifier
                        .width(320.dp)
                        .height(250.dp)
                        .wrapContentSize(),
                    border = _root_ide_package_.androidx.compose.foundation.BorderStroke(
                        2.dp,
                        if (isSystemInDarkTheme()) White else Black
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(top = 10.dp, start = 10.dp, end = 10.dp, bottom = 6.dp)
                    ) {

                        Text(
                            "NAME: ",
                            modifier = Modifier,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(text, modifier = Modifier, fontSize = 22.sp)
                    }
                    Row(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(8.dp)
                    ) {
                        Text("AGE: ", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                        Text(age.toString(), fontSize = 22.sp)

                    }
                    Row(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(8.dp)
                    ) {
                        Text("DESCRIPTION: ", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                        LazyColumn() {
                            item {
                                Text(
                                    desc,
                                    fontSize = 22.sp,
                                    overflow = TextOverflow.Ellipsis,
                                    textAlign = TextAlign.Start,
                                    softWrap = true
                                )
                            }
                        }
                    }

                }
            }

        },
        topBar = {
            TopAppBar(
                title = {
                    Text("Detailed Screen", fontSize = 22.sp)
                },
                modifier = Modifier,
                navigationIcon = {
                    Icon(
                        painter = painterResource(R.drawable.baseline_arrow_back_24),
                        contentDescription = null,
                        tint = White,
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .clickable {
                                navController.navigate(Routes.MainScreen.route) {
                                    popUpTo(0) {
                                        inclusive = true
                                    }
                                }
                            }
                    )
                },
                colors = TopAppBarColors(
                    containerColor = Purple40,
                    scrolledContainerColor = Color.Red,
                    navigationIconContentColor = White,
                    titleContentColor = White,
                    actionIconContentColor = White
                ),

                )
        },

        )
}

@Preview()
@Composable
private fun DNEDNE() {

    DetailedScreen(
        rememberNavController(),
        "dede",
        33,
        "hdeidjdjedejdoioie fj eifheffjeifj fiehjfpe   ffi foe foi ehfoiheofih efoihe ofiheofh oefheofh eo fhfefpejfpejfpoejfpoejfepojfopefj epofj opefj opejf pojojfojf pjpfjepjpfjepfpfej  eofh eofheofheihf oiehf oiehf oef hoiehfoehfiefhefhefeh foie hfouie fouifoiefhof eof euf geug feu e fuie i egegf g"
    )
}
package com.example.revising.Screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.revising.CustomDropDown
import com.example.revising.Datas.listing
import com.example.revising.ui.theme.Purple40

@RequiresApi(Build.VERSION_CODES.S)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    val scrollState = rememberLazyListState()
    val contex = LocalContext.current
//    val colourScheme = dynamicLightColorScheme(contex)
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Revising",
                        fontSize = 20.sp
                    )
                },
                colors = TopAppBarColors(
                    containerColor = if (isSystemInDarkTheme()) {
                        if (scrollState.firstVisibleItemIndex > 0) MaterialTheme.colorScheme.onPrimary else Purple40
                    } else if (scrollState.firstVisibleItemIndex > 0) Color.Magenta else Purple40,
                    scrolledContainerColor = Color.Red,
                    navigationIconContentColor = Color.Red,
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.Red
                ),
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier.padding(5.dp)
                    )
                }
            )
        },

        content = {
//                        )
            LazyColumn(
                modifier = Modifier
                    .animateContentSize()
                    .wrapContentSize()
                    .fillMaxSize()
                    .padding(2.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                state = scrollState,
                contentPadding = it
            ) {


                items(listing) {

                    Spacer(
                        modifier = Modifier
                            .padding(4.dp)
                    )
//                    var dialogState = remember {
//                        mutableStateOf(false)
//                    }
//                    if (dialogState.value) {
//                        CustomDialog(dialogState, it, navController)
//                    }

//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .clip(RoundedCornerShape(30.dp))
//                            .background(
//                                if (isSystemInDarkTheme()) {
//                                    Color.Blue
//                                } else Color.Blue.copy(alpha = 0.5f)
//                            )
//                            .clickable {
//                                dialogState.value = !dialogState.value
//                            },
//                        verticalAlignment = Alignment.CenterVertically,
//                        horizontalArrangement = Arrangement.Center,
//
//                        ) {
//                        Text(
//                            text = "DUDE the name is ${it.text}",
//                            modifier = Modifier
//                                .padding(30.dp),
//                            fontSize = 20.sp
//                        )
//
//                    }
                    CustomDropDown(it.text, it.age, it.description, navController)


                }
            }

        },
    )

}


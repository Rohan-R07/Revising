package com.example.revising

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.revising.Datas.Routes


//@Composable
//fun CustomDialog(
//    state: MutableState<Boolean>?,
//    Data: ListingData,
//    navController: NavHostController
//) {
//    Dialog(
//        onDismissRequest = {
//            state?.value = false
//        },
//    ) {
//
//
//        Box(
//            modifier = Modifier
//                .clip(RoundedCornerShape(33.dp))
//                .background(White),
//
//            ) {
//            Column(
//                modifier = Modifier
//                    .wrapContentSize()
//                    .padding(40.dp)
//                    .background(White),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
//
//            ) {
//                Text(
//                    "You have pressed ${Data.text} ",
//                    modifier = Modifier,
//                    color = Black,
//                    textAlign = TextAlign.Center
//                )
//                Spacer(modifier = Modifier.padding(10.dp))
//                Button(
//                    modifier = Modifier,
//                    colors = ButtonColors(
//                        containerColor = Purple40,
//                        contentColor = White,
//                        disabledContentColor = White,
//                        disabledContainerColor = Color.Red
//                    ),
//                    onClick = {
//                        state?.value = false
//                        navController.navigate(
//                            Routes.DetailedScreen.passTEXAGEDEsc(
//                                Data.text,
//                                Data.age,
//                                Data.description
//                            )
//                        ) {
//                            popUpTo(0) {
//                                inclusive = true
//                            }
//                        }
//
//                    }
//                ) {
//                    Text("Detailed view", modifier = Modifier, color = White)
//                    Icon(
//                        painter = painterResource(R.drawable.outline_deployed_code_account_24),
//                        contentDescription = "",
//                        modifier = Modifier
//                            .padding(start = 3.dp)
//                    )
//
//                }
//            }
//        }
//    }
//
//}

@Composable
fun CustomDropDown(text: String, age: Int, desc: String, navHOstController: NavHostController) {
    val dialogState = remember { mutableStateOf(false) }
    val dropDownState = remember {
        mutableStateOf(true)
    }
    Row(
        modifier = Modifier
            .background(
                if (isSystemInDarkTheme()) {
                    Color.Blue
                } else Color.Blue.copy(alpha = 0.5f),
                shape = RoundedCornerShape(20.dp)

            )
            .animateContentSize()
            .width(340.dp)
            .clip(RoundedCornerShape(20.dp))
            .pointerInput(Unit) {
                detectTapGestures(
                    onLongPress = {
                        navHOstController.navigate(
                            Routes.DetailedScreen.passTEXAGEDEsc(
                                text,
                                age,
                                desc
                            )
                        )
                    },
                    onTap = {

                        dialogState.value = !dialogState.value
                        dropDownState.value = !dropDownState.value
                    }
                )
            }
            .height(if (dropDownState.value) 80.dp else 150.dp)

    ) {
//        val top = 20.dp
        Row(
            modifier = Modifier
                .height(if (dropDownState.value) 80.dp else 200.dp)
                .animateContentSize()
                .background(
                    if (isSystemInDarkTheme()) {
                        Color.Blue
                    } else Color.Blue.copy(alpha = 0.5f)
                )
                .width(260.dp),


            ) {
            Column() {
                Text(
                    text = "NAME: " + text,// it has to be allpied nigga
                    modifier = Modifier
                        .padding(start = 30.dp, top = 28.dp),
                    fontSize = 24.sp,
                    color = White
                )
                OutlinedButton(
                    modifier = Modifier
                        .padding(start = 30.dp, top = 28.dp)
                        .background(Blue.copy(alpha = 0.5f)),
                    onClick = {
                        navHOstController.navigate(
                            Routes.DetailedScreen.passTEXAGEDEsc(
                                text,
                                age,
                                desc
                            )
                        )
                    }
                ) {
                    Text("MORE DETAILS")
                }
            }
        }

        Icon(
            painter = painterResource(
                if (!dialogState.value) {
                    R.drawable.baseline_arrow_drop_down_24
                } else R.drawable.baseline_arrow_drop_up_24
            ),
            contentDescription = null,
            tint = White,
            modifier = Modifier
                .animateContentSize()
                .padding(top = 26.dp, start = 20.dp)
                .size(30.dp),
        )
    }
}

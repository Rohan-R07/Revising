package com.example.revising.Datas

const val TEXT_KEY = "text"
const val AGE_KEY = "age"
const val DESC_KEY = "desc"

sealed class Routes(val route: String) {
    object MainScreen : Routes(route = "mainScreen")
    object DetailedScreen : Routes(route = "detailedScreen/{$TEXT_KEY}/{$AGE_KEY}/{$DESC_KEY}") {

        fun passTEXAGEDEsc(text: String, age: Int, desc: String): String {
            return "detailedScreen/$text/$age/$desc"
        }
    }
}
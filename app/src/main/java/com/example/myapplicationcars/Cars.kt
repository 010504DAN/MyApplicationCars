package com.example.myapplicationcars

import java.io.Serializable

data class Cars(val image: String, val name: String, val desc: String, val prise: String, val manu: String):
    Serializable

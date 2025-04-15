package com.example.firebaseapp

data class Student(
    val id: String = "",
    val name: String = "",
    val program: String = "",
    val phones: List<String> = emptyList()
)

package com.rehan.flipkartmachinecodinground.models

data class Player(
    val id: Int,
    val name: String,
    val icon: String,
    val score: Int = 0,
    val totalScore: Int = 0
)


package com.classic.character1000.dictionary

data class StrokeOrder(
    val medians: List<List<List<Int>>> = listOf(),
    val radStrokes: List<Int> = listOf(),
    val strokes: List<String> = listOf()
)
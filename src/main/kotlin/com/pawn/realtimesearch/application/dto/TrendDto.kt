package com.pawn.realtimesearch.application.dto

object TrendDto {

    data class Trend(
        val id: Long,
        val title: String,
        val content: String
    )

    data class CreateRequest(
        val title: String,
        val content: String
    )

    data class UpdateRequest(
        val id: Long,
        val title: String,
        val content: String
    )

}
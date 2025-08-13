package com.pawn.realtimesearch.presentation.dto

object TrendRequest {

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
package com.pawn.realtimesearch.presentation.dto

object TrendResponse{

    data class CreateResponse(
        val id: Long,
        val title: String,
        val content: String
    )

    data class UpdateResponse(
        val id: Long,
        val title: String,
        val content: String
    )

    data class DetailResponse(
        val id: Long,
        val title: String,
        val content: String
    )

}

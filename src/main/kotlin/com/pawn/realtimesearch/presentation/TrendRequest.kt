package com.pawn.realtimesearch.presentation

import com.pawn.realtimesearch.application.TrendDto

data class CreateTrendRequest(
    val title: String,
    val content: String
) {
    fun toDto(): TrendDto =
        TrendDto(id = null, title = title, content = content)
}

data class UpdateTrendRequest(
    val title: String,
    val content: String
) {
    fun toDto(id: Long): TrendDto =
        TrendDto(id = id, title = title, content = content)
}

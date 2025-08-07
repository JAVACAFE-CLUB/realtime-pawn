package com.pawn.realtimesearch.application

import com.pawn.realtimesearch.domain.Trend
import com.pawn.realtimesearch.presentation.TrendResponse

object TrendMapper {
    fun toEntity(dto: TrendDto): Trend =
        Trend(title = dto.title, content = dto.content)

    fun toDto(entity: Trend): TrendDto =
        TrendDto(id = entity.id, title = entity.title, content = entity.content)

    fun toResponse(dto: TrendDto): TrendResponse =
        TrendResponse(id = dto.id ?: 0L, title = dto.title, content = dto.content)
}

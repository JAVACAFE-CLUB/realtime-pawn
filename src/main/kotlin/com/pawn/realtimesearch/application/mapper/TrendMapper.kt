package com.pawn.realtimesearch.application.mapper

import com.pawn.realtimesearch.application.dto.TrendDto
import com.pawn.realtimesearch.domain.Trend

fun TrendDto.Trend.toEntity(): Trend =
    Trend(title = title, content = content)

fun TrendDto.CreateRequest.toEntity(): Trend =
    Trend(title = title, content = content)

fun Trend.toDto(): TrendDto.Trend =
    TrendDto.Trend(id = id!!, title = title, content = content)
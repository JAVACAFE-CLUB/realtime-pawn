package com.pawn.realtimesearch.presentation.mapper

import com.pawn.realtimesearch.application.dto.TrendDto
import com.pawn.realtimesearch.presentation.dto.TrendRequest
import com.pawn.realtimesearch.presentation.dto.TrendResponse

fun TrendRequest.CreateRequest.toDto() =
    TrendDto.CreateRequest(title = title, content = content)

fun TrendRequest.UpdateRequest.toDto(id: Long) =
    TrendDto.UpdateRequest(id = id, title = title, content = content)

fun TrendDto.Trend.toCreateResponse() =
    TrendResponse.CreateResponse(id = id, title = title, content = content)

fun TrendDto.Trend.toUpdateResponse() =
    TrendResponse.UpdateResponse(id = id, title = title, content = content)

fun TrendDto.Trend.toDetailResponse() =
    TrendResponse.DetailResponse(id = id, title = title, content = content)
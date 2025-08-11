package com.pawn.realtimesearch.presentation.controller

import com.pawn.realtimesearch.application.service.TrendService
import com.pawn.realtimesearch.presentation.dto.TrendRequest
import com.pawn.realtimesearch.presentation.dto.TrendResponse
import com.pawn.realtimesearch.presentation.mapper.toCreateResponse
import com.pawn.realtimesearch.presentation.mapper.toDetailResponse
import com.pawn.realtimesearch.presentation.mapper.toDto
import com.pawn.realtimesearch.presentation.mapper.toUpdateResponse
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/trends")
class TrendController(
    private val trendService: TrendService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createTrend(@RequestBody request: TrendRequest.CreateRequest): TrendResponse.CreateResponse {
        val savedTrend = trendService.createTrend(request.toDto())

        return savedTrend.toCreateResponse()
    }

    @GetMapping("/{id}")
    fun getTrend(@PathVariable id: Long): TrendResponse.DetailResponse {
        val dto = trendService.getTrend(id)

        return dto.toDetailResponse()
    }

    @GetMapping
    fun getTrends(@PageableDefault(size = 10) pageable: Pageable) =
        trendService.getTrends(pageable).map { it.toDetailResponse() }

    @PutMapping("/{id}")
    fun updateTrend(
        @PathVariable id: Long,
        @RequestBody request: TrendRequest.UpdateRequest
    ): TrendResponse.UpdateResponse {
        val updatedTrend = trendService.updateTrend(request.toDto(id))

        return updatedTrend.toUpdateResponse()
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTrend(@PathVariable id: Long) {
        trendService.deleteTrend(id)
    }

}
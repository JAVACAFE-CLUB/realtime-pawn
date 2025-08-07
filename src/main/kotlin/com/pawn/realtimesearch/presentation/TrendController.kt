package com.pawn.realtimesearch.presentation

import com.pawn.realtimesearch.application.TrendMapper
import com.pawn.realtimesearch.application.TrendService
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/trends")
class TrendController(
    private val trendService: TrendService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createTrend(@RequestBody request: CreateTrendRequest): TrendResponse {
        val dto = trendService.createTrend(request.toDto())

        return TrendMapper.toResponse(dto)
    }

    @GetMapping("/{id}")
    fun getTrend(@PathVariable id: Long): TrendResponse {
        val dto = trendService.getTrend(id)

        return TrendMapper.toResponse(dto)
    }

    @GetMapping
    fun getTrends(@PageableDefault(size = 10) pageable: Pageable) =
        trendService.getTrends(pageable).map { TrendMapper.toResponse(it) }

    @PutMapping("/{id}")
    fun updateTrend(
        @PathVariable id: Long,
        @RequestBody request: UpdateTrendRequest
    ): TrendResponse {
        val dto = trendService.updateTrend(request.toDto(id))

        return TrendMapper.toResponse(dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTrend(@PathVariable id: Long) {
        trendService.deleteTrend(id)
    }

}

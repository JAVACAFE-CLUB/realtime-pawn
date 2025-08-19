package com.pawn.realtimesearch.application.service

import com.pawn.realtimesearch.application.dto.TrendDto
import com.pawn.realtimesearch.application.mapper.toDto
import com.pawn.realtimesearch.application.mapper.toEntity
import com.pawn.realtimesearch.common.error.CustomException
import com.pawn.realtimesearch.common.error.ErrorCode
import com.pawn.realtimesearch.infrastructure.TrendRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class TrendService(
    private val trendRepository: TrendRepository
) {
    @Transactional
    fun createTrend(dto: TrendDto.CreateRequest): TrendDto.Trend {
        val entity = dto.toEntity()
        val savedTrend = trendRepository.save(entity)

        return savedTrend.toDto()
    }

    fun getTrend(id: Long): TrendDto.Trend {
        val foundTrend = trendRepository.findById(id)
            .orElseThrow { CustomException(ErrorCode.NOT_FOUND) }

        return foundTrend.toDto()
    }

    fun getTrends(pageable: Pageable): Page<TrendDto.Trend> {
        return trendRepository.findAll(pageable).map { it.toDto() }
    }

    @Transactional
    fun updateTrend(dto: TrendDto.UpdateRequest): TrendDto.Trend {
        val targetTrend = trendRepository.findById(dto.id)
            .orElseThrow { CustomException(ErrorCode.NOT_FOUND) }
        targetTrend.update(dto.title, dto.content)

        return targetTrend.toDto()
    }

    @Transactional
    fun deleteTrend(id: Long) {
        if (!trendRepository.existsById(id)) {
            throw CustomException(ErrorCode.NOT_FOUND)
        }
        trendRepository.deleteById(id)
    }
}
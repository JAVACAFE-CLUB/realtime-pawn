package com.pawn.realtimesearch.application

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
    fun createTrend(dto: TrendDto): TrendDto {
        val entity = TrendMapper.toEntity(dto)
        val saved = trendRepository.save(entity)

        return TrendMapper.toDto(saved)
    }

    @Transactional(readOnly = true)
    fun getTrend(id: Long): TrendDto {
        val trend = trendRepository.findById(id)
            .orElseThrow { CustomException(ErrorCode.NOT_FOUND) }

        return TrendMapper.toDto(trend)
    }

    @Transactional(readOnly = true)
    fun getTrends(pageable: Pageable): Page<TrendDto> {
        return trendRepository.findAll(pageable).map { TrendMapper.toDto(it) }
    }

    @Transactional
    fun updateTrend(dto: TrendDto): TrendDto {
        val foundTrend = trendRepository.findById(dto.id!!)
            .orElseThrow { CustomException(ErrorCode.NOT_FOUND) }
        foundTrend.update(dto.title, dto.content)

        return TrendMapper.toDto(foundTrend)
    }

    @Transactional
    fun deleteTrend(id: Long) {
        if (!trendRepository.existsById(id)) {
            throw CustomException(ErrorCode.NOT_FOUND)
        }

        trendRepository.deleteById(id)
    }
}

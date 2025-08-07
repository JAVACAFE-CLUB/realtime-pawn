package com.pawn.realtimesearch.infrastructure

import com.pawn.realtimesearch.domain.Trend
import org.springframework.data.jpa.repository.JpaRepository

interface TrendRepository : JpaRepository<Trend, Long>

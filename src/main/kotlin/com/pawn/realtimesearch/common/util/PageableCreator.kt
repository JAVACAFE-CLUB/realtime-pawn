package com.pawn.realtimesearch.common.util

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort

object PageableCreator {
    private const val MAX_SIZE = 500

    fun create(page: Int, size: Int, sortList: List<String>?): Pageable {
        val safePage = if (page < 1) 1 else page
        val safeSize = when {
            size < 1 -> 1
            size > MAX_SIZE -> MAX_SIZE
            else -> size
        }

        val orders = if (!sortList.isNullOrEmpty()) {
            sortList
                .map { sortOption ->
                    val parts = sortOption.split(":")
                    val field = parts[0]
                    val direction = if (parts.size > 1 && parts[1].equals("desc", ignoreCase = true)) {
                        Sort.Direction.DESC
                    } else {
                        Sort.Direction.ASC
                    }
                    Sort.Order(direction, field)
                }
                .distinctBy { it.property }
        } else {
            emptyList()
        }

        val finalOrders = orders.ifEmpty {
            listOf(Sort.Order.desc("id"))
        }

        return PageRequest.of(safePage - 1, safeSize, Sort.by(finalOrders))
    }
}
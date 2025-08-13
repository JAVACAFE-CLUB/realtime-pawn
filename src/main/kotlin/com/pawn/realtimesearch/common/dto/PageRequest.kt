package com.pawn.realtimesearch.common.dto

import com.pawn.realtimesearch.common.util.PageableCreator
import org.springframework.data.domain.Pageable

data class PageRequest (
    val page: Int = 0,
    val size: Int = 10,
    val sort: List<String>
)

fun PageRequest.toPageable() : Pageable {
    return PageableCreator.create(page, size, sort)
}
package com.pawn.realtimesearch.common.dto

import org.springframework.data.domain.Page

data class PageResponse<T>(
    val pagination: CustomPagination,
    val items: List<T>
) {
    data class CustomPagination(
        val totalCount: Long,
        val totalPages: Int,
        val page: Int,
        val size: Int
    )

    companion object {
        fun <T> of(page: Page<T>): PageResponse<T> =
            PageResponse(
                pagination = CustomPagination(
                    totalCount = page.totalElements,
                    totalPages = page.totalPages,
                    page = page.number + 1,
                    size = page.size
                ),
                items = page.content
            )
    }
}

fun <T> Page<T>.wrapPageResponse(): PageResponse<T> =
    PageResponse.of(this)
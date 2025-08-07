package com.pawn.realtimesearch.common.dto

import java.time.LocalDateTime

data class ApiResponse<T>(
    val success: Boolean,
    val status: Int,
    val data: T?,
    val message: String? = null,
    val timestamp: LocalDateTime = LocalDateTime.now()
) {
    companion object {
        @JvmStatic
        fun <T> success(
            status: Int,
            data: T,
            message: String? = null
        ): ApiResponse<T> =
            ApiResponse(true, status, data, message)

        @JvmStatic
        fun <T> fail(
            status: Int,
            errorData: T,
            message: String? = null
        ): ApiResponse<T> =
            ApiResponse(false, status, errorData, message)
    }
}

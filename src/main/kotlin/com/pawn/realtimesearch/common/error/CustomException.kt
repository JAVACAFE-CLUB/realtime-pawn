package com.pawn.realtimesearch.common.error

class CustomException(
    val errorCode: ErrorCode,
) : RuntimeException(errorCode.message)
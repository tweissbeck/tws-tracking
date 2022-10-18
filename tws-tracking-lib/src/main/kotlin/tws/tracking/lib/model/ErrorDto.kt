package tws.tracking.lib.model

import java.time.LocalDateTime

data class ErrorDto(
    val status: Int,
    val error: String,
    val path: String,
    val message: String?,
    val timestamp: LocalDateTime = LocalDateTime.now()
)


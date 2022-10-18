package tws.trackingcore.controller.model

import java.time.LocalDate
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class CounterDto(
    val id: Long = 0,
    @field:NotBlank(message = "Name is mandatory")
    val name: String,
    @field:NotNull(message = "Measure unit is mandatory")
    @field:Valid
    val measureUnit: MeasureUnitDto,
    @field:NotNull(message = "Counter periodicity is mandatory")
    val periodicity: Periodicity,
    @field:NotNull(message = "Start date required")
    val startDate: LocalDate
)

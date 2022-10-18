package tws.trackingcore.controller.model

import javax.validation.constraints.NotBlank

data class MeasureUnitDto(
    val id: Long = 0,
    @field:NotBlank(message = "Measure unit name is mandatory")
    val name: String,
    @field:NotBlank(message = "Measure unit symbol is mandatory")
    val symbol: String) {
}
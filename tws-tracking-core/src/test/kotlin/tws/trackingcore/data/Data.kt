package tws.trackingcore.data

import tws.trackingcore.controller.model.CounterDto
import tws.trackingcore.controller.model.MeasureUnitDto
import tws.trackingcore.controller.model.Periodicity

val MeasureUnit1 = MeasureUnitDto(1, "Kilomètre", "km")
val MeasureUnit2 = MeasureUnitDto(1, "Watt", "w")

val Counter1 = CounterDto(1, "Clio", MeasureUnit1, Periodicity.MONTHLY)
val Counter2 = CounterDto(2, "Honda", MeasureUnit1, Periodicity.MONTHLY)

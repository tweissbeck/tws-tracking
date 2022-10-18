package tws.trackingcore.service.ext

import tws.trackingcore.controller.model.CounterDto
import tws.trackingcore.controller.model.MeasureUnitDto
import tws.trackingcore.controller.model.Periodicity
import tws.trackingcore.entities.CounterEntity
import tws.trackingcore.entities.MeasureUnitEntity

fun MeasureUnitDto.toEntity(): MeasureUnitEntity {
    return MeasureUnitEntity(id = id, name = name, symbol = symbol)
}

fun MeasureUnitEntity.toDto(): MeasureUnitDto {
    return MeasureUnitDto(id, name, symbol)
}

fun CounterEntity.toDto(): CounterDto {
    return CounterDto(id, name, measureUnit.toDto(), Periodicity.valueOf(periodicity), startDate)
}

fun CounterDto.toEntity(): CounterEntity {
    return CounterEntity(name = name, measureUnit = measureUnit.toEntity(), periodicity = periodicity.name, startDate = startDate)
}
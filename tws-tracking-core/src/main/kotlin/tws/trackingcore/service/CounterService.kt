package tws.trackingcore.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import tws.trackingcore.controller.model.CounterDto
import tws.trackingcore.controller.model.CounterHistoDto
import tws.trackingcore.controller.model.HistoDataDto
import tws.trackingcore.controller.model.MeasureUnitDto
import tws.trackingcore.controller.model.Periodicity
import tws.trackingcore.entities.CounterEntity
import tws.trackingcore.repository.CounterRepository
import tws.trackingcore.repository.MeasureUnitRepository
import tws.trackingcore.service.ext.toDto
import tws.trackingcore.service.ext.toEntity
import java.util.Collections

/**
 * The service for the counter domain
 */
@Service
class CounterService(
    @Autowired private val counterRepository: CounterRepository,
    @Autowired private val measureRepository: MeasureUnitRepository
) {

    /**
     * Returns a [Page] of [CounterDto] meeting the paging restriction provided in the [Pageable] object.
     */
    fun findAll(pageable: Pageable): Page<CounterDto> {
        return counterRepository.findAll(pageable).map { it.toDto() }
    }

    /**
     * Save a new [CounterEntity] from the given [CounterDto]. P
     * This method perform the check on data
     */
    fun save(dto: CounterDto): CounterDto {
        val measure = dto.measureUnit.toEntity()
        val measureEntityOption = measureRepository.findById(measure.id)
        val measureUnitEntity =
            measureEntityOption.orElseThrow { IllegalStateException("Measure with ${measure.id} not found in database") }
        if (measureUnitEntity.equals(measure)) {
            val counterToSave = CounterEntity(dto.id, dto.name, measureUnitEntity, Collections.emptyList(), dto.periodicity.name, dto.startDate)
            return counterRepository.save(counterToSave).toDto()
        } else {
            throw IllegalStateException("Trying so save a new counter with a measure that do not exist")
        }
    }

    /**
     * Find the counter with the data bind to it and return a [CounterHistoDto]
     * Return null if no [CounterEntity] exist with given id
     */
    fun findWithHisto(id: Long): CounterHistoDto? {
        val counter: CounterEntity? = counterRepository.findFetchHisto(id)
        return if (counter == null)
            null
        else CounterHistoDto(
            CounterDto(
                counter.id,
                counter.name,
                MeasureUnitDto(counter.measureUnit.id, counter.measureUnit.name, counter.measureUnit.symbol),
                Periodicity.valueOf(counter.periodicity),
                counter.startDate
            ),
            counter.data.map { HistoDataDto(it.value, it.date) }.toList()
        )
    }

}

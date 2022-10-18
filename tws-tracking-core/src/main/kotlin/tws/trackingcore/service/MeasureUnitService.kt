package tws.trackingcore.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import tws.trackingcore.controller.model.MeasureUnitDto
import tws.trackingcore.repository.MeasureUnitRepository
import tws.trackingcore.service.ext.toDto
import tws.trackingcore.service.ext.toEntity
import java.lang.IllegalArgumentException

/**
 * The service for MeasureUnit domain
 */
@Service
class MeasureUnitService(@Autowired private val measureUnitRepository: MeasureUnitRepository) {

    fun findAll(): List<MeasureUnitDto> {
        return measureUnitRepository.findAll().map { MeasureUnitDto(it.id, it.name, it.symbol) }.toList()
    }

    fun save(measureUnitDto: MeasureUnitDto): MeasureUnitDto {
        if(measureUnitDto.name.isBlank() || measureUnitDto.symbol.isBlank()){
            throw IllegalArgumentException("name and symbol must not be empty or blank");
        }
        val entity = measureUnitRepository.save(measureUnitDto.toEntity())
        return entity.toDto();
    }

}
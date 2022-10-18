package tws.trackingcore.repository

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import tws.trackingcore.entities.MeasureUnitEntity

/**
 * [Repository] for entity [MeasureUnitRepository]
 */
@Repository
interface MeasureUnitRepository : PagingAndSortingRepository<MeasureUnitEntity, Long>
package tws.trackingcore.repository

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import tws.trackingcore.entities.CounterEntity

/**
 * [Repository] for entity [CounterEntity]
 */
@Repository
interface CounterRepository : PagingAndSortingRepository<CounterEntity, Long> {

    /**
     * Find a [CounterEntity] with id [id] and fetch [CounterEntity.data]
     */
    @Query("SELECT c FROM CounterEntity c JOIN FETCH c.data WHERE c.id = (:id)")
    fun findFetchHisto(id: Long): CounterEntity?
}
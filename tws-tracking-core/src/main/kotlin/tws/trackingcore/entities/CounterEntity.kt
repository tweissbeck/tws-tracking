package tws.trackingcore.entities

import java.time.LocalDate
import java.util.*
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

/**
 * A counter like the kilometer counter of a car
 */
@Entity
@Table(name = "counter")
class CounterEntity(

    /**
     * Technical id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "counter__id")
    val id: Long = 0,

    /**
     * Name of the counter: eg 'Dad's car'
     */
    @Column(name = "counter__name", unique = true)
    val name: String,

    /**
     * The unit of this counter. Eg kilometer
     */
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "counter__measure_unit", nullable = false, updatable = true)
    val measureUnit: MeasureUnitEntity,

    @OneToMany(targetEntity = CounterDataEntity::class, cascade = [CascadeType.REMOVE], fetch = FetchType.LAZY)
    @JoinColumn(name="counter_data__counter_id")
    val data: List<CounterDataEntity> = Collections.emptyList(),

    @Column(name = "counter__periodicity", nullable = false)
    val periodicity: String,

    @Column(name = "counter__start_date", nullable = false)
    val startDate : LocalDate

)
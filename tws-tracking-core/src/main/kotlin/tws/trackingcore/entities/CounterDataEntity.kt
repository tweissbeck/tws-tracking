package tws.trackingcore.entities

import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "counter_data")
class CounterDataEntity(

    /**
     * Technical id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "counter_data__id")
    val id: Long = 0,

    /**
     * The value of the tracker at the {@link date} of the mesure
     */
    @Column(name = "counter_data_value")
    val value: Long,

    /**
     * Date of the mesure normalized with the tracker period.
     */
    @Column(name = "counter_data__date")
    val date: LocalDate,

)
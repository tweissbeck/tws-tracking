package tws.trackingcore.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


/**
 * The unit of the tracker
 */
@Entity
@Table(name = "measure_unit")
class MeasureUnitEntity(

    /**
     * Technical id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "measure_unit__id")
    var id: Long = 0,

    /**
     * The unit name, eg meter
     */
    @Column(name = "measure_unit__name", unique = true, length = 50, nullable = false)
    var name: String,

    /**
     * The unit symbol, eg m for meter
     */
    @Column(name = "measure_unit__symbol", length = 6, nullable = false)
    var symbol: String


) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MeasureUnitEntity

        if (id != other.id) return false
        if (name != other.name) return false
        if (symbol != other.symbol) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + symbol.hashCode()
        return result
    }
}





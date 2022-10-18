package tws.tracking.lib.model

import java.time.LocalDate

data class TrackingData(val date: LocalDate, val value: Long) : Comparable<TrackingData> {
    override fun compareTo(other: TrackingData): Int {
        return date.compareTo(other.date)
    }
}
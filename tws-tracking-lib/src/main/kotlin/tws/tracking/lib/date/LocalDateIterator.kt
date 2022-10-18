package tws.tracking.lib.date

import tws.tracking.lib.model.IPeriodicity
import java.time.LocalDate

class LocalDateIterator(startDate: LocalDate, private val endDateInclusive: LocalDate, private val periodicity: IPeriodicity) :
    Iterator<LocalDate> {

    private var currentDate = startDate
    override fun hasNext(): Boolean {
        return currentDate <= endDateInclusive
    }

    override fun next(): LocalDate {
        val next = currentDate
        currentDate = periodicity.inc(currentDate);
        return next
    }
}


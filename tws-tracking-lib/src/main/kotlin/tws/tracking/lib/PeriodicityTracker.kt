package tws.tracking.lib

import tws.tracking.lib.date.LocalDateProgression
import tws.tracking.lib.model.IPeriodicity
import java.time.LocalDate


class PeriodicityTracker(private val periodicity: IPeriodicity, startDate: LocalDate) {


    operator fun LocalDate.rangeTo(other: LocalDate) = LocalDateProgression(this, other)
    fun getList(start: LocalDate, end: LocalDate): List<LocalDate> {

        if(start.isAfter(end)){
            throw IllegalArgumentException("Start date is after end date");
        }

        fun getStartDateWithPeriodicity(date: LocalDate, periodicity: IPeriodicity): LocalDate {
            return periodicity.start(date)
        }

        val periodicityStartDate = getStartDateWithPeriodicity(start, this.periodicity)
        val periodicityEndDate = getStartDateWithPeriodicity(end, this.periodicity)

        val list = MutableList(0) { periodicityStartDate }

        for(d in periodicityStartDate .. periodicityEndDate step periodicity){
            list += d
        }
        return list

    }
}







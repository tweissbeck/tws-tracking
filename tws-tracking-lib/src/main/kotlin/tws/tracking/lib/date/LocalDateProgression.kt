package tws.tracking.lib.date

import tws.tracking.lib.model.IPeriodicity
import java.time.LocalDate


class LocalDateProgression(
    override val start: LocalDate, override val endInclusive: LocalDate,
    private val periodicity: IPeriodicity = object : IPeriodicity {
        override fun inc(date: LocalDate): LocalDate {
            return date.plusDays(1)
        }

        override fun start(now: LocalDate): LocalDate {
            return now
        }

        override fun getName(): String {
            return "DAYS"
        }
    }
) : Iterable<LocalDate>, ClosedRange<LocalDate> {

    override fun iterator(): Iterator<LocalDate> =
        LocalDateIterator(start, endInclusive, periodicity)

    infix fun step(periodicity: IPeriodicity): LocalDateProgression {
        return LocalDateProgression(start, endInclusive, periodicity)
    }
}




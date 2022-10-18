package tws.tracking.lib.model

import java.time.LocalDate

/**
 * Define tracking periodicity
 */
enum class Periodicity : IPeriodicity {
    /**
     * once per day
     */
    DAY,

    /**
     * Once per month, last day of month
     */
    MONTH,

    /**
     * Once per year, last day of year
     */
    YEAR;

    override fun inc(date: LocalDate): LocalDate {
        return when(this){
            DAY -> date.plusDays(1)
            MONTH -> date.plusMonths(1)
            YEAR -> date.plusYears(1)
        }
    }

    override fun start(now: LocalDate): LocalDate {
        return when(this){
            DAY -> now
            MONTH -> LocalDate.of(now.year, now.month, 1)
            YEAR -> LocalDate.of(now.year, 1 ,1)
        }
    }

    override fun getName(): String {
        return this.name
    }
}

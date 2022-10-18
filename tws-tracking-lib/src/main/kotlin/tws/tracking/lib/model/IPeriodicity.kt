package tws.tracking.lib.model

import java.time.LocalDate

interface IPeriodicity {

    fun inc(date: LocalDate): LocalDate
    fun start(now: LocalDate): LocalDate
    fun getName(): String

}
package tws.tracking.lib

import org.junit.Test
import tws.tracking.lib.model.Periodicity
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class PeriodicityTrackerTest {

    @Test
    fun testListDate(){
        val periodicityTracker : PeriodicityTracker = PeriodicityTracker(Periodicity.MONTH, LocalDate.of(2022,1,1))
        val months = periodicityTracker.getList(LocalDate.now(), LocalDate.now().plusYears(5))
       println("Test " + months.joinToString(", ") { it.format(DateTimeFormatter.ISO_DATE) })
    }
}
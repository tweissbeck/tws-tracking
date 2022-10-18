package tws.trackingcore

import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import tws.trackingcore.data.Counter1
import tws.trackingcore.data.Counter2
import tws.trackingcore.rule.BeforeClassBDRule

@ExtendWith(BeforeClassBDRule::class)
@SpringBootTest
@AutoConfigureMockMvc(printOnlyOnFailure = true, print = MockMvcPrint.DEFAULT)
@Sql("/reset-data.sql")
class CounterTest(
    @Autowired val mvc: MockMvc
) {

    @Test
    fun testGetCounter(){
        mvc.perform(get("/counter"))
            .andExpect(jsonPath("content.[0].id", Matchers.`is`(Counter1.id.toInt())))
            .andExpect(jsonPath("content.[0].name", Matchers.`is`(Counter1.name)))
            .andExpect(jsonPath("content.[0].periodicity", Matchers.`is`(Counter1.periodicity.name)))
            .andExpect(jsonPath("content.[0].measureUnit.id", Matchers.`is`(Counter1.measureUnit.id.toInt())))
            .andExpect(jsonPath("content.[0].measureUnit.name", Matchers.`is`(Counter1.measureUnit.name)))
            .andExpect(jsonPath("content.[0].measureUnit.symbol", Matchers.`is`(Counter1.measureUnit.symbol)))

            .andExpect(jsonPath("content.[1].id", Matchers.`is`(Counter2.id.toInt())))
            .andExpect(jsonPath("content.[1].name", Matchers.`is`(Counter2.name)))
            .andExpect(jsonPath("content.[1].periodicity", Matchers.`is`(Counter2.periodicity.name)))
            .andExpect(jsonPath("content.[1].measureUnit.id", Matchers.`is`(Counter2.measureUnit.id.toInt())))
            .andExpect(jsonPath("content.[1].measureUnit.name", Matchers.`is`(Counter2.measureUnit.name)))
            .andExpect(jsonPath("content.[1].measureUnit.symbol", Matchers.`is`(Counter2.measureUnit.symbol)))
    }

}
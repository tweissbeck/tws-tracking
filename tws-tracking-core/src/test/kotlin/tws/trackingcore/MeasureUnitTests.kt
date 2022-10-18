package tws.trackingcore


import com.fasterxml.jackson.databind.ObjectMapper
import org.hamcrest.Matchers
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import tws.trackingcore.controller.model.MeasureUnitDto
import tws.trackingcore.rule.BeforeClassBDRule


@ExtendWith(BeforeClassBDRule::class)
@SpringBootTest
@AutoConfigureMockMvc(printOnlyOnFailure = false, print = MockMvcPrint.DEFAULT)
@Sql("/reset-data.sql")
class MeasureUnitTests(
    @Autowired val mvc: MockMvc,
    @Autowired val objectMapper: ObjectMapper
) {
    @Test
    @Order(1)
    fun testGet() {
        mvc.perform(
            get("/unit").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk)
            .andExpect(jsonPath("[0].id", Matchers.`is`(1)))
            .andExpect(jsonPath("[0].name", Matchers.`is`("Kilomètre")))
            .andExpect(jsonPath("[0].symbol", Matchers.`is`("km")))
            .andExpect(jsonPath("[1].id", Matchers.`is`(2)))
            .andExpect(jsonPath("[1].name", Matchers.`is`("Watt")))
            .andExpect(jsonPath("[1].symbol", Matchers.`is`("w")))
    }

    @Order(2)
    @Test
    fun testSaveMeasureUnit() {
        val name = "TestABC&"
        val symbol = "€"
        mvc.perform(
            post("/unit").content(objectMapper.writeValueAsBytes(MeasureUnitDto(name = name, symbol = symbol)))
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk)
            .andExpect(jsonPath("id", Matchers.`is`(3)))
            .andExpect(jsonPath("name", Matchers.`is`(name)))
            .andExpect(jsonPath("symbol", Matchers.`is`(symbol)))

        mvc.perform(
            get("/unit").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk)
            .andExpect(jsonPath("[2].id", Matchers.`is`(3)))
            .andExpect(jsonPath("[2].name", Matchers.`is`(name)))
            .andExpect(jsonPath("[2].symbol", Matchers.`is`(symbol)))
    }


}
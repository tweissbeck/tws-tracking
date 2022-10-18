package tws.trackingcore.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import tws.trackingcore.controller.model.CounterDto
import tws.trackingcore.controller.model.CounterHistoDto
import tws.trackingcore.service.CounterService
import javax.validation.Valid
import javax.websocket.server.PathParam


@RestController
@RequestMapping(path = ["counter"])
class CounterController(@Autowired val counterService: CounterService) {

    @GetMapping(path = ["/", ""])
    fun findAll(pageable: Pageable): ResponseEntity<Page<CounterDto>> {
        return ResponseEntity.ok(counterService.findAll(pageable))
    }

    @PostMapping(path = ["/",""])
    fun save(@Valid @RequestBody dto : CounterDto): ResponseEntity<CounterDto>{
        return ResponseEntity.ok(counterService.save(dto))
    }

    /**
     * For one given counter, give its history
     */
    @GetMapping(value = ["/{id}/values", "/{id}/values/"])
    fun getData(@PathVariable(value = "id") id: Long): ResponseEntity<CounterHistoDto> {
       return ResponseEntity.ok(counterService.findWithHisto(id))
    }
}
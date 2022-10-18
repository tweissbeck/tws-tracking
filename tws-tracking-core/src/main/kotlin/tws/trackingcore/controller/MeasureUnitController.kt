package tws.trackingcore.controller


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import tws.trackingcore.controller.model.MeasureUnitDto
import tws.trackingcore.service.MeasureUnitService
import javax.validation.Valid

@Controller
@RequestMapping(value = ["/unit"])
class MeasureUnitController(@Autowired val measureUnitService: MeasureUnitService) {


    @GetMapping(value = ["/", ""])
    fun getAll(): ResponseEntity<List<MeasureUnitDto>> {
        return ResponseEntity(measureUnitService.findAll(), HttpStatus.OK)
    }

    @PostMapping(value = ["/", ""])
    fun save(@Valid @RequestBody measureUnitDto: MeasureUnitDto): ResponseEntity<MeasureUnitDto> {
        return ResponseEntity(measureUnitService.save(measureUnitDto), HttpStatus.OK)
    }


}
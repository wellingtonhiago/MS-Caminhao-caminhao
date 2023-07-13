package br.com.inteligate.truck.controller

import br.com.inteligate.truck.DTO.TruckDTO
import br.com.inteligate.truck.model.Truck
import br.com.inteligate.truck.repository.TruckRepository
import br.com.inteligate.truck.service.TruckService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
@RestController
@RequestMapping("/trucks")
class controller(
    @Autowired
    private val truckService: TruckService,
) {

    @PostMapping
    fun createTruck(@Valid @RequestBody truckDto: TruckDTO): ResponseEntity<Truck> {
        val truck = truckService.createTruck(truckDto)
        return ResponseEntity.ok(truck)
    }

    @GetMapping
    fun getAllTrucks(): ResponseEntity<List<Truck>> = ResponseEntity.ok(truckService.getAllTrucks())

    @GetMapping("/{id}")
    fun getTruckById(@PathVariable("id") truckId: String): ResponseEntity<Truck> {
        val truck = truckService.getTruckById(truckId)
        return ResponseEntity.ok(truck)
    }

    @PutMapping("/{id}")
    fun updateTruck(@PathVariable("id") truckId: String, @Valid @RequestBody truckDto: TruckDTO): ResponseEntity<Any> {
        val truck = truckService.updateTruck(truckId, truckDto)
        return ResponseEntity.ok(truck)
    }

    @DeleteMapping("/{id}")
    fun deleteTruck(@PathVariable("id") truckId: String): ResponseEntity<Any> {
        val truck = truckService.deleteTruck(truckId)
        return ResponseEntity.ok(truck)
    }

}


package br.com.inteligate.truck.service

import br.com.inteligate.truck.DTO.TruckDTO
import br.com.inteligate.truck.model.Truck
import br.com.inteligate.truck.repository.TruckRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TruckService(
    private val truckRepository: TruckRepository
) {
    @Transactional
    fun createTruck(truckDTO: TruckDTO): Truck {
        val truck = Truck(
            placa = truckDTO.placa,
            capacidade = truckDTO.capacidade,
            carga = truckDTO.carga,
            acesso = truckDTO.acesso,
            pesoCaminhao = truckDTO.pesoCaminhao,
            pesoCarga = truckDTO.pesoCarga
        )
        return truckRepository.save(truck)
    }

    @Transactional(readOnly = true)
    fun getAllTrucks(): List<Truck> = truckRepository.findAll()


    @Transactional(readOnly = true)
    fun getTruckById(id: String): Truck? =
        truckRepository.findById(id)
            .orElseThrow{ RuntimeException("Caminhão não existente com esse id: $id") }

    @Transactional
    fun updateTruck(id: String, truckDTO: TruckDTO): Any {
        val truck = truckRepository.findById(id)
            .orElseThrow { RuntimeException("Caminhão não existente com esse id: $id") }

        truck.placa = truckDTO.placa
        truck.capacidade = truckDTO.capacidade
        truck.carga = truckDTO.carga
        truck.acesso = truckDTO.acesso
        truck.pesoCaminhao = truckDTO.pesoCaminhao
        truck.pesoCarga = truckDTO.pesoCarga

        return truckRepository.save(truck)
    }

    @Transactional
    fun deleteTruck(id: String): Any {
        val truck = getTruckById(id) ?: return RuntimeException("Caminhão não existente com esse id: $id")
        truckRepository.delete(truck)
        return "Caminhão deletado com sucesso"
    }


}
package br.com.inteligate.truck.repository

import br.com.inteligate.truck.model.Truck
import org.springframework.data.mongodb.repository.MongoRepository

interface TruckRepository : MongoRepository<Truck, String> {

}
package br.com.inteligate.truck.DTO

data class TruckDTO(
    val placa: String,
    val capacidade: Double?,
    val carga: Boolean,
    val acesso: Boolean,

    val pesoCaminhao: Double,
    val pesoCarga: Double
)
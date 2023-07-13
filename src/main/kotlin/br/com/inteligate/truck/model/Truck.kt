package br.com.inteligate.truck.model

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive
import org.jetbrains.annotations.NotNull
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "caminhao")
data class Truck(

    @Id
    @field:NotNull("Placa é obrigatória")
    @field:NotBlank(message = "Placa é obrigatória")
    var placa: String,

    @field:Positive(message = "Capacidade deve ser maior que zero")
    var capacidade: Double?,

    var carga: Boolean = false,
    var acesso: Boolean = true,

    var pesoCaminhao: Double = 0.0,
    var pesoCarga: Double = 0.0,

)
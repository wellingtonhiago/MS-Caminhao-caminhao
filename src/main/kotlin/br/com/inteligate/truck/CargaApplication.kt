package br.com.inteligate.truck

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CaminhaoApplication

fun main(args: Array<String>) {
	runApplication<CaminhaoApplication>(*args)
}

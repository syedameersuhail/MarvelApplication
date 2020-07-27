package com.example.demo

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.client.RestTemplate
import java.time.Instant
open class CharacterService {

    //var finalCharacters = mutableMapOf<String, Int>()
    var restTemplate = RestTemplate()
    val logger : Logger =LoggerFactory.getLogger(CharacterService::class.java)

    /*fun getfinalCharacters () : MutableMap<String, Int> {
        return finalCharacters
    }*/

    fun getAvengerCharacters() {
        var start: Instant = Instant.now()
        println("Start of avengers $start")
        var avengerCharacter: GameCharacter? = restTemplate.getForObject("http://www.mocky.io/v2/5ecfd5dc3200006200e3d64b", GameCharacter::class.java)
        var charts: Array<Characters>? = avengerCharacter?.getCharacter()
        if (charts != null) {
            var mts = MyThread(charts)
            mts.start()
        }
        var end: Instant = Instant.now()
        println("end of avengers $end")
    }

    fun getAntiHeros() {
        val anti = Array<Characters>(6) { Characters("", 0) }
        val start: Instant = Instant.now()
        println("Start of AntiHeros $start")
        anti[0] = Characters("Mandrin", 70)
        anti[1] = Characters("Thanos", 80)
        anti[2] = Characters("Galactus", 95)
        anti[3] = Characters("Hela", 75)
        anti[4] = Characters("Ego", 54)
        anti[5] = Characters("Dr. Doom", 78)
        if (anti != null) {
            var mta = MyThread(anti)
            mta.start()
        }
        val end: Instant = Instant.now()
        println("end of AntiHero $end")
    }

    fun getMutants() {
        val start: Instant = Instant.now()
        println("Start of mutant $start")
        val mutants: GameCharacter? = restTemplate.getForObject("http://www.mocky.io/v2/5ecfd6473200009dc1e3d64e", GameCharacter::class.java)
        var mutant: Array<Characters>? = mutants?.getCharacter()
        if (mutant != null) {
            var mtm = MyThread(mutant)
            mtm.start()
        }
        var end: Instant = Instant.now()
        println("end of mutants $end")
    }
}

class MyThread(var charactersToStore: Array<Characters>) : Thread() {
    var storechar = StoreCharacters()
    override fun run() {
        synchronized(storechar) {
            storechar.addCharacter(charactersToStore)
        }
    }
}
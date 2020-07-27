package com.example.demo

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant
import java.util.concurrent.CompletableFuture

@RestController
@RequestMapping("/Marvel")
class Controller {

    var characterService = CharacterService()
    var storeCharacters = StoreCharacters()

    @RequestMapping("/home")
    fun LoadCharacters(): String {
        var start: Instant =Instant.now()
        var st : String
        println("Start of request $start")
        CompletableFuture.runAsync { characterService.getAvengerCharacters() }
        CompletableFuture.supplyAsync { characterService.getAntiHeros() }
        CompletableFuture.runAsync { characterService.getMutants() }
        var end: Instant? =Instant.now()
        println("End of request $end")
        return "Marvel"
    }

    @RequestMapping("/home/{name}")
    fun getPower(@PathVariable name: String): String {
        return storeCharacters.getPowerLevel(name)
    }

}
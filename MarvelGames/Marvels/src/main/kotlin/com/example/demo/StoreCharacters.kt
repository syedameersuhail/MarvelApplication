package com.example.demo

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class StoreCharacters {
    var finalCharacters = mutableMapOf<String, Int>()
    val log : Logger = LoggerFactory.getLogger(StoreCharacters::class.java)

    /*
 @args : Array of GameCharacters
 @return : nothing
 * */
    fun addCharacter(Characters: Array<Characters>) {
        for (character in Characters) {
            println(" Characters being stored ${character.name}")
            if (finalCharacters.size < 16) {
                finalCharacters.put(character.name.toString(), character.max_power!!)
                log.info(finalCharacters.toString())
            } else {
                var minPower = finalCharacters.minBy { it.value }
                var characterWithMinPower = minPower?.key
                finalCharacters.remove(characterWithMinPower)
                finalCharacters.put(character.name.toString(), character.max_power!!)
            }
        }
        println("final character in iterator ${finalCharacters.toString()}")
    }

    /*
@args : name of game character
@return : Power level of character
* */
    fun getPowerLevel(name: String): String {
        val power: String
        println("power of wt ? $name")
        println("final character at get power ${finalCharacters.toString()}")
        if (finalCharacters.contains(name)) {
            power = finalCharacters[name].toString()
        } else {
            power = "Character not found"
        }
        return power
    }

}
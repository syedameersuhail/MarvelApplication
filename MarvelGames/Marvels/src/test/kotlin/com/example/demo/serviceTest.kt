package com.example.demo

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

internal class serviceTest {

    var chartService = mock(CharacterService::class.java)
    var expectedMap = mutableMapOf<String, Int>()
    var restTemplate = RestTemplate()
    var characterService = CharacterService()

    val avengerCharacters = Array<Characters>(6) { Characters("", 0) }
    val antiHeroscharacters = Array<Characters>(6) { Characters("", 0) }
    val Mutanscharacters = Array<Characters>(6) { Characters("", 0) }

    fun loadAvengerCharacters() {
        avengerCharacters[0] = Characters("Iron man", 60)
        avengerCharacters[1] = Characters("Captain America", 68)
        avengerCharacters[2] = Characters("Spider man", 58)
        avengerCharacters[3] = Characters("B;ack Panther", 68)
        avengerCharacters[4] = Characters("Vision", 50)
        avengerCharacters[5] = Characters("Hawk eye", 30)
        }

    fun loadAntiHeros() {
        antiHeroscharacters[0] = Characters("Mandrin", 70)
        antiHeroscharacters[1] = Characters("Thanos", 80)
        antiHeroscharacters[2] = Characters("Galactus", 95)
        antiHeroscharacters[3] = Characters("Hela", 75)
        antiHeroscharacters[4] = Characters("Ego", 50)
        antiHeroscharacters[5] = Characters("Dr. Doom", 78)
    }

    fun loadMutants() {
        Mutanscharacters[0] = Characters("Apocalypse", 80)
        Mutanscharacters[1] = Characters("Professor", 75)
        Mutanscharacters[2] = Characters("Dark", 90)
        Mutanscharacters[3] = Characters("Magneto", 78)
        Mutanscharacters[4] = Characters("Wolverine", 64)
        Mutanscharacters[5] = Characters("Mystique", 66)
    }

    fun loadFinalMap() {
       /* expectedMap.put("Iron man", 0)
        expectedMap.put("Captain America", 68)
        expectedMap.put("Spider man", 58)
        expectedMap.put("B;ack Panther", 68)*/
        expectedMap.put("Mandrin", 70)
        expectedMap.put("Thanos", 80)
        expectedMap.put("Galactus", 95)
        expectedMap.put("Hela", 75)
        expectedMap.put("Ego", 54)
        expectedMap.put("Dr. Doom", 78)
       /* expectedMap.put("Apocalypse", 80)
        expectedMap.put("Professor", 75)
        expectedMap.put("Dark", 90)
        expectedMap.put("Magneto", 78)
        expectedMap.put("Wolverine", 64)
        expectedMap.put("Mystique", 66)*/
    }

    @Test
    fun myService() {
        loadAvengerCharacters()
        loadAntiHeros()
        loadMutants()
        loadFinalMap()
       /* var avengerGameCharacter = GameCharacter("Avengers", avengerCharacters)
        `when`(restTemplate.getForObject("http://www.mocky.io/v2/5ecfd5dc3200006200e3d64b", GameCharacter::class.java)).thenReturn(avengerGameCharacter)

        var mutantsGameCharacter = GameCharacter("Avengers", Mutanscharacters)
        `when`(restTemplate.getForObject("http://www.mocky.io/v2/5ecfd6473200009dc1e3d64e", GameCharacter::class.java)).thenReturn(mutantsGameCharacter)
*/
      /*  var AntiHeroGameCharacter = GameCharacter("Avengers", antiHeroscharacters)
        `when`(restTemplate.getForObject("http://www.mocky.io/v2/5ecfd6473200009dc1e3d64e", GameCharacter::class.java)).thenReturn(AntiHeroGameCharacter)
*/
        //chartService.getAvengerCharacters()
        chartService.getAntiHeros()
        //chartService.getMutants()
//        assertSame(expectedMap, characterService.getfinalCharacters())
    }

    @Test
    fun getMutants() {
    }

    @Test
    fun getPowerLevel() {
    }
}
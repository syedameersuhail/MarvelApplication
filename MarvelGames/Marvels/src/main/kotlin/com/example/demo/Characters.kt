package com.example.demo

class Characters(name: String, max_power: Int) {
    var name: String? = null
    var max_power: Int? = 0

    init {
        this.name = name
        this.max_power = max_power
    }

    override fun toString(): String {
        return "Characters (name=$name, quote=$max_power)"
    }

}

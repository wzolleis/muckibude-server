package de.wz.muckibude.exercises

class Geraet() {
    lateinit var nummer : String

    fun nummer(init: String.() -> Unit) : Geraet {
        nummer.init()
        return this;
    }
}
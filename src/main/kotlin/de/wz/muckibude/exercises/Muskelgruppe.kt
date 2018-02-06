package de.wz.muckibude.exercises

class Muskelgruppe() {
    lateinit var name : String

    fun name(init: String.() -> Unit) : Muskelgruppe {
        this.name.init()
        return this;
    }

    override fun toString(): String {
        return "Muskelgruppe(name='$name')"
    }


}
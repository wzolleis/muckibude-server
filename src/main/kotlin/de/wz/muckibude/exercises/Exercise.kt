package de.wz.muckibude.exercises

@Suppress("unused")
class Exercise() {
    lateinit var id  : String
    lateinit var name : String
    lateinit var muskelGruppe: Muskelgruppe
    lateinit var geraet : Geraet
    lateinit var beschreibung: String


    fun id(init: String.() -> Unit) : Exercise {
        this.id.init()
        return this
    }

    fun name(init: String.() -> Unit) : Exercise {
        this.name.init()
        return this
    }

    fun geraet(init: Geraet.() -> Unit) : Exercise {
        this.geraet = Geraet()
        this.geraet.init()
        return this
    }

    fun muskelGruppe(init: Muskelgruppe.() -> Unit) : Exercise {
        this.muskelGruppe = Muskelgruppe()
        this.muskelGruppe.init()
        return this
    }

    fun beschreibung(init : String.() -> Unit) : Exercise {
        this.beschreibung.init()
        return this
    }

    override fun toString(): String {
        return "Exercise(id='$id', name='$name', muskelGruppe=$muskelGruppe)"
    }


}

fun exercise(init: Exercise.() -> Unit): Exercise {
    val Exercise = Exercise()
    Exercise.init()
    return Exercise
}
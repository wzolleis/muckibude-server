package de.wz.muckibude.exercises


fun exercise(init: Exercise.() -> Unit): Exercise {
    val Exercise = Exercise()
    Exercise.init()
    return Exercise
}

@Suppress("unused")
class Exercise() {
    lateinit var id  : String
    lateinit var name : String
    lateinit var muskelGruppe: String
    lateinit var geraet : String
    lateinit var beschreibung: String


    fun id(init: String.() -> Unit) : Exercise {
        this.id.init()
        return this
    }

    fun name(init: String.() -> Unit) : Exercise {
        this.name.init()
        return this
    }

    fun geraet(init: String.() -> Unit) : Exercise {
        this.geraet.init()
        return this
    }

    fun muskelGruppe(init: String.() -> Unit) : Exercise {
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
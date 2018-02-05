package de.wz.muckibude.exercises

data class Exercise(val id : String,
                    val name : String,
                    val geraet : String,
                    val muskelgruppe : String,
                    val beschreibung : String = "") {
}
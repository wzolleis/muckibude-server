package de.wz.muckibude.exercises

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ExerciseTest {


    @Test
    fun testUebungBuilder() {

        val uebung = exercise {
            muskelGruppe = "Brust"
            id = "2"
            name = "Bankdrücken"
            geraet = "6"

        }

        println("uebung ${uebung}")
        assertThat(uebung.muskelGruppe).isEqualTo("Brust")
        assertThat(uebung.geraet).isEqualTo("6")
        assertThat(uebung.id).isEqualTo("2")
        assertThat(uebung.name).isEqualTo("Bankdrücken")
    }
}

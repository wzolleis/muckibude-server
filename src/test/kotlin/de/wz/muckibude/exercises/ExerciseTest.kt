package de.wz.muckibude.exercises

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ExerciseTest {


    @Test
    fun testUebungBuilder() {

        val uebung = exercise {
            id = "2"
            name = "Bankdrücken"
            muskelGruppe {
                name = "Brust"
            }
            geraet {
                nummer = "6"
            }
        }


        println("uebung ${uebung}")
        assertThat(uebung.muskelGruppe).isNotNull()
        assertThat(uebung.muskelGruppe.name).isEqualTo("Brust")
        assertThat(uebung.geraet).isNotNull()
        assertThat(uebung.geraet.nummer).isEqualTo("6")
        assertThat(uebung.id).isEqualTo("2")
        assertThat(uebung.name).isEqualTo("Bankdrücken")
    }
}

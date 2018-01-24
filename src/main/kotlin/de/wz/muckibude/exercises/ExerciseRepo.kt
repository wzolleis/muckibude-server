package de.wz.muckibude.exercises;

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Query
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class ExerciseRepo() {
    object ExerciseTable : Table("Uebungen") {
        val id: Column<String> = varchar("id", 1024).primaryKey()
        val name: Column<String> = varchar("name", 40)
        val geraet: Column<String> = varchar("geraet", 255)
        val muskelgruppe: Column<String> = varchar("muskelgruppe", 255)
        val beschreibung: Column<String> = varchar("beschreibung", 1024)
    }


    fun findAll(): Set<Exercise> {
        return transaction {
            // DSL/DAO operations go here
            val query: Query = ExerciseTable.selectAll()
            query.forEach { println(it) }


            val ex1 = Exercise("1", "A")
            val ex2 = Exercise("2", "B")
            println("default daten")
            setOf(ex1, ex2)
        }

        fun insert(exercise : Exercise) {

        }

    }

}
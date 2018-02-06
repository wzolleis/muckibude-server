package de.wz.muckibude.exercises;

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class ExerciseRepo() {
    object ExerciseTable : Table("Uebungen") {
        val id: Column<String> = varchar("id", 1024).primaryKey()
        val name: Column<String> = varchar("name", 40)
        val geraet: Column<String> = varchar("geraet", 255)
        val muskelgruppe: Column<String> = varchar("muskelgruppe", 255)
        val beschreibung: Column<String> = varchar("beschreibung", 1024)
    }

    object ExcerciseAssembler {
        fun assemble(it: ResultRow): Exercise {
            return exercise {
                val beschreibungDb : String? = it[ExerciseTable.beschreibung]
                val muskelgruppeDb : String? = it[ExerciseTable.muskelgruppe]
                val geraetDb : String? = it[ExerciseTable.geraet]

                name = it[ExerciseTable.name]
                id = it[ExerciseTable.id]

                beschreibung = beschreibungDb ?: ""
                muskelGruppe {
                    name = muskelgruppeDb ?: ""
                }
                geraet {
                    nummer = geraetDb ?: ""
                }
            }
        }
    }


    fun findAll(): Set<Exercise> {
        return transaction {
            // DSL/DAO operations go here
            ExerciseTable.selectAll()
                    .map { ExcerciseAssembler.assemble(it) }
                    .toSet()
        }
    }

    fun findById(id: String): Exercise {
        return transaction {
            logger.addLogger(StdOutSqlLogger)
            ExerciseTable.select({ ExerciseTable.id eq id })
                    .map { ExcerciseAssembler.assemble(it) }
                    .first()
        }
    }

    fun insert(exercise: Exercise) {
        return transaction {
            ExerciseTable.insert {
                it[id] = exercise.id
                it[name] = exercise.name
            }
        }

    }

}
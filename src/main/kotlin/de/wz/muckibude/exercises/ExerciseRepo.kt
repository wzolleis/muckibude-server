package de.wz.muckibude.exercises;

class ExerciseRepo() {

    fun findAll(): Set<Exercise> {
//        return transaction {
//            // DSL/DAO operations go here
//            val ex1 = Exercise("1", "A")
//            val ex2 = Exercise("2", "B")
//            println("default daten")
//            setOf(ex1, ex2)
//        }

        val ex1 = Exercise("1", "A")
            val ex2 = Exercise("2", "B")
            println("default daten")
            return setOf(ex1, ex2)
    }

}
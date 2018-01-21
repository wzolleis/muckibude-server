package de.wz.muckibude.exercises;


class FindExerciseUseCase(val repo : ExerciseRepo) {
    fun findById(id : String) : Exercise {
        return Exercise(id, "Bankdrücken")
    }

    fun findAll() : Set<Exercise> {
        val ex1 = Exercise("1", "A")
        val ex2 = Exercise("2", "B")
        return setOf(ex1, ex2)
    }
}
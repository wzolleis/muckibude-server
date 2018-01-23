package de.wz.muckibude.exercises;


class FindExerciseUseCase(val repo : ExerciseRepo) {
    fun findById(id : String) : Exercise {
        return Exercise(id, "Bankdrücken")
    }

    fun findAll() : Set<Exercise> {
        return repo.findAll()
    }
}
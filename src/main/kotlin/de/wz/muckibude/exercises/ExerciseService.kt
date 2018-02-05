package de.wz.muckibude.exercises;


class ExerciseService(val repo : ExerciseRepo) {
    fun findById(id : String) : Exercise {
        return repo.findById(id)
    }

    fun findAll() : Set<Exercise> {
        return repo.findAll()
    }
}
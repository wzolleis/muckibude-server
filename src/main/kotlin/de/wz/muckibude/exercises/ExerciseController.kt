package de.wz.muckibude.exercises;

class ExerciseController(val findExerciseUseCase: FindExerciseUseCase) {

    fun findAll(): Set<Exercise> {
        return findExerciseUseCase.findAll()
    }
}
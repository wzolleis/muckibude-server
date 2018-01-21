package de.wz.muckibude.exercises;

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ExerciseController(val findExerciseUseCase: FindExerciseUseCase) {

    @RequestMapping("/rs/exercises")
    fun findAll(): Set<Exercise> {
        return findExerciseUseCase.findAll()
    }
}
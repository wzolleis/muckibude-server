package de.wz.muckibude.exercises

import io.javalin.Context

class ExerciseController(private val exerciseService: ExerciseService) {
    fun findAll(ctx: Context) {
        val exercises = exerciseService.findAll()
        ctx.charset("utf-8")
        ctx.json(exercises)
    }

    fun insert(exercise : Exercise) {
        exerciseService.insert(exercise);
    }
}
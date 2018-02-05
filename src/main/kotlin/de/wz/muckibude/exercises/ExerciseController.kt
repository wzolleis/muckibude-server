package de.wz.muckibude.exercises

import io.javalin.Context

class ExerciseController(private val exerciseService: ExerciseService) {
    fun findAll(ctx: Context) {
        val exercises = exerciseService.findAll()
        ctx.json(exercises)
    }
}
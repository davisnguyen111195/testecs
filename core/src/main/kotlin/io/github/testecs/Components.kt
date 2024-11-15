package io.github.testecs

import com.badlogic.ashley.core.Component

data class PositionComponent(var x: Float = 0f, var y: Float = 0f) : Component

data class VelocityComponent(var xSpeed: Float = 0f, var ySpeed: Float = 0f) :Component

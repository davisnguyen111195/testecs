package io.github.testecs

import com.badlogic.ashley.core.Entity

fun createMovingEntity() : Entity {
    return Entity().apply {
        add(PositionComponent(100f, 100f))
        add(VelocityComponent(500f, 600f))
    }
}

package io.github.testecs

import com.badlogic.ashley.core.ComponentMapper
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.Family
import com.badlogic.ashley.systems.IteratingSystem
import com.badlogic.gdx.Gdx

class MovementSystem : IteratingSystem(
    Family.all(PositionComponent::class.java, VelocityComponent::class.java).get()
) {
    private val positionMapper = ComponentMapper.getFor(PositionComponent::class.java)
    private val velocityMapper = ComponentMapper.getFor(VelocityComponent::class.java)

    override fun processEntity(entity: Entity?, deltaTime: Float) {
        val position = positionMapper[entity]
        val velocity = velocityMapper[entity]

        position.x += velocity.xSpeed * deltaTime
        position.y += velocity.ySpeed * deltaTime

        if (position.x < 0 || position.x > Gdx.graphics.width) velocity.xSpeed = -velocity.xSpeed
        if (position.y < 0 || position.y > Gdx.graphics.height) velocity.ySpeed = -velocity.ySpeed
    }
}

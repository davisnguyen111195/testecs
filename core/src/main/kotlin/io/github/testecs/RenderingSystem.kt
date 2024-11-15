package io.github.testecs

import com.badlogic.ashley.core.ComponentMapper
import com.badlogic.ashley.core.EntitySystem
import com.badlogic.ashley.core.Family
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer

class RenderingSystem(private val shapeRenderer: ShapeRenderer) : EntitySystem() {
    private val positionMapper = ComponentMapper.getFor(PositionComponent::class.java)

    override fun update(deltaTime: Float) {
        super.update(deltaTime)

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled)
        shapeRenderer.color = Color.RED

        engine.getEntitiesFor(Family.all(PositionComponent::class.java).get()).forEach { entity ->
            val position = positionMapper[entity]
            shapeRenderer.circle(position.x, position.y, 10f)
        }

        shapeRenderer.end()
    }
}

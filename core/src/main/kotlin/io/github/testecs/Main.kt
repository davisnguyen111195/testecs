package io.github.testecs

import com.badlogic.ashley.core.Engine
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.glutils.ShapeRenderer

class Main : ApplicationAdapter(){

    private lateinit var engine : Engine
    private lateinit var shapeRenderer: ShapeRenderer

    override fun create() {
        super.create()
        shapeRenderer = ShapeRenderer()
        engine = Engine()

        engine.addSystem(MovementSystem())
        engine.addSystem(RenderingSystem(shapeRenderer))

        engine.addEntity(createMovingEntity())
    }

    override fun resize(width: Int, height: Int) {
        super.resize(width, height)
    }

    override fun render() {
        super.render()
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        engine.update(Gdx.graphics.deltaTime)
    }

    override fun pause() {
        super.pause()
    }

    override fun resume() {
        super.resume()
    }

    override fun dispose() {
        super.dispose()
        shapeRenderer.dispose()
    }
}

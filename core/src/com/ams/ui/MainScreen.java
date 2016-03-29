package com.ams.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class MainScreen implements InputProcessor, Screen {

	OrthographicCamera camera = new OrthographicCamera();

	// camera inertia
	float cameraDX = 0, cameraDY = 0;
	
	// camera constants
	final int CAMERA_SCROLL_AMOUNT = 6;
	final float CAMERA_ZOOM_AMOUNT = 1.1f;
	
	// input
	InputMultiplexer inputs = new InputMultiplexer();
	
	// UI
	Stage stage = new Stage();
        Table table = new Table();
        
        Skin skin;

	public MainScreen() {

          camera.setToOrtho(false);
          camera.translate(0,0);

          inputs.addProcessor(stage);
          inputs.addProcessor(this);

          Gdx.input.setInputProcessor(inputs);

          Texture spriteTex = new Texture(Gdx.files.internal("img/star_background.png"));
          spriteTex.setFilter(TextureFilter.Linear, TextureFilter.Linear);
          TextureRegion region = new TextureRegion(spriteTex, 0, 0, spriteTex.getWidth(), spriteTex.getHeight());

          setupStage();
	}
	
	public void setupStage() {
          Skin skin = new Skin(Gdx.files.internal("data/uiskin.json"));
		
          table.add(new Label("hello1", skin));
          table.row();
          table.add(new Label("hello2", skin));
          table.row();
          table.add(new Label("hello3", skin));
          table.row();
          table.add(new Label("hello4", skin));
          table.row();
          table.bottom().left();
          
          stage.addActor(table);
	}
	
	public void render(float delta) {		
          Gdx.gl.glClearColor(0, 0, 0, 1);
          Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

          Vector3 v0 = new Vector3(0,0,0);
          Vector3 v1 = new Vector3(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 0);
          camera.unproject(v0);
          camera.unproject(v1);

          camera.translate(this.cameraDX, this.cameraDY, 0);
          camera.update();

          stage.act(delta);
          stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		//stage.setViewport(width, height, true);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
        }

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}

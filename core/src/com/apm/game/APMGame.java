package com.apm.game;

import com.apm.character.Character;
import com.apm.combat.CombatInstance;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Arrays;

public class APMGame extends ApplicationAdapter {

  SpriteBatch batch;
  Character character;
  CombatInstance mainCombat;

  @Override
  public void create() {
    this.mainCombat = new CombatInstance(
            Arrays.asList(new Character(), new Character()));

  }

  @Override
  public void render() {
    Gdx.gl.glClearColor(1, 1, 1, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
  }
}

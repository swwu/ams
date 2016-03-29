package com.ams.game;

import com.ams.character.Character;
import com.ams.combat.CombatInstance;
import com.ams.ui.MainScreen;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Arrays;

public class AMSGame extends Game {

  MainScreen mainScreen;
  
  SpriteBatch batch;
  Character character;
  CombatInstance mainCombat;

  @Override
  public void create() {
    this.mainCombat = new CombatInstance(
            Arrays.asList(new Character(), new Character()));

    mainScreen = new MainScreen();
    setScreen(mainScreen);
  }
}

package com.ams.game;

import com.ams.character.Entity;
import com.ams.tactical.TacticalInstance;
import com.ams.ui.MainScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Arrays;

public class AMSGame extends Game {

  MainScreen mainScreen;
  
  SpriteBatch batch;
  Entity character;
  TacticalInstance mainCombat;

  @Override
  public void create() {
    this.mainCombat = new TacticalInstance(
            Arrays.asList(new Entity("person 1"), new Entity("person 2")));
    while (this.mainCombat.isActive()) {
      this.mainCombat.nextAction();
    }

    mainScreen = new MainScreen();
    setScreen(mainScreen);
  }
}

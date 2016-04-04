/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ams.tactical.ai;

import com.ams.character.Entity;
import com.ams.tactical.BaseTacticalAction;
import com.ams.tactical.TacticalInstance;

/**
 *
 * @author Steven
 */
public interface BaseTacticalAI {
  public abstract BaseTacticalAction nextAction(Entity me, TacticalInstance instance);
} 

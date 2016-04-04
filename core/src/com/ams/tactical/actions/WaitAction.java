/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ams.tactical.actions;

import com.ams.character.Entity;
import com.ams.tactical.TacticalInstance;
import com.ams.tactical.BaseTacticalAction;

/**
 *
 * @author swwu
 */
public class WaitAction extends BaseTacticalAction {
  public WaitAction(Entity actor, double startsAt, double completesAt) {
    super(actor, startsAt, completesAt);
  }
  
  @Override
  public void perform(TacticalInstance c) {
    System.out.println(this.getActor().getName() + ": waiting");
  }

}

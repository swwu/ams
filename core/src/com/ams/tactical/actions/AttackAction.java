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
 * @author Steven
 */
public class AttackAction extends BaseTacticalAction {

  Entity target;

  /**
   *
   * @param actor
   * @param target
   * @param startsAt
   * @param completesAt
   */
  public AttackAction(Entity actor, Entity target, double startsAt, double completesAt) {
    super(actor, startsAt, completesAt);
    this.target = target;
  }
  
  @Override
  public void perform(TacticalInstance c) {
    System.out.println(this.getActor().getName() + ": target "
            + this.target.getName() + " has " + this.target.getCurrentHealth());
    this.target.modifyCurrentHealth(-10);
  }


}

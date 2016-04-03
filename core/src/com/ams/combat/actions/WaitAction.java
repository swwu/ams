/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ams.combat.actions;

import com.ams.character.Entity;
import com.ams.combat.CombatInstance;
import com.ams.combat.BaseCombatAction;

/**
 *
 * @author swwu
 */
public class WaitAction extends BaseCombatAction {
  public WaitAction(Entity actor, double startsAt, double completesAt) {
    super(actor, startsAt, completesAt);
  }
  
  @Override
  public void perform(CombatInstance c) {
    System.out.println(this.getActor().getName() + ": waiting");
  }

}

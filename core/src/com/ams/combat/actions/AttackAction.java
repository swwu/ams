/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ams.combat.actions;

import com.ams.character.Entity;
import com.ams.combat.CombatInstance;
import com.ams.combat.ICombatAction;

/**
 *
 * @author Steven
 */
public class AttackAction implements ICombatAction {

  double completesAt; // when the action is scheduled to finish
  Entity actor;
  Entity target;

  public AttackAction(Entity actor, Entity target, double completesAt) {
    this.actor = actor;
    this.target = target;
    this.completesAt = completesAt;
  }
  
  /**
   * @return the completesAt
   */
  @Override
  public double getCompletesAt() {
    return completesAt;
  }

  /**
   * @param completesAt the completesAt to set
   */
  @Override
  public void setCompletesAt(double completesAt) {
    this.completesAt = completesAt;
  }

  @Override
  public Entity getActor() {
    return this.actor;
  }

  @Override
  public void setActor(Entity actor) {
    this.actor = actor;
  }
  
  @Override
  public void perform(CombatInstance c) {
    System.out.println(this.actor.getName() + ": target " + this.target.getName() + " has " + this.target.getCurrentHealth());
    this.target.setCurrentHealth(this.target.getCurrentHealth() - 10);
  }

}

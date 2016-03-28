/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apm.combat.actions;

import com.apm.combat.ICombatAction;

/**
 *
 * @author Steven
 */
public class AttackAction implements ICombatAction {

  double completesAt; // when the action is scheduled to finish
  Character actor;

  public AttackAction(Character actor, Character target) {
    this.actor = actor;
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
  public Character getActor() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void setActor(Character actor) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
  @Override
  public void perform() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}

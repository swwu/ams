/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ams.combat;

import com.ams.character.Entity;

/**
 *
 * @author Steven
 */
public abstract class BaseCombatAction {
  
  double startsAt; // when the action was scheduled to start
  double completesAt; // when the action is scheduled to finish
  Entity actor;

  public BaseCombatAction(Entity actor, double startsAt, double completesAt) {
    this.actor = actor;
    this.startsAt = startsAt;
    this.completesAt = completesAt;
  }
  
  // when the action began. This is generally going to be only used for
  // bookkeeping, but it's possible an action depends on its start as well as
  // ending time.
  public double getStartsAt() {
    return startsAt;
  }

  public void setStartsAt(double startsAt) {
    this.startsAt = startsAt;
  }

  // this is the time this action is expected to complete at. This value can be
  // changed by external influence
  public double getCompletesAt() {
    return completesAt;
  }

  public void setCompletesAt(double completesAt) {
    this.completesAt = completesAt;
  }
  
  // the "actor" is the character performing this action
  public Entity getActor() {
    return this.actor;
  }

  public void setActor(Entity actor) {
    this.actor = actor;
  }
  
  public void perform(CombatInstance c) {
    
  }
}

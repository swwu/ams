/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apm.combat;

/**
 *
 * @author Steven
 */
public interface ICombatAction {
  
  // the "actor" is the character performing this action
  public abstract Character getActor();
  public abstract void setActor(Character actor);
  
  // this is the time this action is expected to complete at. This value can be
  // changed by external influence
  public abstract double getCompletesAt();
  public abstract void setCompletesAt(double completesAt);
  
  public abstract void perform();
}

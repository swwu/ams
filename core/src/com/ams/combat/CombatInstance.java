/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ams.combat;

import com.ams.combat.actions.AttackAction;
import com.ams.character.Entity;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Represents a specific combat event. Combat mechanics are only simulated
 * inside of a CombatInstance.
 *
 * @author Steven
 */
public class CombatInstance {
  // the current time that the combatinstance is at
  private double localTime;
  
  // some intrinsic properties of the combat instance

  float locationSize; // how big the instance is. "In" m^2.
  float locationClutter; // how cluttered the location is. Value on [0,1].

  // the characters in the instance
  List<Entity> entities;
  
  // plans made by characters in the instance
  Map<Entity, ICombatAction> plans;

  // all actions that are currently "in-flight" inside this combat instance.
  PriorityQueue<ICombatAction> actionOrdering;

  // this comparator is used to sort CombatActions by their completion time
  public static Comparator<ICombatAction> CombatActionTimeOrder = (ICombatAction o1, ICombatAction o2) -> {
    double delta = o2.getCompletesAt() - o1.getCompletesAt();
    return (delta < 0) ? 1
            : (delta == 0) ? 0
            : -1;
  };

  public CombatInstance(List<Entity> characters) {
    this.localTime = 0.0;
    
    this.locationSize = 10.0f;
    this.locationClutter = 0.1f;

    this.entities = characters;
    this.plans = new HashMap<>();
    this.actionOrdering = new PriorityQueue<>(characters.size(), CombatActionTimeOrder);
  }
  
  // runs the next CombatAction in the actionOrdering
  public void nextAction() {
    if (actionOrdering.size() > 0) {
      ICombatAction nextAction = actionOrdering.remove();
      this.plans.remove(nextAction.getActor());
      this.setLocalTime(nextAction.getCompletesAt());
      nextAction.perform(this);
    }
    
    for (Entity e : this.entities) {
      if (!this.plans.containsKey(e)) {
        ICombatAction nextAction = e.nextAction(this);
        this.actionOrdering.add(nextAction);
        this.plans.put(e, nextAction);
      }
    }
    
  }
  
  public void nextPlanningTick() {
  }

  /**
   * @return the characters
   */
  public List<Entity> getEntities() {
    return entities;
  }

  /**
   * @return the localTime
   */
  public double getLocalTime() {
    return localTime;
  }

  /**
   * @param localTime the localTime to set
   */
  public void setLocalTime(double localTime) {
    this.localTime = localTime;
  }
}

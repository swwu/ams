/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apm.combat;

import com.apm.combat.actions.AttackAction;
import com.apm.character.Character;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Represents a specific combat event. Combat mechanics are only simulated
 * inside of a CombatInstance.
 *
 * @author Steven
 */
public class CombatInstance {
  // some intrinsic properties of the combat instance

  float locationSize; // how big the instance is. "In" m^2.
  float locationClutter; // how cluttered the location is. Value on [0,1].

  // the characters in the instance
  List<Character> characters;

  // all actions that are currently "in-flight" inside this combat instance.
  PriorityQueue<AttackAction> actionOrdering = new PriorityQueue<AttackAction>(characters.size(), CombatActionTimeOrder);

  // this comparator is used to sort CombatActions by their completion time
  public static Comparator<ICombatAction> CombatActionTimeOrder = new Comparator<ICombatAction>() {
    @Override
    public int compare(ICombatAction o1, ICombatAction o2) {
      double delta = o2.getCompletesAt() - o1.getCompletesAt();
      return (delta > 0) ? 1
              : (delta == 0) ? 0
                      : -1;
    }
  };

  public CombatInstance(List<Character> characters) {
    this.locationSize = 10.0f;
    this.locationClutter = 0.1f;

    this.characters = characters;
  }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ams.character;

import com.ams.combat.CombatInstance;
import com.ams.combat.ICombatAction;
import com.ams.combat.actions.AttackAction;

/**
 *
 * @author Steven
 */
public class Entity {
  private String name;
  
  Body body;
  Soul soul;

  // how ready this character is to take an action. Taking actions consumes
  // readiness, and it slowly regenerates over time
  float readiness;

  // vitals
  float currentHealth;
  float maxHealth;

  public Entity(String name) {   
    this.name = name;

    this.body = new Body();
    this.soul = new Soul();

    this.maxHealth = 100;
    this.currentHealth = this.maxHealth;
  }

  public void calculateStats() {
  }

  public void doAttack(Entity target) {
  }
  
  public ICombatAction nextAction(CombatInstance c) {
    return new AttackAction(this, 
            c.getEntities().stream().filter(p -> p != this).findFirst().get(),
            c.getLocalTime() + 100);
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the body
   */
  public Body getBody() {
    return body;
  }

  /**
   * @return the soul
   */
  public Soul getSoul() {
    return soul;
  }

  /**
   * @return the readiness
   */
  public float getReadiness() {
    return readiness;
  }

  /**
   * @param readiness the readiness to set
   */
  public void setReadiness(float readiness) {
    this.readiness = readiness;
  }

  /**
   * @return the currentHealth
   */
  public float getCurrentHealth() {
    return currentHealth;
  }

  /**
   * @param currentHealth the currentHealth to set
   */
  public void setCurrentHealth(float currentHealth) {
    this.currentHealth = currentHealth;
  }

  /**
   * @return the maxHealth
   */
  public float getMaxHealth() {
    return maxHealth;
  }

  /**
   * @param maxHealth the maxHealth to set
   */
  public void setMaxHealth(float maxHealth) {
    this.maxHealth = maxHealth;
  }

}

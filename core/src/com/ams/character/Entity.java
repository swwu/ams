/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ams.character;

import com.ams.tactical.TacticalInstance;
import com.ams.tactical.actions.AttackAction;
import com.ams.tactical.BaseTacticalAction;
import com.ams.tactical.actions.WaitAction;
import java.util.Optional;
import java.util.stream.Stream;

/**
 *
 * @author Steven
 */
public class Entity {
  private String name;
  
  Body body;
  Soul soul;
  
  boolean dead;

  // how ready this character is to take an action. Taking actions consumes
  // readiness, and it slowly regenerates over time
  float readiness;

  // vitals
  float currentHealth;
  float maxHealth;

  public Entity(String name) {   
    this.name = name;

    this.body = new Body("bob","human");
    this.soul = new Soul();

    this.maxHealth = 100;
    this.currentHealth = this.maxHealth;
  }

  public void calculateStats() {
  }

  public BaseTacticalAction nextAction(TacticalInstance c) {
    Stream<Entity> potentialTargets;
    Optional<Entity> target;

    potentialTargets = c.getActiveEntities().filter(p -> p != this);
    target = potentialTargets.findFirst();

    if (target.isPresent()) {
      return new AttackAction(this, 
        target.get(),
        c.getLocalTime(),
        c.getLocalTime() + 100);
    } else {
      return new WaitAction(this, c.getLocalTime(), c.getLocalTime() + 100);
    }
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

  public void modifyCurrentHealth(float mod) {
    this.setCurrentHealth(this.getCurrentHealth() + mod);
  }
  
  /**
   * @param currentHealth the currentHealth to set
   */
  public void setCurrentHealth(float currentHealth) {
    this.currentHealth = currentHealth;
    
    if (this.currentHealth < 0) {
      this.setDead(true);
    }
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

  public boolean isDead() {
    return this.dead;
  }

  /**
   * @param dead the dead to set
   */
  public void setDead(boolean dead) {
    this.dead = dead;
  }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apm.character;

/**
 *
 * @author Steven
 */
public class Character {

  private Body body;
  private Soul soul;

  // how ready this character is to take an action. Taking actions consumes
  // readiness, and it slowly regenerates over time
  private float readiness;

  // vitals
  private float currentHealth;
  private float maxHealth;

  public Character() {
    this.body = new Body();
    this.soul = new Soul();

    this.maxHealth = 100;
    this.currentHealth = this.maxHealth;
  }

  public void calculateStats() {
  }

  public void doAttack(Character target) {
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

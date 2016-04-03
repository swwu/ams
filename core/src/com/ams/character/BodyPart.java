/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ams.character;

/**
 *
 * @author Steven
 */
public class BodyPart {
  // name of body part, like Left Leg
  private final String name;
  // has a grasper, like an arm
  private final boolean hasGrasper;
  // has a stance, like a leg
  private final boolean hasStance;
  // contains vital organs, like a torso
  private final boolean hasVitals;
  // contains the creature's soul, like a brain
  private final boolean hasSoul;
  
  BodyPart(String name, boolean hasGrasper, boolean hasStance, boolean hasVitals, boolean hasSoul){
      this.name = name;
      this.hasGrasper = hasGrasper;
      this.hasStance = hasStance;
      this.hasVitals = hasVitals;
      this.hasSoul = hasSoul;
  }

    /**
     * @return the hasGrasper
     */
    public boolean isHasGrasper() {
        return hasGrasper;
    }

    /**
     * @return the hasStance
     */
    public boolean isHasStance() {
        return hasStance;
    }

    /**
     * @return the hasVitals
     */
    public boolean isHasVitals() {
        return hasVitals;
    }

    /**
     * @return the hasSoul
     */
    public boolean isHasSoul() {
        return hasSoul;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ams.character;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Steven
 */
public class BodyType {
  //defined values
  private List<BodyPart> bodyParts;

  //calculated values
  private Set<BodyPart> grasperParts;
  private Set<BodyPart> stanceParts;
  private Set<BodyPart> vitalsParts;
  private Set<BodyPart> soulParts;
  
  BodyType(String race){
      this.bodyParts = new ArrayList<>();
      switch (race) {
          case "human":
              this.bodyParts.add(new BodyPart("head", false, false, true, true));
              this.bodyParts.add(new BodyPart("torso", false, false, true, false));
              this.bodyParts.add(new BodyPart("left arm", true, false, false, false));
              this.bodyParts.add(new BodyPart("right arm", true, false, false, false));
              this.bodyParts.add(new BodyPart("left leg", false, true, false, false));
              this.bodyParts.add(new BodyPart("right leg", false, true, false, false));
              break;
          case "yaktaur":
              this.bodyParts.add(new BodyPart("head", false, false, true, true));
              this.bodyParts.add(new BodyPart("upper torso", false, false, true, false));
              this.bodyParts.add(new BodyPart("rear torso", false, false, true, false));
              this.bodyParts.add(new BodyPart("left arm", true, false, false, false));
              this.bodyParts.add(new BodyPart("right arm", true, false, false, false));
              this.bodyParts.add(new BodyPart("left leg", false, true, false, false));
              this.bodyParts.add(new BodyPart("right leg", false, true, false, false));
              this.bodyParts.add(new BodyPart("left rear leg", false, true, false, false));
              this.bodyParts.add(new BodyPart("right rear leg", false, true, false, false));
              break;
          case "naga":
              this.bodyParts.add(new BodyPart("head", false, false, true, true));
              this.bodyParts.add(new BodyPart("upper torso", false, false, true, false));
              this.bodyParts.add(new BodyPart("naga tail", false, true, true, false));
              this.bodyParts.add(new BodyPart("left arm", true, false, false, false));
              this.bodyParts.add(new BodyPart("right arm", true, false, false, false));
              break;
          default:
              this.bodyParts.add(new BodyPart("blob", false, false, true, true));
              break;
      }
          
  }
  
  private void recomputeBodyPartTypes() {
    //first, clear our sets of BodyPartTypes
        getGrasperParts().clear();
        getStanceParts().clear();
        getVitalsParts().clear();
        getSoulParts().clear();
    
    //add approprate parts to sets
    for (BodyPart bpart : getBodyParts()){
        if (bpart.isHasGrasper()){
                getGrasperParts().add(bpart);
        }
        if (bpart.isHasStance()){
                getStanceParts().add(bpart);
        }
        if (bpart.isHasVitals()){
                getVitalsParts().add(bpart);
        }
        if (bpart.isHasGrasper()){
                getSoulParts().add(bpart);
        }
    }
}

    /**
     * @return the bodyParts
     */
    public List<BodyPart> getBodyParts() {
        return bodyParts;
    }

    /**
     * @return the grasperParts
     */
    public Set<BodyPart> getGrasperParts() {
        return grasperParts;
    }

    /**
     * @return the stanceParts
     */
    public Set<BodyPart> getStanceParts() {
        return stanceParts;
    }

    /**
     * @return the vitalsParts
     */
    public Set<BodyPart> getVitalsParts() {
        return vitalsParts;
    }

    /**
     * @return the soulParts
     */
    public Set<BodyPart> getSoulParts() {
        return soulParts;
    }
  
  
}
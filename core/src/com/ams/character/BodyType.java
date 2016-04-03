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
  List<BodyPart> bodyParts;

  //calculated values
  Set<BodyPart> grasperParts;
  Set<BodyPart> stanceParts;
  Set<BodyPart> vitalsParts;
  Set<BodyPart> soulParts;
  
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
    grasperParts.clear();
    stanceParts.clear();
    vitalsParts.clear();
    soulParts.clear();
    
    //add approprate parts to sets
    for (BodyPart bpart : bodyParts){
        if (bpart.isHasGrasper()){
            grasperParts.add(bpart);
        }
        if (bpart.isHasStance()){
            stanceParts.add(bpart);
        }
        if (bpart.isHasVitals()){
            vitalsParts.add(bpart);
        }
        if (bpart.isHasGrasper()){
            soulParts.add(bpart);
        }
    }
}
  
  
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ams.character;

import java.util.List;
import java.util.Set;

/**
 * A body is a specific implementation of a BodyType
 *
 * @author Steven
 */
public class Body {

  private String name;

  // the type of body this is. Currently only three type of body exists 
  //(human, yaktaur, naga).
  private final BodyType bodyType;

  // Physical attributes
  private float strStat;
  private float dexStat;
  private float conStat;

  Body(String name, String race) {
    //a name, which bodies often have
    this.name = name;
    //currently accepted are "human" "yaktaur" and "naga"
    this.bodyType = new BodyType(race);
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
}

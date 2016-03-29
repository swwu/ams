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
  // the type of body this is. Currently only one type of body exists (human).

  private BodyType bodyType;

  // Physical attributes
  private float strStat;
  private float dexStat;
  private float conStat;
}

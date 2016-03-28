/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apm.interaction;

import java.util.List;

/**
 * Interactions represent a targeted "action" that a character can perform on
 * the strategic level. Examples of interactions are attempts to initiate combat
 * or conversation.
 */
public interface IInteraction {

  public Character sender();

  public Character target();

  public boolean isValidTarget(Character c);

  // is called when the interaction succeeds
  public void perform();
}

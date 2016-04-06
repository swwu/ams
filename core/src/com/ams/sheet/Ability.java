/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ams.sheet;

/**
 *
 * @author cdesa
 */
public class Ability {
    
    public static final Ability Str = new Ability("Str", "Strength");
    public static final Ability Dex = new Ability("Dex", "Dexterity");
    public static final Ability Con = new Ability("Con", "Constitution");
    public static final Ability Int = new Ability("Int", "Intelligence");
    public static final Ability Wis = new Ability("Wis", "Wisdom");
    public static final Ability Cha = new Ability("Cha", "Charisma");
    
    public static final Ability[] Abilities = { Str, Dex, Con, Int, Wis, Cha };
    
    public final String name;
    public final String longName;
    
    private Ability(String name, String longName) {
        this.name = name;
        this.longName = longName;
    }
    
}

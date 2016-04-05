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
public class CharacterSheetConstants {
    // could we use an enumerated type here so that we don't enter 7 it's fubar
    public final static int I_STR = 0;
    public final static int I_DEX = 1;
    public final static int I_CON = 2;
    public final static int I_INT = 3;
    public final static int I_WIS = 4;
    public final static int I_CHA = 5;
    public final static int NUM_ABILITY_SCORES = 6;
    
    public final static double K_HP = 10.0;
    public final static double K_MP = 2.0;
    public final static double K_REFLEXRATE = 1.0;
    public final static double K_SAVE = 1.0;
    
    public final static double K_SKILL = 10.0;
    
    public static String shortAbilityName(int ability) {
        switch(ability) {
            case I_STR:
                return "Str";
            case I_DEX:
                return "Dex";
            case I_CON:
                return "Con";
            case I_INT:
                return "Int";
            case I_WIS:
                return "Wis";
            case I_CHA:
                return "Cha";
            default:
                assert(false);
        }
        return "";
    }
}

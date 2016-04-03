/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ams.sheet;

import java.util.*;

/**
 *
 * @author cdesa
 */
public class Skill {
    private static ArrayList<Skill> skills;
    
    public static void initSkills() {
        skills = new ArrayList<>();
        
        Skill sFighter = new Skill("fighter", null);
        sFighter.addAffHP()
                .addAffSave(CharacterSheetConstants.I_STR)
                .addAffSave(CharacterSheetConstants.I_DEX)
                .addAffSave(CharacterSheetConstants.I_CON);
        Skill sSpecialist = new Skill("specialist", null);
        sSpecialist.addAffReflexRate()
                .addAffAllSaves();
        Skill sCaster = new Skill("caster", null);
        sCaster.addAffMP()
                .addAffSave(CharacterSheetConstants.I_INT)
                .addAffSave(CharacterSheetConstants.I_WIS)
                .addAffSave(CharacterSheetConstants.I_CHA);
        Skill sMelee = new Skill("melee", sFighter);
        sFighter.addAffHP().addAffReflexRate()
                .addAffSave(CharacterSheetConstants.I_STR)
                .addAffSave(CharacterSheetConstants.I_CON);
        Skill sRanged = new Skill("ranged", sFighter);
        sRanged.addAffHP().addAffReflexRate()
                .addAffSave(CharacterSheetConstants.I_DEX)
                .addAffSave(CharacterSheetConstants.I_CON);
    }
    
    public static Skill getSkill(int id) {
        return skills.get(id);
    }
    
    public static int numSkills() {
        return skills.size();
    }
    
    private int id;
    private String name;
    private Skill parent;
    
    private double affHP;
    private double affMP;
    private double affReflexRate;
    private double[] affSaves;
    
    public Skill(String name, Skill parent) {
        this.name = name;
        this.parent = parent;
        affHP = 0;
        affMP = 0;
        affReflexRate = 0;
        affSaves = new double[CharacterSheetConstants.NUM_ABILITY_SCORES];
        id = skills.size();
        skills.add(this);
    }
    
    private Skill addAffHP() {
        affHP += 1;
        return this;
    }
    private Skill addAffMP() {
        affMP += 1;
        return this;
    }
    private Skill addAffReflexRate() {
        affReflexRate += 1;
        return this;
    }
    private Skill addAffSave(int ability) {
        affSaves[ability] += 1;
        return this;
    }
    private Skill addAffAllSaves() {
        for(int i = 0; i < CharacterSheetConstants.NUM_ABILITY_SCORES; i++) {
            affSaves[i] += 1;
        }
        return this;
    }
    
    public boolean hasParent() {
        return (parent != null);
    }
    
    public Skill getParent() {
        return parent;
    }
    
    public int getId() {
        return id;
    }

    /**
     * @return the affHP
     */
    public double getAffHP() {
        return affHP;
    }

    /**
     * @return the affMP
     */
    public double getAffMP() {
        return affMP;
    }

    /**
     * @return the affReflexRate
     */
    public double getAffReflexRate() {
        return affReflexRate;
    }

    /**
     * @param id the id of the ability score associated with the save
     * @return the affReflexRate
     */
    public double getAffSave(int id) {
        return affSaves[id];
    }
}

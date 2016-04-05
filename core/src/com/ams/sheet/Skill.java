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
        
        Skill sFighter = new Skill("Fight", null, CharacterSheetConstants.I_STR);
        sFighter.addAffHP()
                .addAffSave(CharacterSheetConstants.I_STR)
                .addAffSave(CharacterSheetConstants.I_DEX)
                .addAffSave(CharacterSheetConstants.I_CON);
        Skill sSpecialist = new Skill("Specialist", null, CharacterSheetConstants.I_DEX);
        sSpecialist.addAffReflexRate()
                .addAffAllSaves();
        Skill sCaster = new Skill("Cast", null, CharacterSheetConstants.I_INT);
        sCaster.addAffMP()
                .addAffSave(CharacterSheetConstants.I_INT)
                .addAffSave(CharacterSheetConstants.I_WIS)
                .addAffSave(CharacterSheetConstants.I_CHA);
        Skill sMelee = new Skill("Melee", sFighter, CharacterSheetConstants.I_STR);
        sMelee.addAffHP().addAffReflexRate()
                .addAffSave(CharacterSheetConstants.I_STR)
                .addAffSave(CharacterSheetConstants.I_CON);
        Skill sRanged = new Skill("Ranged", sFighter, CharacterSheetConstants.I_DEX);
        sRanged.addAffHP().addAffReflexRate()
                .addAffSave(CharacterSheetConstants.I_DEX)
                .addAffSave(CharacterSheetConstants.I_CON);
        
        Skill sKnowledge = new Skill("Knowledge", null, CharacterSheetConstants.I_INT);
        sKnowledge.addAffMP().addAffReflexRate()
                .addAffSave(CharacterSheetConstants.I_INT)
                .addAffSave(CharacterSheetConstants.I_WIS);
        Skill sArcana = new Skill("Arcana", sKnowledge, CharacterSheetConstants.I_INT);
        sArcana.addAffMP()
                .addAffSave(CharacterSheetConstants.I_INT)
                .addAffSave(CharacterSheetConstants.I_WIS)
                .addAffSave(CharacterSheetConstants.I_CHA);
        Skill sReligion = new Skill("Religion", sKnowledge, CharacterSheetConstants.I_INT);
        sReligion.addAffMP()
                .addAffSave(CharacterSheetConstants.I_INT)
                .addAffSave(CharacterSheetConstants.I_WIS)
                .addAffSave(CharacterSheetConstants.I_CHA);
        Skill sNature = new Skill("Nature", sKnowledge, CharacterSheetConstants.I_INT);
        sNature.addAffReflexRate()
                .addAffSave(CharacterSheetConstants.I_INT)
                .addAffSave(CharacterSheetConstants.I_WIS)
                .addAffSave(CharacterSheetConstants.I_CON);
        Skill sEngineering = new Skill("Engineering", sKnowledge, CharacterSheetConstants.I_INT);
        sEngineering.addAffReflexRate()
                .addAffSave(CharacterSheetConstants.I_INT)
                .addAffSave(CharacterSheetConstants.I_WIS)
                .addAffSave(CharacterSheetConstants.I_DEX);
        Skill sNobility = new Skill("Nobility", sKnowledge, CharacterSheetConstants.I_INT);
        sNobility.addAffHP()
                .addAffSave(CharacterSheetConstants.I_INT)
                .addAffSave(CharacterSheetConstants.I_WIS)
                .addAffSave(CharacterSheetConstants.I_CHA);
        Skill sLocal = new Skill("Local", sKnowledge, CharacterSheetConstants.I_INT);
        sLocal.addAffHP()
                .addAffSave(CharacterSheetConstants.I_INT)
                .addAffSave(CharacterSheetConstants.I_WIS)
                .addAffSave(CharacterSheetConstants.I_CHA);
        Skill sSpellcraft = new Skill("Spellcraft", sCaster, CharacterSheetConstants.I_INT);
        sSpellcraft.addAffMP()
                .addAffSave(CharacterSheetConstants.I_INT)
                .addAffSave(CharacterSheetConstants.I_CHA);
        Skill sCounterspell = new Skill("Counterspell", sSpellcraft, CharacterSheetConstants.I_CHA);
        sCounterspell.addAffMP().addAffReflexRate()
                .addAffSave(CharacterSheetConstants.I_WIS)
                .addAffSave(CharacterSheetConstants.I_CHA);
    }
    
    public static Skill getSkill(int id) {
        return skills.get(id);
    }
    
    public static int numSkills() {
        return skills.size();
    }
    
    private int id;
    private int keyAbility;
    private String name;
    private Skill parent;
    
    private double affHP;
    private double affMP;
    private double affReflexRate;
    private double[] affSaves;
    
    public Skill(String name, Skill parent, int keyAbility) {
        this.name = name;
        this.parent = parent;
        this.keyAbility = keyAbility;
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
    
    public static void main(String [] args) {
        // initialize the skills
        initSkills();
                
        // prints out a diagram of the skill tree
        System.out.println("");
        System.out.println("root = {");
        System.out.println("  HTMLclass: \"root\",");
        System.out.println("  innerHTML: \"<p>Root</p>\"");
        System.out.println("}");
        System.out.println("");
        
        for (Skill s: skills) {
            System.out.println("skill" + Integer.toString(s.getId()) + " = {");
            if(s.hasParent()) {
                System.out.println("  parent: skill" + Integer.toString(s.getParent().getId()) + ",");
            }
            else {
                System.out.println("  parent: root,");
            }
            System.out.print("    innerHTML: skillInfo(\"" + s.name + " (" + CharacterSheetConstants.shortAbilityName(s.keyAbility) + ")\", ");
            System.out.print((s.getAffHP() > 0) ? "true, " : "false, ");
            System.out.print((s.getAffMP() > 0) ? "true, " : "false, ");
            System.out.print((s.getAffReflexRate() > 0) ? "true, " : "false, ");
            System.out.print((s.getAffSave(0) > 0) ? "true, " : "false, ");
            System.out.print((s.getAffSave(1) > 0) ? "true, " : "false, ");
            System.out.print((s.getAffSave(2) > 0) ? "true, " : "false, ");
            System.out.print((s.getAffSave(3) > 0) ? "true, " : "false, ");
            System.out.print((s.getAffSave(4) > 0) ? "true, " : "false, ");
            System.out.println((s.getAffSave(5) > 0) ? "true)" : "false)");
            System.out.println("}");
            System.out.println("");
        }
        
        System.out.print("chart_config = [config, root, ");
        for (Skill s: skills) {
            System.out.print("skill" + Integer.toString(s.getId()) + ", ");
        }
        System.out.println("]");
        System.out.println("");
    }
}

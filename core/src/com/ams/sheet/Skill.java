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
        
        Skill sFighter = new Skill("Fight", null, Ability.Str);
        sFighter.addAffHP()
                .addAffSave(Ability.Str)
                .addAffSave(Ability.Dex)
                .addAffSave(Ability.Con);
        Skill sSpecialist = new Skill("Specialist", null, Ability.Dex);
        sSpecialist.addAffReflexRate()
                .addAffAllSaves();
        Skill sCaster = new Skill("Cast", null, Ability.Int);
        sCaster.addAffMP()
                .addAffSave(Ability.Int)
                .addAffSave(Ability.Wis)
                .addAffSave(Ability.Cha);
        Skill sMelee = new Skill("Melee", sFighter, Ability.Str);
        sMelee.addAffHP().addAffReflexRate()
                .addAffSave(Ability.Str)
                .addAffSave(Ability.Con);
        Skill sRanged = new Skill("Ranged", sFighter, Ability.Dex);
        sRanged.addAffHP().addAffReflexRate()
                .addAffSave(Ability.Dex)
                .addAffSave(Ability.Con);
        
        Skill sKnowledge = new Skill("Knowledge", null, Ability.Int);
        sKnowledge.addAffMP().addAffReflexRate()
                .addAffSave(Ability.Int)
                .addAffSave(Ability.Wis);
        Skill sArcana = new Skill("Arcana", sKnowledge, Ability.Int);
        sArcana.addAffMP()
                .addAffSave(Ability.Int)
                .addAffSave(Ability.Wis)
                .addAffSave(Ability.Cha);
        Skill sReligion = new Skill("Religion", sKnowledge, Ability.Int);
        sReligion.addAffMP()
                .addAffSave(Ability.Int)
                .addAffSave(Ability.Wis)
                .addAffSave(Ability.Cha);
        Skill sNature = new Skill("Nature", sKnowledge, Ability.Int);
        sNature.addAffReflexRate()
                .addAffSave(Ability.Int)
                .addAffSave(Ability.Wis)
                .addAffSave(Ability.Con);
        Skill sEngineering = new Skill("Engineering", sKnowledge, Ability.Int);
        sEngineering.addAffReflexRate()
                .addAffSave(Ability.Int)
                .addAffSave(Ability.Wis)
                .addAffSave(Ability.Dex);
        Skill sNobility = new Skill("Nobility", sKnowledge, Ability.Int);
        sNobility.addAffHP()
                .addAffSave(Ability.Int)
                .addAffSave(Ability.Wis)
                .addAffSave(Ability.Cha);
        Skill sLocal = new Skill("Local", sKnowledge, Ability.Int);
        sLocal.addAffHP()
                .addAffSave(Ability.Int)
                .addAffSave(Ability.Wis)
                .addAffSave(Ability.Cha);
        Skill sSpellcraft = new Skill("Spellcraft", sCaster, Ability.Int);
        sSpellcraft.addAffMP()
                .addAffSave(Ability.Int)
                .addAffSave(Ability.Cha);
        Skill sCounterspell = new Skill("Counterspell", sSpellcraft, Ability.Cha);
        sCounterspell.addAffMP().addAffReflexRate()
                .addAffSave(Ability.Wis)
                .addAffSave(Ability.Cha);
        
        Skill sSociety = new Skill("Society", null, Ability.Wis);
        sSociety.addAffReflexRate()
                .addAffSave(Ability.Dex)
                .addAffSave(Ability.Wis)
                .addAffSave(Ability.Cha);
        Skill sDiplomacy = new Skill("Diplomacy", sSociety, Ability.Cha);
        sDiplomacy.inheritParentAffinities();
        Skill sAppraise = new Skill("Appraise", sSociety, Ability.Int);
        sAppraise.inheritParentAffinities();
        Skill sIntimidate = new Skill("Intimidate", sSociety, Ability.Cha);
        sIntimidate.addAffHP().addAffReflexRate()
                .addAffSave(Ability.Str)
                .addAffSave(Ability.Cha);
        Skill sBluff = new Skill("Bluff", sSociety, Ability.Cha);
        sBluff.inheritParentAffinities();
        
        Skill sAthletics = new Skill("Athletics", sFighter, Ability.Str);
        sAthletics.addAffHP().addAffReflexRate()
                .addAffSave(Ability.Str)
                .addAffSave(Ability.Dex)
                .addAffSave(Ability.Con);
        
        Skill sAcrobatics = new Skill("Acrobatics", sAthletics, Ability.Dex);
        sAcrobatics.inheritParentAffinities();
        Skill sClimb = new Skill("Climb", sAthletics, Ability.Str);
        sClimb.inheritParentAffinities();
        Skill sSwim = new Skill("Swim", sAthletics, Ability.Str);
        sSwim.inheritParentAffinities();
        Skill sFly = new Skill("Fly", sAthletics, Ability.Dex);
        sFly.addAffHP().addAffReflexRate().addAffMP()
                .addAffSave(Ability.Dex)
                .addAffSave(Ability.Cha);
    }
    
    public static Skill getSkill(int id) {
        return skills.get(id);
    }
    
    public static int numSkills() {
        return skills.size();
    }
    
    private int id;
    private Ability keyAbility;
    private String name;
    private Skill parent;
    
    private double affHP;
    private double affMP;
    private double affReflexRate;
    private HashMap<Ability, Double> affSaves;
    
    public Skill(String name, Skill parent, Ability keyAbility) {
        this.name = name;
        this.parent = parent;
        this.keyAbility = keyAbility;
        affHP = 0;
        affMP = 0;
        affReflexRate = 0;
        affSaves = new HashMap<>();
        for (Ability a: Ability.Abilities) {
            affSaves.put(a, 0.0);
        }
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
    private Skill addAffSave(Ability ability) {
        affSaves.put(ability, affSaves.get(ability) + 1.0);
        return this;
    }
    private Skill addAffAllSaves() {
        for (Ability a: Ability.Abilities) {
            addAffSave(a);
        }
        return this;
    }
    
    private Skill inheritParentAffinities() {
        affHP = parent.affHP;
        affMP = parent.affMP;
        affReflexRate = parent.affReflexRate;
        for (Ability a: Ability.Abilities) {
            affSaves.put(a, parent.affSaves.get(a));
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
    public double getAffSave(Ability ability) {
        return affSaves.get(ability);
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
            System.out.print("  innerHTML: skillInfo(\"" + s.name + "\", \"" + s.keyAbility.name + "\", ");
            System.out.print((s.getAffHP() > 0) ? "true, " : "false, ");
            System.out.print((s.getAffMP() > 0) ? "true, " : "false, ");
            System.out.print((s.getAffReflexRate() > 0) ? "true, " : "false, ");
            System.out.print((s.getAffSave(Ability.Str) > 0) ? "true, " : "false, ");
            System.out.print((s.getAffSave(Ability.Dex) > 0) ? "true, " : "false, ");
            System.out.print((s.getAffSave(Ability.Con) > 0) ? "true, " : "false, ");
            System.out.print((s.getAffSave(Ability.Int) > 0) ? "true, " : "false, ");
            System.out.print((s.getAffSave(Ability.Wis) > 0) ? "true, " : "false, ");
            System.out.println((s.getAffSave(Ability.Cha) > 0) ? "true)," : "false),");
            System.out.println("  stackChildren: true");
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

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
 * 
 * a CharacterSheet object contains all the values that would be on a character
 * sheet in D&D.  Skills, feats, XP, etc.  The CharacterSheet object is also
 * responsible for managing character progression.
 */
public class CharacterSheet {
    String name;
    String description;
    
    // non-derived values
    boolean[] unlockedSkills;
    double[] investedXP;
    HashMap<Ability, Double> abilityScores;
    List<Trait> traits;
    
    // derived values
    HashMap<Ability, Double> abilityModifiers;
    double maxHP;
    double maxMP;
    double reflexRate;
    HashMap<Ability, Double> saves;
    double[] skillRanks;
    
    CharacterSheet(String name, String description) {
        this.name = name;
        this.description = description;
        
        unlockedSkills = new boolean[Skill.numSkills()];
        investedXP = new double[Skill.numSkills()];
        abilityScores = new HashMap<>();
        traits = new ArrayList<>();
        
        abilityModifiers = new HashMap<>();
        saves = new HashMap<>();
        skillRanks = new double[Skill.numSkills()];
    }

    private void recomputeDerivedValues() {
        // first, compute ability modifiers
        for (Ability a: Ability.Abilities) {
            abilityModifiers.put(a, (abilityScores.get(a) - 10.0) / 2.0);
        }
        
        // second, compute total XP and affinity-weighted XP
        double totalXP = 0.0;
        double xpAffHP = 0.0;
        double xpAffMP = 0.0;
        double xpAffReflexRate = 0.0;
        HashMap<Ability, Double> xpAffSaves = new HashMap<>();
        for (int skillid = 0; skillid < Skill.numSkills(); skillid++) {
            totalXP += investedXP[skillid];
            xpAffHP += investedXP[skillid] * Skill.getSkill(skillid).getAffHP();
            xpAffMP += investedXP[skillid] * Skill.getSkill(skillid).getAffMP();
            xpAffReflexRate += investedXP[skillid] * Skill.getSkill(skillid).getAffReflexRate();
            for (Ability a: Ability.Abilities) {
                xpAffSaves.put(a, xpAffSaves.getOrDefault(a, 0.0) + investedXP[skillid] * Skill.getSkill(skillid).getAffSave(a));
            }
        }
        
        assert(totalXP > 0.0);
        
        // and compute affinity-based values
        maxHP = ProgressionConstants.K_HP
                * abilityScores.get(Ability.Con)
                * (1.0 + xpAffHP / totalXP)
                * Math.sqrt(totalXP);
        
        maxMP = ProgressionConstants.K_MP
                * abilityScores.get(Ability.Wis)
                * (1.0 + xpAffMP / totalXP)
                * Math.sqrt(totalXP);
        
        reflexRate = ProgressionConstants.K_REFLEXRATE
                * abilityScores.get(Ability.Dex)
                * (1.0 + xpAffReflexRate / totalXP);
        
        for (Ability a: Ability.Abilities) {
            saves.put(a, ProgressionConstants.K_SAVE
                    * (1.0 + xpAffSaves.get(a) / totalXP)
                    * Math.sqrt(totalXP)
                    + abilityModifiers.get(a));
        }
        
        // third, compute skill ranks
        for (int skillid = 0; skillid < Skill.numSkills(); skillid++) {
            // verify that only unlocked skills have invested XP
            assert((investedXP[skillid] == 0.0)||(unlockedSkills[skillid]));
            
            Skill skill = Skill.getSkill(skillid);
            double myXP = investedXP[skillid];
            double parentRanks = 0.0;
            if(skill.hasParent()) {
                parentRanks = skillRanks[skill.getParent().getId()];
            }
            
            if(unlockedSkills[skillid]) {
                double baseRanks = Math.max(parentRanks - 3.0, 0.0);
                
                skillRanks[skillid] = Math.sqrt(
                        myXP / ProgressionConstants.K_SKILL
                        + baseRanks * (baseRanks + 1)
                        + 0.25) - 0.5;
            }
            else {
                // root skills must be unlocked
                assert(skill.hasParent());
                
                // rank of an locked skill is parent rank - 3
                skillRanks[skillid] = parentRanks - 3.0;
            }
        }
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the maxHP
     */
    public double getMaxHP() {
        return maxHP;
    }

    /**
     * @return the maxMP
     */
    public double getMaxMP() {
        return maxMP;
    }

    /**
     * @return the reflexRate
     */
    public double getReflexRate() {
        return reflexRate;
    }
    
    /**
     * @return the rank for a skill
     */
    public double getSkillRank(Skill skill) {
        return skillRanks[skill.getId()];
    }
    
    
}

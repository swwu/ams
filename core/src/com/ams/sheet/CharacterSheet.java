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
    double[] abilityScores;
    List<Trait> traits;
    
    // derived values
    double[] abilityModifiers;
    double maxHP;
    double maxMP;
    double reflexRate;
    double[] saves;
    double[] skillRanks;
    
    CharacterSheet(String name, String description) {
        this.name = name;
        this.description = description;
        
        unlockedSkills = new boolean[Skill.numSkills()];
        investedXP = new double[Skill.numSkills()];
        abilityScores = new double[CharacterSheetConstants.NUM_ABILITY_SCORES];
        traits = new ArrayList<>();
        
        abilityModifiers = new double[CharacterSheetConstants.NUM_ABILITY_SCORES];
        saves = new double[CharacterSheetConstants.NUM_ABILITY_SCORES];
        skillRanks = new double[Skill.numSkills()];
    }

    private void recomputeDerivedValues() {
        // first, compute ability modifiers
        for (int ia = 0; ia < CharacterSheetConstants.NUM_ABILITY_SCORES; ia++) {
            abilityModifiers[ia] = (abilityScores[ia] - 10.0) / 2.0;
        }
        
        // second, compute total XP and affinity-weighted XP
        double totalXP = 0.0;
        double xpAffHP = 0.0;
        double xpAffMP = 0.0;
        double xpAffReflexRate = 0.0;
        double[] xpAffSaves = new double[CharacterSheetConstants.NUM_ABILITY_SCORES];
        for (int skillid = 0; skillid < Skill.numSkills(); skillid++) {
            totalXP += investedXP[skillid];
            xpAffHP += investedXP[skillid] * Skill.getSkill(skillid).getAffHP();
            xpAffMP += investedXP[skillid] * Skill.getSkill(skillid).getAffMP();
            xpAffReflexRate += investedXP[skillid] * Skill.getSkill(skillid).getAffReflexRate();
            for (int ia = 0; ia < CharacterSheetConstants.NUM_ABILITY_SCORES; ia++) {
                xpAffSaves[ia] += investedXP[skillid] * Skill.getSkill(skillid).getAffSave(ia);
            }
        }
        
        assert(totalXP > 0.0);
        
        // and compute affinity-based values
        maxHP = CharacterSheetConstants.K_HP
                * abilityScores[CharacterSheetConstants.I_CON]
                * (1.0 + xpAffHP / totalXP)
                * Math.sqrt(totalXP);
        
        maxMP = CharacterSheetConstants.K_MP
                * abilityScores[CharacterSheetConstants.I_WIS]
                * (1.0 + xpAffMP / totalXP)
                * Math.sqrt(totalXP);
        
        reflexRate = CharacterSheetConstants.K_REFLEXRATE
                * abilityScores[CharacterSheetConstants.I_DEX]
                * (1.0 + xpAffReflexRate / totalXP);
        
        for (int ia = 0; ia < CharacterSheetConstants.NUM_ABILITY_SCORES; ia++) {
            saves[ia] = CharacterSheetConstants.K_SAVE
                    * (1.0 + xpAffSaves[ia] / totalXP)
                    * Math.sqrt(totalXP)
                    + abilityModifiers[ia];
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
                        myXP / CharacterSheetConstants.K_SKILL
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

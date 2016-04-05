
var config = {
    container: "#skills-chart",

    animateOnInit: true,
    
    node: {
        collapsable: true
    },
    animation: {
        nodeAnimation: "easeOutBounce",
        nodeSpeed: 700,
        connectorsAnimation: "bounce",
        connectorsSpeed: 700
    }
}

function skillInfo(name, aff_HP, aff_MP, aff_RX, aff_STR, aff_DEX, aff_CON, aff_INT, aff_WIS, aff_CHA) {
  // if (xp == null) {
  //   xpstr = "Locked"
  // }
  // else {
  //   xpstr = "XP: " + xp
  // }

  function affinityHelper(type, txt, aff) {
    if (aff) {
      affstr = " affinity-on"
    }
    else {
      affstr = ""
    }

    return "<span class=\"affinity-" + type + " " + affstr + "\">" + txt + "</span>"
  }


  return "<p class=\"skill-name\">"
    + name
    //+ "</p><p><span class=\"skill-xp\">" + xpstr + "</span><span class=\"skill-ranks\">Ranks: " + ranks + "</span></p>"
    + "<p class=\"bubble-row\">"
    + affinityHelper("bubble", "S", aff_STR)
    + affinityHelper("bubble", "D", aff_DEX)
    + affinityHelper("bubble", "C", aff_CON)
    + affinityHelper("bubble", "I", aff_INT)
    + affinityHelper("bubble", "W", aff_WIS)
    + affinityHelper("bubble", "C", aff_CHA)
    + "</p>"
    + "<p class=\"bubble-row\">"
    + affinityHelper("square", "HP", aff_HP)
    + affinityHelper("square", "MP", aff_MP)
    + affinityHelper("square", "RX", aff_RX)
    + "</p>"
}

// root = {
//   HTMLclass: "root",
//   innerHTML: "<p>Root</p>"
// }

// fighter = {
//   parent: root,
//   innerHTML: skillInfo("Fighter", true, false, false, true, true, true, false, false, false)
// }

// specialist = {
//   parent: root,
//   innerHTML: skillInfo("Specialist", false, false, true, false, true, true, true, false, true)
// }

// caster = {
//   parent: root,
//   innerHTML: skillInfo("Caster", false, true, false, false, false, false, true, true, true)
// }

// melee = {
//   parent: fighter,
//   innerHTML: skillInfo("Melee", true, false, false, true, true, true, false, false, false)
// }

// ranged = {
//   parent: fighter,
//   innerHTML: skillInfo("Ranged", true, false, true, false, true, true, false, false, false)
// }

// chart_config = [config, root, fighter, specialist, caster, melee, ranged];



root = {
  HTMLclass: "root",
  innerHTML: "<p>Root</p>"
}

skill0 = {
  parent: root,
  innerHTML: skillInfo("Fight (Str)", true, false, false, true, true, true, false, false, false),
  stackChildren: true
}

skill1 = {
  parent: root,
  innerHTML: skillInfo("Specialist (Dex)", false, false, true, true, true, true, true, true, true),
  stackChildren: true
}

skill2 = {
  parent: root,
  innerHTML: skillInfo("Cast (Int)", false, true, false, false, false, false, true, true, true),
  stackChildren: true
}

skill3 = {
  parent: skill0,
  innerHTML: skillInfo("Melee (Str)", true, false, true, true, false, true, false, false, false),
  stackChildren: true
}

skill4 = {
  parent: skill0,
  innerHTML: skillInfo("Ranged (Dex)", true, false, true, false, true, true, false, false, false),
  stackChildren: true
}

skill5 = {
  parent: root,
  innerHTML: skillInfo("Knowledge (Int)", false, true, true, false, false, false, true, true, false),
  stackChildren: true
}

skill6 = {
  parent: skill5,
  innerHTML: skillInfo("Arcana (Int)", false, true, false, false, false, false, true, true, true),
  stackChildren: true
}

skill7 = {
  parent: skill5,
  innerHTML: skillInfo("Religion (Int)", false, true, false, false, false, false, true, true, true),
  stackChildren: true
}

skill8 = {
  parent: skill5,
  innerHTML: skillInfo("Nature (Int)", false, false, true, false, false, true, true, true, false),
  stackChildren: true
}

skill9 = {
  parent: skill5,
  innerHTML: skillInfo("Engineering (Int)", false, false, true, false, true, false, true, true, false),
  stackChildren: true
}

skill10 = {
  parent: skill5,
  innerHTML: skillInfo("Nobility (Int)", true, false, false, false, false, false, true, true, true),
  stackChildren: true
}

skill11 = {
  parent: skill5,
  innerHTML: skillInfo("Local (Int)", true, false, false, false, false, false, true, true, true),
  stackChildren: true
}

skill12 = {
  parent: skill2,
  innerHTML: skillInfo("Spellcraft (Int)", false, true, false, false, false, false, true, false, true),
  stackChildren: true
}

skill13 = {
  parent: skill12,
  innerHTML: skillInfo("Counterspell (Cha)", false, true, true, false, false, false, false, true, true),
  stackChildren: true
}

skill14 = {
  parent: root,
  innerHTML: skillInfo("Society (Wis)", false, false, true, false, true, false, false, true, true),
  stackChildren: true
}

skill15 = {
  parent: skill14,
  innerHTML: skillInfo("Diplomacy (Cha)", false, false, true, false, true, false, false, true, true),
  stackChildren: true
}

skill16 = {
  parent: skill14,
  innerHTML: skillInfo("Appraise (Int)", false, false, true, false, true, false, false, true, true),
  stackChildren: true
}

skill17 = {
  parent: skill14,
  innerHTML: skillInfo("Intimidate (Cha)", true, false, true, true, false, false, false, false, true),
  stackChildren: true
}

skill18 = {
  parent: skill14,
  innerHTML: skillInfo("Bluff (Cha)", false, false, true, false, true, false, false, true, true),
  stackChildren: true
}

chart_config = [config, root, skill0, skill1, skill2, skill3, skill4, skill5, skill6, skill7, skill8, skill9, skill10, skill11, skill12, skill13, skill14, skill15, skill16, skill17, skill18, ]


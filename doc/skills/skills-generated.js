
root = {
  HTMLclass: "root",
  innerHTML: "<p>Root</p>"
}

skill0 = {
  parent: root,
    innerHTML: skillInfo("Fighter", true, false, false, true, true, true, false, false, false)
}

skill1 = {
  parent: root,
    innerHTML: skillInfo("Specialist", false, false, true, true, true, true, true, true, true)
}

skill2 = {
  parent: root,
    innerHTML: skillInfo("Caster", false, true, false, false, false, false, true, true, true)
}

skill3 = {
  parent: skill0,
    innerHTML: skillInfo("Melee", true, false, true, true, false, true, false, false, false)
}

skill4 = {
  parent: skill0,
    innerHTML: skillInfo("Ranged", true, false, true, false, true, true, false, false, false)
}

chart_config = [config, root, skill0, skill1, skill2, skill3, skill4, ]


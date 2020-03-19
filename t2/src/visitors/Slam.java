package visitors;

import constants.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;


public final class Slam implements HeroVisitor {

    private int baseDamage = Constants.BASE_DMG_SLAM;
    private int damageLevel = Constants.DMG_LEVEL_SLAM;
    private Knight attacker;

    public Slam(final Knight knight) {
        attacker = knight;
    }

    @Override
    public int visit(final Rogue r) {
        float landModif = attacker.getLandModif();
        float raceModif = 1f + r.getRaceModif().get(Constants.INDEX_SLAM);

        // calculez damage-ul oferit
        return Math.round(Math.round((baseDamage + attacker.getLevel() * damageLevel)
                            * landModif) * raceModif);
    }

    @Override
    public int visit(final Knight k) {
        float landModif = attacker.getLandModif();
        float raceModif = 1f + k.getRaceModif().get(Constants.INDEX_SLAM);
        return Math.round(Math.round((baseDamage + attacker.getLevel() * damageLevel)
                            * landModif) * raceModif);
    }

    @Override
    public int visit(final Pyromancer p) {
        float landModif = attacker.getLandModif();
        float raceModif = 1f + p.getRaceModif().get(Constants.INDEX_SLAM);
        return Math.round(Math.round((baseDamage + attacker.getLevel() * damageLevel)
                            * landModif) * raceModif);
    }

    @Override
    public int visit(final Wizard w) {
        float landModif = attacker.getLandModif();
        float raceModif = 1f + w.getRaceModif().get(Constants.INDEX_SLAM);
        return Math.round(Math.round((baseDamage + attacker.getLevel() * damageLevel)
                            * landModif) * raceModif);
    }
}

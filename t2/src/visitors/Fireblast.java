package visitors;

import constants.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public final class Fireblast implements HeroVisitor {

    private Pyromancer attacker;

    public Fireblast(final Pyromancer pyro) {
        attacker = pyro;
    }

   @Override
    public int visit(final Rogue r) {
        float landModif = attacker.getLandModif();
       float raceModif = 1f + r.getRaceModif().get(Constants.INDEX_FIREBLAST);
        // calculez damage-ul oferit
        return Math.round(Math.round((Constants.BASE_DMG_FIREBLAST
                + attacker.getLevel() * Constants.DMG_LEVEL_FIREBLAST) * landModif)
                * raceModif);
    }

    @Override
    public int visit(final Knight k) {
        float landModif = attacker.getLandModif();
        float raceModif = 1f + k.getRaceModif().get(Constants.INDEX_FIREBLAST);
        return Math.round(Math.round((Constants.BASE_DMG_FIREBLAST
                + attacker.getLevel() * Constants.DMG_LEVEL_FIREBLAST) * landModif)
                * raceModif);
    }

    @Override
    public int visit(final Pyromancer p) {
        float landModif = attacker.getLandModif();
        float raceModif = 1f + p.getRaceModif().get(Constants.INDEX_FIREBLAST);
        return Math.round(Math.round((Constants.BASE_DMG_FIREBLAST
                + attacker.getLevel() * Constants.DMG_LEVEL_FIREBLAST) * landModif)
                * raceModif);
    }

    @Override
    public int visit(final Wizard w) {
        float landModif = attacker.getLandModif();
        float raceModif = 1f + w.getRaceModif().get(Constants.INDEX_FIREBLAST);
        return Math.round(Math.round((Constants.BASE_DMG_FIREBLAST
                + attacker.getLevel() * Constants.DMG_LEVEL_FIREBLAST) * landModif)
                * raceModif);
    }
}

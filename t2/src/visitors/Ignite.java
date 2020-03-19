package visitors;

import constants.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public final class Ignite implements HeroVisitor {

    private Pyromancer attacker;

    public Ignite(final Pyromancer pyro) {
        attacker = pyro;
    }

    @Override
    public int visit(final Rogue r) {
        float landModif = attacker.getLandModif();
        float raceModif = 1f + r.getRaceModif().get(Constants.INDEX_IGNITE);
        // setez damage-ul overtime si numarul de runde overtime
        r.getDamageOvertime().setTime(2);
        r.getDamageOvertime().setDmg(Math.round((Constants.DMG_NEXT_ROUNDS_IGNITE
                        + attacker.getLevel() * Constants.DMG_LEVEL_NEXT_ROUNDS_IGNITE)
                        * landModif * Constants.RACE_MODIF_ROGUE_IGNITE));
        return Math.round(Math.round((Constants.BASE_DMG_FIRST_ROUND_IGNITE
                    + attacker.getLevel() * Constants.DMG_LEVEL_FIRST_ROUND_IGNITE) * landModif)
                            * raceModif);
    }

    @Override
    public int visit(final Knight k) {
        float landModif = attacker.getLandModif();
        float raceModif = 1f + k.getRaceModif().get(Constants.INDEX_IGNITE);
        k.getDamageOvertime().setTime(2);
        k.getDamageOvertime().setDmg(Math.round((Constants.DMG_NEXT_ROUNDS_IGNITE
                + attacker.getLevel() * Constants.DMG_LEVEL_NEXT_ROUNDS_IGNITE)
                * landModif * Constants.RACE_MODIF_KNIGHT_IGNITE));
        return Math.round(Math.round((Constants.BASE_DMG_FIRST_ROUND_IGNITE
                + attacker.getLevel() * Constants.DMG_LEVEL_FIRST_ROUND_IGNITE)
                * landModif) * raceModif);
    }

    @Override
    public int visit(final Pyromancer p) {
        float landModif = attacker.getLandModif();
        float raceModif = 1f + p.getRaceModif().get(Constants.INDEX_IGNITE);
        p.getDamageOvertime().setTime(2);
        p.getDamageOvertime().setDmg(Math.round((Constants.DMG_NEXT_ROUNDS_IGNITE
                + attacker.getLevel() * Constants.DMG_LEVEL_NEXT_ROUNDS_IGNITE)
                * landModif * Constants.RACE_MODIF_PYRO_IGNITE));
        return Math.round(Math.round((Constants.BASE_DMG_FIRST_ROUND_IGNITE
                + attacker.getLevel() * Constants.DMG_LEVEL_FIRST_ROUND_IGNITE)
                * landModif) * raceModif);
    }

    @Override
    public int visit(final Wizard w) {
        float landModif = attacker.getLandModif();
        float raceModif = 1f + w.getRaceModif().get(Constants.INDEX_IGNITE);
        w.getDamageOvertime().setTime(2);
        w.getDamageOvertime().setDmg(Math.round((Constants.DMG_NEXT_ROUNDS_IGNITE
                + attacker.getLevel() * Constants.DMG_LEVEL_NEXT_ROUNDS_IGNITE)
                * landModif * Constants.RACE_MODIF_WIZARD_IGNITE));
        return Math.round(Math.round((Constants.BASE_DMG_FIRST_ROUND_IGNITE
                + attacker.getLevel() * Constants.DMG_LEVEL_FIRST_ROUND_IGNITE) * landModif)
                * raceModif);
    }
}

package visitors;

import constants.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public final class Paralysis implements HeroVisitor {

    private Rogue attacker;

    public Paralysis(final Rogue r) {
        attacker = r;
    }

    @Override
    public int visit(final Rogue r) {
        float landModif = attacker.getLandModif();
        float raceModif = 1f + r.getRaceModif().get(Constants.INDEX_PARALYSIS);
        // verific daca atacatorul se afla pe teren de tip woods
        // si setez rundele overtime si damage-ul overtime
        if (landModif == Constants.INITIAL_LAND_MODIFIER + Constants.ROGUE_LAND_MODIFIER) {
            r.getDamageOvertime().setTime(Constants.OVERTIME_ROUNDS_WOODS);
            r.getDamageOvertime().setDmg(Math.round(Math.round((Constants.BASE_DMG_PARALYSIS
                            + attacker.getLevel() * Constants.DMG_LEVEL_PARALYSIS) * landModif)
                                * raceModif));
        }
        if (landModif == Constants.INITIAL_LAND_MODIFIER) {
            r.getDamageOvertime().setTime(Constants.OVERTIME_ROUNDS);
            r.getDamageOvertime().setDmg(Math.round(Math.round((Constants.BASE_DMG_PARALYSIS
                            + attacker.getLevel() * Constants.DMG_LEVEL_PARALYSIS) * landModif)
                                * raceModif));
        }
        return Math.round(Math.round((Constants.BASE_DMG_PARALYSIS + attacker.getLevel()
                            * Constants.DMG_LEVEL_PARALYSIS) * landModif) * raceModif);
    }

    @Override
    public int visit(final Knight k) {
        float landModif = attacker.getLandModif();
        float raceModif = 1f + k.getRaceModif().get(Constants.INDEX_PARALYSIS);
        if (landModif == Constants.INITIAL_LAND_MODIFIER + Constants.ROGUE_LAND_MODIFIER) {
            k.getDamageOvertime().setTime(Constants.OVERTIME_ROUNDS_WOODS);
            k.getDamageOvertime().setDmg(Math.round(Math.round((Constants.BASE_DMG_PARALYSIS
                            + attacker.getLevel() * Constants.DMG_LEVEL_PARALYSIS) * landModif)
                                * raceModif));
        }
        if (landModif == Constants.INITIAL_LAND_MODIFIER) {
            k.getDamageOvertime().setTime(Constants.OVERTIME_ROUNDS);
            k.getDamageOvertime().setDmg(Math.round(Math.round((Constants.BASE_DMG_PARALYSIS
                            + attacker.getLevel() * Constants.DMG_LEVEL_PARALYSIS) * landModif)
                                * raceModif));
        }
        return Math.round(Math.round((Constants.BASE_DMG_PARALYSIS + attacker.getLevel()
                        * Constants.DMG_LEVEL_PARALYSIS) * landModif) * raceModif);
    }

    @Override
    public int visit(final Pyromancer p) {
        float landModif = attacker.getLandModif();
        float raceModif = 1f + p.getRaceModif().get(Constants.INDEX_PARALYSIS);
        if (landModif == Constants.INITIAL_LAND_MODIFIER + Constants.ROGUE_LAND_MODIFIER) {
            p.getDamageOvertime().setTime(Constants.OVERTIME_ROUNDS_WOODS);
            p.getDamageOvertime().setDmg(Math.round(Math.round((Constants.BASE_DMG_PARALYSIS
                            + attacker.getLevel() * Constants.DMG_LEVEL_PARALYSIS) * landModif)
                                * raceModif));
        }
        if (landModif == Constants.INITIAL_LAND_MODIFIER) {
            p.getDamageOvertime().setTime(Constants.OVERTIME_ROUNDS);
            p.getDamageOvertime().setDmg(Math.round(Math.round((Constants.BASE_DMG_PARALYSIS
                           + attacker.getLevel() * Constants.DMG_LEVEL_PARALYSIS) * landModif)
                            * raceModif));
        }
        return Math.round(Math.round((Constants.BASE_DMG_PARALYSIS + attacker.getLevel()
                        * Constants.DMG_LEVEL_PARALYSIS) * landModif) * raceModif);
    }

    @Override
    public int visit(final Wizard w) {
        float landModif = attacker.getLandModif();
        float raceModif = 1f + w.getRaceModif().get(Constants.INDEX_PARALYSIS);
        if (landModif == Constants.INITIAL_LAND_MODIFIER + Constants.ROGUE_LAND_MODIFIER) {
            w.getDamageOvertime().setTime(Constants.OVERTIME_ROUNDS_WOODS);
            w.getDamageOvertime().setDmg(Math.round(Math.round((Constants.BASE_DMG_PARALYSIS
                            + attacker.getLevel() * Constants.DMG_LEVEL_PARALYSIS) * landModif)
                            * raceModif));
        }
        if (landModif == Constants.INITIAL_LAND_MODIFIER) {
            w.getDamageOvertime().setTime(Constants.OVERTIME_ROUNDS);
            w.getDamageOvertime().setDmg(Math.round(Math.round((Constants.BASE_DMG_PARALYSIS
                            + attacker.getLevel() * Constants.DMG_LEVEL_PARALYSIS) * landModif)
                                * raceModif));
        }
        return Math.round(Math.round((Constants.BASE_DMG_PARALYSIS + attacker.getLevel()
                        * Constants.DMG_LEVEL_PARALYSIS) * landModif) * raceModif);
    }
}

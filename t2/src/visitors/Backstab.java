package visitors;

import constants.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public final class Backstab implements HeroVisitor {

    private  Rogue attacker;

    public Backstab(final Rogue rogue) {
        attacker = rogue;
    }

    @Override
    public int visit(final Rogue r) {
        float landModif = attacker.getLandModif();
        float raceModif = 1f + r.getRaceModif().get(Constants.INDEX_BACKSTAB);
        // verific de cate ori a atacat si daca se afla pe terenul
        //de tip Woods pentru a da adversarului damage overtime
        // si resetez numarul de atacuri asupra adversarului
        if (attacker.getNoAttacks() % Constants.POWERFULL_HIT == 0
                && attacker.getLandModif() == Constants.INITIAL_LAND_MODIFIER
                                            + Constants.ROGUE_LAND_MODIFIER) {
            landModif *= Constants.OVERTIME_FACTOR;
        }
        attacker.setNoAttacks(attacker.getNoAttacks() + 1);
        return Math.round(Math.round((Constants.BASE_DMG_BACKSTAB + attacker.getLevel()
                            * Constants.DMG_LEVEL_BACKSTAB) * landModif) * raceModif);
    }

    @Override
    public int visit(final Knight k) {
        float landModif = attacker.getLandModif();
        float raceModif = 1f + k.getRaceModif().get(Constants.INDEX_BACKSTAB);
        if (attacker.getNoAttacks() % Constants.POWERFULL_HIT == 0
                && attacker.getLandModif() == Constants.INITIAL_LAND_MODIFIER
                                + Constants.ROGUE_LAND_MODIFIER) {
            landModif *= Constants.OVERTIME_FACTOR;
        }
        attacker.setNoAttacks(attacker.getNoAttacks() + 1);
        return Math.round(Math.round((Constants.BASE_DMG_BACKSTAB + attacker.getLevel()
                         * Constants.DMG_LEVEL_BACKSTAB) * landModif) * raceModif);
    }

    @Override
    public int visit(final Pyromancer p) {
        float landModif = attacker.getLandModif();
        float raceModif = 1f + p.getRaceModif().get(Constants.INDEX_BACKSTAB);
        if (attacker.getNoAttacks() % Constants.POWERFULL_HIT == 0
                && attacker.getLandModif() == Constants.INITIAL_LAND_MODIFIER
                        + Constants.ROGUE_LAND_MODIFIER) {
            landModif *= Constants.OVERTIME_FACTOR;
        }
        attacker.setNoAttacks(attacker.getNoAttacks() + 1);
        return Math.round(Math.round((Constants.BASE_DMG_BACKSTAB + attacker.getLevel()
                        * Constants.DMG_LEVEL_BACKSTAB) * landModif) * raceModif);
    }

    @Override
    public int visit(final Wizard w) {
        float landModif = attacker.getLandModif();
        float raceModif = 1f + w.getRaceModif().get(Constants.INDEX_BACKSTAB);
        if (attacker.getNoAttacks() % Constants.POWERFULL_HIT == 0
                && attacker.getLandModif() == Constants.INITIAL_LAND_MODIFIER
                    + Constants.ROGUE_LAND_MODIFIER) {
            landModif *= Constants.OVERTIME_FACTOR;
        }
        attacker.setNoAttacks(attacker.getNoAttacks() + 1);
        return Math.round(Math.round((Constants.BASE_DMG_BACKSTAB + attacker.getLevel()
                            * Constants.DMG_LEVEL_BACKSTAB) * landModif) * raceModif);
    }
}

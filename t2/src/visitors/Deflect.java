package visitors;

import constants.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public final class Deflect implements HeroVisitor {

    private float procent = Constants.PROCENT_DEFLECT;
    private float procentLevel = Constants.PROCENT_LEVEL_DEFLECT;
    private Wizard attacker;

    public Deflect(final Wizard wizard) {
        this.attacker = wizard;
    }

    @Override
    public int visit(final Rogue r) {
        int dmg = r.damageGiven();
        float raceModif = 1f + r.getRaceModif().get(Constants.INDEX_DEFLECT);
        float landModif = attacker.getLandModif();
        // Calculez procentul pentru a putea oferi
        // damage adversarului in functie de valoarea acestuia
        // si daca se afla pe terenul de tip Woods
         procent += procentLevel * attacker.getLevel();
        // verific cate atacuri a avut Rogue asupra Wizard-ului
        // si daca se afla pe terenul de tip Woods
        if (r.getNoAttacks() % Constants.POWERFULL_HIT == 0
                && r.getLandModif() == Constants.INITIAL_LAND_MODIFIER
                + Constants.ROGUE_LAND_MODIFIER) {
            return Math.round(procent * Math.round(dmg * (Constants.OVERTIME_FACTOR))
                            * raceModif * landModif);
        }
        return Math.round(procent * dmg * raceModif * landModif);
    }

    @Override
    public int visit(final Knight k) {
        int dmg = k.damageGiven();
        float raceModif = 1f + k.getRaceModif().get(Constants.INDEX_DEFLECT);
        float landModif = attacker.getLandModif();
        procent += procentLevel * attacker.getLevel();
        return Math.round(procent * dmg * raceModif * landModif);
    }

    @Override
    public int visit(final Pyromancer p) {
        int dmg = p.damageGiven();
        float raceModif = 1f + p.getRaceModif().get(Constants.INDEX_DEFLECT);
        float landModif = attacker.getLandModif();
        procent += procentLevel * attacker.getLevel();
        return Math.round(procent * dmg * raceModif * landModif);

    }

    @Override
    public int visit(final Wizard w) {
        return 0;
    }
}

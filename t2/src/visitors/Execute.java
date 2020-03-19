package visitors;

import constants.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public final class Execute implements HeroVisitor {
    private int baseDamage = Constants.BASE_DMG_EXECUTE;
    private int damageLevel = Constants.DMG_LEVEL_EXECUTE;
    private Knight attacker;

    public Execute(final Knight knight) {
        this.attacker = knight;
    }

    @Override
    public int visit(final Rogue r) {
        float landModif = attacker.getLandModif();
        float raceModif = 1f + r.getRaceModif().get(Constants.INDEX_EXECUTE);
        float hpLimit = Constants.HP_LIMIT * r.getMaxHP();
        // verific daca hp-ul adversarului este sub limita
        // daca este, acesta va fi omorat direct
        if (r.getCurrentHp() < hpLimit) {
            return -1;
        }
        return Math.round(Math.round((baseDamage + attacker.getLevel() * damageLevel)
                            * landModif) * raceModif);
    }

    @Override
    public int visit(final Knight k) {
        float landModif = attacker.getLandModif();
        float raceModif = 1f + k.getRaceModif().get(Constants.INDEX_EXECUTE);
        float hpLimit = Constants.HP_LIMIT * k.getMaxHP();
        if (k.getCurrentHp() < hpLimit) {
            return -1;
        }
        return Math.round(Math.round((baseDamage + attacker.getLevel() * damageLevel)
                            * landModif) * raceModif);
    }

    @Override
    public int visit(final Pyromancer p) {
        float landModif = attacker.getLandModif();
        float raceModif = 1f + p.getRaceModif().get(Constants.INDEX_EXECUTE);
        float hpLimit = Constants.HP_LIMIT * p.getMaxHP();
        if (p.getCurrentHp() < hpLimit) {
            return -1;
        }
        return Math.round(Math.round((baseDamage + attacker.getLevel() * damageLevel)
                            * landModif) * raceModif);
    }

    @Override
    public int visit(final Wizard w) {
        float landModif = attacker.getLandModif();
        float raceModif = 1f + w.getRaceModif().get(Constants.INDEX_EXECUTE);
        float hpLimit = Constants.HP_LIMIT * w.getMaxHP();
        if (w.getCurrentHp() < hpLimit) {
            return -1;
        }
        return Math.round(Math.round((baseDamage + attacker.getLevel() * damageLevel)
                        * landModif) * raceModif);
    }
}

package heroes;

import angelsvisitors.AngelVisitor;
import constants.Constants;
import input.Position;
import map.FieldSingleton;
import strategies.PyroLowDmgHighHP;
import strategies.PyroLowHPHighDmg;
import strategies.Strategy;
import visitors.Fireblast;
import visitors.HeroVisitor;
import visitors.Ignite;


public final class Pyromancer extends Hero {
    public Pyromancer(final String name, final Position p) {
        super(name, p);
        currentHp = hpMax = Constants.HP_INITIAL_PYROMANCER;
        hpLevel = Constants.HP_LEVEL_PYROMANCER;
        raceModif.add(Constants.RACE_MODIF_PYRO_EXECUTE);
        raceModif.add(Constants.RACE_MODIF_PYRO_SLAM);
        raceModif.add(Constants.RACE_MODIF_PYRO_FIREBLAST);
        raceModif.add(Constants.RACE_MODIF_PYRO_IGNITE);
        raceModif.add(Constants.RACE_MODIF_PYRO_BACKSTAB);
        raceModif.add(Constants.RACE_MODIF_PYRO_PARALYSIS);
        raceModif.add(Constants.RACE_MODIF_PYRO_DRAIN);
        raceModif.add(Constants.RACE_MODIF_PYRO_DEFLECT);
    }

    public int getMaxHP() {
        return hpMax + this.getLevel() * hpLevel;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    @Override
    public int damageGiven() {
        int dmgFire, dmgIgnite;
        int baseDmgFire = Constants.BASE_DMG_FIREBLAST;
        int dmgLevelFire = Constants.DMG_LEVEL_FIREBLAST;
        int baseDmgIgnite = Constants.BASE_DMG_FIRST_ROUND_IGNITE;
        int dmgLevelIgnite = Constants.DMG_LEVEL_FIRST_ROUND_IGNITE;
        dmgFire = Math.round((baseDmgFire + this.getLevel() * dmgLevelFire)
                                * this.getLandModif());
        dmgIgnite = Math.round((baseDmgIgnite + this.getLevel() * dmgLevelIgnite)
                                * this.getLandModif());
        return dmgFire + dmgIgnite;
    }

    @Override
    public void accept(final HeroVisitor h) {
        float dmg = h.visit(this);
        currentHp -= dmg;
    }

    @Override
    public void accept(final AngelVisitor angelVisitor) {
        angelVisitor.visit(this);
    }

    @Override
    public void attack(final Hero h) {
        Fireblast fire = new Fireblast(this);
        Ignite ignite = new Ignite(this);
        h.accept(fire);
        h.accept(ignite);
    }

    @Override
    public void applyStrategy() {
        Strategy strategy;
        if (hpMax / Constants.PYRO_DIVIDER_S_1_1 < currentHp
                && currentHp < hpMax / Constants.PYRO_DIVIDER_S_1_2) {
            strategy = new PyroLowHPHighDmg();
            strategy.modifyDmg(this);
            strategy.modifyHp(this);
        } else if (currentHp < hpMax / Constants.PYRO_DIVIDER_S_2) {
            strategy = new PyroLowDmgHighHP();
            strategy.modifyHp(this);
            strategy.modifyDmg(this);
        }
    }

    @Override
    public float getLandModif() {
        int x = this.getP().getX();
        int y = this.getP().getY();
        if (FieldSingleton.getInstance().getFieldsNames()[x][y] == 'V') {
            return super.getLandModif() + Constants.PYRO_LAND_MODIFIER;
        }
        return super.getLandModif();

    }
}

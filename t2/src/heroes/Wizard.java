package heroes;

import angelsvisitors.AngelVisitor;
import constants.Constants;
import input.Position;
import map.FieldSingleton;
import strategies.Strategy;
import strategies.WizardLowDmgHighHP;
import strategies.WizardLowHPHighDmg;
import visitors.Deflect;
import visitors.Drain;
import visitors.HeroVisitor;


public final class Wizard extends Hero {
    public Wizard(final String name, final Position p) {
        super(name, p);
        hpMax = currentHp = Constants.HP_INITIAL_WIZARD;
        hpLevel = Constants.HP_LEVEL_WIZARD;
        raceModif.add(Constants.RACE_MODIF_WIZARD_EXECUTE);
        raceModif.add(Constants.RACE_MODIF_WIZARD_SLAM);
        raceModif.add(Constants.RACE_MODIF_WIZARD_FIREBLAST);
        raceModif.add(Constants.RACE_MODIF_WIZARD_IGNITE);
        raceModif.add(Constants.RACE_MODIF_WIZARD_BACKSTAB);
        raceModif.add(Constants.RACE_MODIF_WIZARD_PARALYSIS);
        raceModif.add(Constants.RACE_MODIF_WIZARD_DRAIN);
        raceModif.add(0f);
    }

    public int getMaxHP() {
        return hpMax + this.getLevel() * hpLevel;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    @Override
    public void applyStrategy() {
        Strategy strategy;
        if (hpMax / Constants.WIZARD_DIVIDER_S_1_1 < currentHp
                && currentHp < hpMax / Constants.WIZARD_DIVIDER_S_1_2) {
            strategy = new WizardLowHPHighDmg();
            strategy.modifyDmg(this);
            strategy.modifyHp(this);
        } else if (currentHp < hpMax / Constants.WIZARD_DIVIDER_S_2) {
            strategy = new WizardLowDmgHighHP();
            strategy.modifyHp(this);
            strategy.modifyDmg(this);
        }
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
    public int damageGiven() {
        return 0;
    }

    @Override
    public void attack(final Hero h) {
        Deflect deflect = new Deflect(this);
        Drain drain = new Drain(this);
        h.accept(deflect);
        h.accept(drain);

    }

    @Override
    public float getLandModif() {
        int x = this.getP().getX();
        int y = this.getP().getY();
        if (FieldSingleton.getInstance().getFieldsNames()[x][y] == 'D') {
            return super.getLandModif() + Constants.WIZARD_LAND_MODIFIER;
        }
        return super.getLandModif();
    }
}

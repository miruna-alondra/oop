package heroes;

import angelsvisitors.AngelVisitor;
import constants.Constants;
import input.Position;
import map.FieldSingleton;
import strategies.KnightLowDmgHighHP;
import strategies.KnightLowHPHighDmg;
import strategies.Strategy;
import visitors.Execute;
import visitors.HeroVisitor;
import visitors.Slam;


public final class Knight extends Hero {
    public Knight(final String name, final Position p) {
        super(name, p);
        hpMax  = currentHp = Constants.HP_INITIAL_KNIGHT;
        hpLevel = Constants.HP_LEVEL_KNIGHT;
        raceModif.add(0f);
        raceModif.add(Constants.RACE_MODIF_KNIGHT_SLAM);
        raceModif.add(Constants.RACE_MODIF_KNIGHT_FIREBLAST);
        raceModif.add(Constants.RACE_MODIF_KNIGHT_IGNITE);
        raceModif.add(Constants.RACE_MODIF_KNIGHT_BACKSTAB);
        raceModif.add(Constants.RACE_MODIF_KNIGHT_PARALYSIS);
        raceModif.add(Constants.RACE_MODIF_KNIGHT_DRAIN);
        raceModif.add(Constants.RACE_MODIF_KNIGHT_DEFLECT);
    }

    /**
     *
     * @return valoarea maxima a hp-ului a eroului
     */
    public int getMaxHP() {
        return hpMax + this.getLevel() * hpLevel;
    }

    public int getCurrentHp() {
        return super.getCurrentHp();
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
        int dmgEx, dmgSlam;
        int baseDmgEx = Constants.BASE_DMG_EXECUTE;
        int dmgLevelEx = Constants.DMG_LEVEL_EXECUTE;
        int baseDmgSlam = Constants.BASE_DMG_SLAM;
        int dmgLevelSlam = Constants.DMG_LEVEL_SLAM;
        dmgEx = Math.round((baseDmgEx + this.getLevel() * dmgLevelEx) * this.getLandModif());
        dmgSlam = Math.round((baseDmgSlam + this.getLevel() * dmgLevelSlam) * this.getLandModif());
        return dmgEx + dmgSlam;

    }

    @Override
    public void attack(final Hero h) {
        Execute ex = new Execute(this);
        Slam slam = new Slam(this);
        h.accept(ex);
        h.accept(slam);
    }

    @Override
    public void applyStrategy() {
        Strategy strategy;
        if ((hpMax / Constants.KNIGHT_DIVIDER_S_1_1) < currentHp
                && currentHp < (hpMax / Constants.KNIGHT_DIVIDER_S_1_2)) {
            strategy = new KnightLowHPHighDmg();
            strategy.modifyDmg(this);
            strategy.modifyHp(this);
        } else if (currentHp < hpMax / Constants.KNIGHT_DIVIDER_S_2) {
            strategy = new KnightLowDmgHighHP();
            strategy.modifyHp(this);
            strategy.modifyDmg(this);
        }
    }

    @Override
    public float getLandModif() {
        int x = this.getP().getX();
        int y = this.getP().getY();
        if (FieldSingleton.getInstance().getFieldsNames()[x][y] == 'L') {
            return super.getLandModif() + Constants.KNIGHT_LAND_MODIFIER;
        }
        return super.getLandModif();
    }
}

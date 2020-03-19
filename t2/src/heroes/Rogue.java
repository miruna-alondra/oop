package heroes;

import angelsvisitors.AngelVisitor;
import constants.Constants;
import input.Position;
import map.FieldSingleton;
import strategies.RogueLowDmgHighHP;
import strategies.RogueLowHPHighDmg;
import strategies.Strategy;
import visitors.Backstab;
import visitors.HeroVisitor;
import visitors.Paralysis;


public final class Rogue extends Hero {
    private int noAttacks;
    public Rogue(final String name, final Position p) {
        super(name, p);
        hpMax = currentHp = Constants.HP_INITIAL_ROGUE;
        hpLevel = Constants.HP_LEVEL_ROGUE;
        noAttacks = 0;
        raceModif.add(Constants.RACE_MODIF_ROGUE_EXECUTE);
        raceModif.add(Constants.RACE_MODIF_ROGUE_SLAM);
        raceModif.add(Constants.RACE_MODIF_ROGUE_FIREBLAST);
        raceModif.add(Constants.RACE_MODIF_ROGUE_IGNITE);
        raceModif.add(Constants.RACE_MODIF_ROGUE_BACKSTAB);
        raceModif.add(Constants.RACE_MODIF_ROGUE_PARALYSIS);
        raceModif.add(Constants.RACE_MODIF_ROGUE_DRAIN);
        raceModif.add(Constants.RACE_MODIF_ROGUE_DEFLECT);
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
        if (hpMax / Constants.ROGUE_DIVIDER_S_1_1 < currentHp
                && currentHp < hpMax / Constants.ROGUE_DIVIDER_S_1_2) {
            strategy = new RogueLowHPHighDmg();
            strategy.modifyDmg(this);
            strategy.modifyHp(this);
        } else if (currentHp < hpMax / Constants.ROGUE_DIVIDER_S_2) {
            strategy = new RogueLowDmgHighHP();
            strategy.modifyHp(this);
            strategy.modifyDmg(this);
        }
    }

    public int getNoAttacks() {
        return noAttacks;
    }

    public void setNoAttacks(final int noAttacks) {
        this.noAttacks = noAttacks;
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
        int dmgBack, dmgPara;
        int baseDmgBack = Constants.BASE_DMG_BACKSTAB;
        int dmgLevelBack = Constants.DMG_LEVEL_BACKSTAB;
        int baseDmgPara = Constants.BASE_DMG_PARALYSIS;
        int dmgLevelPara = Constants.DMG_LEVEL_PARALYSIS;
        float landModif = this.getLandModif();
        dmgBack = Math.round((baseDmgBack + this.getLevel() * dmgLevelBack) * landModif);
        dmgPara = Math.round((baseDmgPara + this.getLevel() * dmgLevelPara) * landModif);
        return dmgBack + dmgPara;
    }

    @Override
    public void attack(final Hero h) {
        Backstab backstab = new Backstab(this);
        Paralysis paralysis = new Paralysis(this);
        h.accept(backstab);
        h.accept(paralysis);
    }

    @Override
    public float getLandModif() {
        int x = this.getP().getX();
        int y = this.getP().getY();
        if (FieldSingleton.getInstance().getFieldsNames()[x][y] == 'W') {
            return super.getLandModif() + Constants.ROGUE_LAND_MODIFIER;
        }
        return super.getLandModif();
    }
}

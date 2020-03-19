package angelsvisitors;

import angels.LevelUpAngel;
import constants.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import java.util.ArrayList;
import java.util.List;

public final class LevelUpVisitor implements AngelVisitor {
    private LevelUpAngel angel;
    private List<Float> raceModif = new ArrayList<>();

    public LevelUpVisitor(final LevelUpAngel levelUpAngel) {
        angel = levelUpAngel;
    }

    // Schimb modificatorii de rasa ai fiecarui jucator
    // si ii ofer xp necesar pentru a trece la
    // urmatorul nivel si actualizez nivelul
    @Override
    public void visit(final Knight k) {
        for (int i = 0; i < Constants.NO_POWERS; i++) {
            raceModif.add(k.getRaceModif().get(i) + Constants.LEVEL_UP_HIGH_DMG_KNIGHT);
        }
        k.setRaceModif(raceModif);
        switch (k.getLevel()) {
            case 0:
                k.setXp(Constants.UPDATE_LEVEL_1);
                k.updateLevel();
                k.setCurrentHp(k.getMaxHP() + k.getLevel() * Constants.HP_LEVEL_KNIGHT);
            case Constants.LEVEL_1:
                k.setXp(Constants.UPDATE_LEVEL_2);
                k.updateLevel();
                k.setCurrentHp(k.getMaxHP() + k.getLevel() * Constants.HP_LEVEL_KNIGHT);
            case Constants.LEVEL_2:
                k.setXp(Constants.UPDATE_LEVEL_3);
                k.updateLevel();
                k.setCurrentHp(k.getMaxHP() + k.getLevel() * Constants.HP_LEVEL_KNIGHT);
            case Constants.LEVEL_3:
                k.setXp(Constants.UPDATE_LEVEL_4);
                k.updateLevel();
                k.setCurrentHp(k.getMaxHP() + k.getLevel() * Constants.HP_LEVEL_KNIGHT);
            case Constants.LEVEL_4:
                k.setXp(Constants.UPDATE_LEVEL_5);
                k.updateLevel();
                k.setCurrentHp(k.getMaxHP() + k.getLevel() * Constants.HP_LEVEL_KNIGHT);
            case Constants.LEVEL_5:
                k.setXp(Constants.UPDATE_LEVEL_6);
                k.updateLevel();
                k.setCurrentHp(k.getMaxHP() + k.getLevel() * Constants.HP_LEVEL_KNIGHT);
            default:
        }
    }

    @Override
    public void visit(final Pyromancer p) {
        for (int i = 0; i < Constants.NO_POWERS; i++) {
            raceModif.add(p.getRaceModif().get(i) + Constants.LEVEL_UP_HIGH_DMG_PYRO);
        }
        p.setRaceModif(raceModif);
        switch (p.getLevel()) {
            case 0:
                p.setXp(Constants.UPDATE_LEVEL_1);
                p.updateLevel();
                p.setCurrentHp(p.getMaxHP() + p.getLevel() * Constants.HP_LEVEL_PYROMANCER);
            case Constants.LEVEL_1:
                p.setXp(Constants.UPDATE_LEVEL_2);
                p.updateLevel();
                p.setCurrentHp(p.getMaxHP() + p.getLevel() * Constants.HP_LEVEL_PYROMANCER);
            case Constants.LEVEL_2:
                p.setXp(Constants.UPDATE_LEVEL_3);
                p.updateLevel();
                p.setCurrentHp(p.getMaxHP() + p.getLevel() * Constants.HP_LEVEL_PYROMANCER);
            case Constants.LEVEL_3:
                p.setXp(Constants.UPDATE_LEVEL_4);
                p.updateLevel();
                p.setCurrentHp(p.getMaxHP() + p.getLevel() * Constants.HP_LEVEL_PYROMANCER);
            case Constants.LEVEL_4:
                p.setXp(Constants.UPDATE_LEVEL_5);
                p.updateLevel();
                p.setCurrentHp(p.getMaxHP() + p.getLevel() * Constants.HP_LEVEL_PYROMANCER);
            case Constants.LEVEL_5:
                p.setXp(Constants.UPDATE_LEVEL_6);
                p.updateLevel();
                p.setCurrentHp(p.getMaxHP() + p.getLevel() * Constants.HP_LEVEL_PYROMANCER);
            default:
        }
    }

    @Override
    public void visit(final Rogue r) {
        for (int i = 0; i < Constants.NO_POWERS; i++) {
            raceModif.add(r.getRaceModif().get(i) + Constants.LEVEL_UP_HIGH_DMG_ROGUE);
        }
        r.setRaceModif(raceModif);
        switch (r.getLevel()) {
            case 0:
                r.setXp(Constants.UPDATE_LEVEL_1);
                r.updateLevel();
                r.setCurrentHp(r.getMaxHP() + r.getLevel() * Constants.HP_LEVEL_ROGUE);
            case Constants.LEVEL_1:
                r.setXp(Constants.UPDATE_LEVEL_2);
                r.updateLevel();
                r.setCurrentHp(r.getMaxHP() + r.getLevel() * Constants.HP_LEVEL_ROGUE);
            case Constants.LEVEL_2:
                r.setXp(Constants.UPDATE_LEVEL_3);
                r.updateLevel();
                r.setCurrentHp(r.getMaxHP() + r.getLevel() * Constants.HP_LEVEL_ROGUE);
            case Constants.LEVEL_3:
                r.setXp(Constants.UPDATE_LEVEL_4);
                r.updateLevel();
                r.setCurrentHp(r.getMaxHP() + r.getLevel() * Constants.HP_LEVEL_ROGUE);
            case Constants.LEVEL_4:
                r.setXp(Constants.UPDATE_LEVEL_5);
                r.updateLevel();
                r.setCurrentHp(r.getMaxHP() + r.getLevel() * Constants.HP_LEVEL_ROGUE);
            case Constants.LEVEL_5:
                r.setXp(Constants.UPDATE_LEVEL_6);
                r.updateLevel();
                r.setCurrentHp(r.getMaxHP() + r.getLevel() * Constants.HP_LEVEL_ROGUE);
            default:
        }
    }

    @Override
    public void visit(final Wizard w) {
        for (int i = 0; i < Constants.NO_POWERS; i++) {
            raceModif.add(w.getRaceModif().get(i) + Constants.LEVEL_UP_HIGH_DMG_WIZARD);
        }
        w.setRaceModif(raceModif);
        switch (w.getLevel()) {
            case 0:
                w.setXp(Constants.UPDATE_LEVEL_1);
                w.updateLevel();
                w.setCurrentHp(w.getMaxHP() + w.getLevel() * Constants.HP_LEVEL_WIZARD);
            case Constants.LEVEL_1:
                w.setXp(Constants.UPDATE_LEVEL_2);
                w.updateLevel();
                w.setCurrentHp(w.getMaxHP() + w.getLevel() * Constants.HP_LEVEL_WIZARD);
            case Constants.LEVEL_2:
                w.setXp(Constants.UPDATE_LEVEL_3);
                w.updateLevel();
                w.setCurrentHp(w.getMaxHP() + w.getLevel() * Constants.HP_LEVEL_WIZARD);
            case Constants.LEVEL_3:
                w.setXp(Constants.UPDATE_LEVEL_4);
                w.updateLevel();
                w.setCurrentHp(w.getMaxHP() + w.getLevel() * Constants.HP_LEVEL_WIZARD);
            case Constants.LEVEL_4:
                w.setXp(Constants.UPDATE_LEVEL_5);
                w.updateLevel();
                w.setCurrentHp(w.getMaxHP() + w.getLevel() * Constants.HP_LEVEL_WIZARD);
            case Constants.LEVEL_5:
                w.setXp(Constants.UPDATE_LEVEL_6);
                w.updateLevel();
                w.setCurrentHp(w.getMaxHP() + w.getLevel() * Constants.HP_LEVEL_WIZARD);
            default:
        }
    }
}

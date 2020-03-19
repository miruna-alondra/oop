package angelsvisitors;

import angels.GoodBoy;
import constants.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import java.util.ArrayList;
import java.util.List;

public final class GoodBoyVisitor implements AngelVisitor {
    private GoodBoy angel;
    private List<Float> raceModif = new ArrayList<>();

    public GoodBoyVisitor(final GoodBoy goodBoy) {
        angel = goodBoy;
    }

    // Modific hp-ul si modificatorii de rasa ai fiecarui jucator
    @Override
    public void visit(final Knight k) {
        for (int i = 0; i < Constants.NO_POWERS; i++) {
            raceModif.add(k.getRaceModif().get(i) + Constants.GOODBOY_HIGH_DMG_KNIGHT);
        }
        k.setRaceModif(raceModif);
        k.setCurrentHp(k.getCurrentHp() + Constants.GOODBOY_HIGH_HP_KNIGHT);
    }

    @Override
    public void visit(final Pyromancer p) {
        for (int i = 0; i < Constants.NO_POWERS; i++) {
            raceModif.add(p.getRaceModif().get(i) + Constants.GOODBOY_HIGH_DMG_PYRO);
        }
        p.setRaceModif(raceModif);
        p.setCurrentHp(p.getCurrentHp() + Constants.GOODBOY_HIGH_HP_PYRO);
    }

    @Override
    public void visit(final Rogue r) {
        for (int i = 0; i < Constants.NO_POWERS; i++) {
            raceModif.add(r.getRaceModif().get(i) + Constants.GOODBOY_HIGH_DMG_ROGUE);
        }
        r.setRaceModif(raceModif);
        r.setCurrentHp(r.getCurrentHp() + Constants.GOODBOY_HIGH_HP_ROGUE);
    }

    @Override
    public void visit(final Wizard w) {
        for (int i = 0; i < Constants.NO_POWERS; i++) {
            raceModif.add(w.getRaceModif().get(i) + Constants.GOODBOY_HIGH_DMG_WIZARD);
        }
        w.setRaceModif(raceModif);
        w.setCurrentHp(w.getCurrentHp() + Constants.GOODBOY_HIGH_HP_WIZARD);
    }
}

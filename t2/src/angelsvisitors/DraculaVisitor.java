package angelsvisitors;

import angels.Dracula;
import constants.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import java.util.ArrayList;
import java.util.List;

public final class DraculaVisitor implements AngelVisitor {
    private Dracula angel;
    private List<Float> raceModif = new ArrayList<>();

    public DraculaVisitor(final Dracula dracula) {
        angel = dracula;
    }

    // Modific hp-ul si modificatorii de rasa ai fiecarui jucator
    @Override
    public void visit(final Knight k) {
        for (int i = 0; i < Constants.NO_POWERS; i++) {
            if (k.getRaceModif().get(i) != 0f) {
                raceModif.add(k.getRaceModif().get(i) - Constants.LOW_DMG_MODIF_KNIGHT);
            } else {
                raceModif.add(k.getRaceModif().get(i));
            }
        }
        k.setRaceModif(raceModif);
        k.setCurrentHp(k.getCurrentHp() - Constants.DRACULA_LOW_HP_KNIGHT);

    }

    @Override
    public void visit(final Pyromancer p) {
        for (int i = 0; i < Constants.NO_POWERS; i++) {
            raceModif.add(p.getRaceModif().get(i) - Constants.LOW_DMG_MODIF_PYRO);
        }
        p.setRaceModif(raceModif);
        p.setCurrentHp(p.getCurrentHp() - Constants.DRACULA_LOW_HP_PYRO);
    }

    @Override
    public void visit(final Rogue r) {
        for (int i = 0; i < Constants.NO_POWERS; i++) {
            raceModif.add(r.getRaceModif().get(i) - Constants.LOW_DMG_MODIF_ROGUE);
        }
        r.setRaceModif(raceModif);
        r.setCurrentHp(r.getCurrentHp() - Constants.DRACULA_LOW_HP_ROGUE);
    }

    @Override
    public void visit(final Wizard w) {
        for (int i = 0; i < Constants.NO_POWERS; i++) {
            raceModif.add(w.getRaceModif().get(i) - Constants.LOW_DMG_MODIF_WIZARD);
        }
        w.setRaceModif(raceModif);
        w.setCurrentHp(w.getCurrentHp() - Constants.DRACULA_LOW_HP_WIZARD);
    }
}

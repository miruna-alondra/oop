package angelsvisitors;

import angels.DamageAngel;
import constants.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import java.util.ArrayList;
import java.util.List;

public final class DamageAngelVisitor implements AngelVisitor {
    private List<Float> raceModif = new ArrayList<>();

    private DamageAngel angel;

    public DamageAngelVisitor(final DamageAngel damageAngel) {
        angel = damageAngel;
    }

    // Schimb modificatorii de rasa ai fiecarui erou
    @Override
    public void visit(final Knight k) {
        for (int i = 0; i < Constants.NO_POWERS; i++) {
            raceModif.add(k.getRaceModif().get(i) + Constants.DMG_ANGEL_HIGH_DMG_MODIF_KNIGHT);
        }
        k.setRaceModif(raceModif);
    }

    @Override
    public void visit(final Pyromancer p) {
        for (int i = 0; i < Constants.NO_POWERS; i++) {
            raceModif.add(p.getRaceModif().get(i) + Constants.DMG_ANGEL_HIGH_DMG_MODIF_PYRO);
        }
        p.setRaceModif(raceModif);
    }

    @Override
    public void visit(final Rogue r) {
        for (int i = 0; i < Constants.NO_POWERS; i++) {
            raceModif.add(r.getRaceModif().get(i) + Constants.DMG_ANGEL_HIGH_DMG_MODIF_ROGUE);
        }
        r.setRaceModif(raceModif);
    }

    @Override
    public void visit(final Wizard w) {
        for (int i = 0; i < Constants.NO_POWERS; i++) {
            raceModif.add(w.getRaceModif().get(i) + Constants.DMG_ANGEL_HIGH_DMG_MODIF_WIZARD);
        }
        w.setRaceModif(raceModif);
    }
}

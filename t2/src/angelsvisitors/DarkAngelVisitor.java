package angelsvisitors;

import angels.DarkAngel;
import constants.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public final class DarkAngelVisitor implements AngelVisitor {

    private DarkAngel angel;

    public DarkAngelVisitor(final DarkAngel darkAngel) {
        angel = darkAngel;
    }

    // Modific hp-ul fiecarui erou
    @Override
    public void visit(final Knight k) {
        int hp = k.getCurrentHp();
        hp -= Constants.LOW_HP_KNIGHT;
        k.setCurrentHp(hp);
    }

    @Override
    public void visit(final Pyromancer p) {
        int hp = p.getCurrentHp();
        hp -= Constants.LOW_HP_PYRO;
        p.setCurrentHp(hp);
    }

    @Override
    public void visit(final Rogue r) {
        int hp = r.getCurrentHp();
        hp -= Constants.LOW_HP_ROGUE;
        r.setCurrentHp(hp);
    }

    @Override
    public void visit(final Wizard w) {
        int hp = w.getCurrentHp();
        hp -= Constants.LOW_HP_WIZARD;
        w.setCurrentHp(hp);
    }
}

package angelsvisitors;

import angels.LifeGiver;
import constants.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;


public final class LifeGiverVisitor implements AngelVisitor {

    private LifeGiver angel;

    public LifeGiverVisitor(final LifeGiver lifeGiver) {
        angel = lifeGiver;
    }

    // Cresc hp-ul fiecarui erou
    @Override
    public void visit(final Knight k) {
        int hp = k.getCurrentHp();
        hp += Constants.HIGH_HP_KNIGHT;
        k.setCurrentHp(hp);
    }

    @Override
    public void visit(final Pyromancer p) {
        int hp = p.getCurrentHp();
        hp += Constants.HIGH_HP_PYRO;
        p.setCurrentHp(hp);
    }

    @Override
    public void visit(final Rogue r) {
        int hp = r.getCurrentHp();
        hp -= Constants.HIGH_HP_ROGUE;
        r.setCurrentHp(hp);
    }

    @Override
    public void visit(final Wizard w) {
        int hp = w.getCurrentHp();
        hp -= Constants.HIGH_HP_WIZARD;
        w.setCurrentHp(hp);
    }
}

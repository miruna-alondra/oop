package angelsvisitors;

import angels.XPAngel;
import constants.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public final class XPAngelVisitor implements AngelVisitor {
    private XPAngel angel;

    public XPAngelVisitor(final XPAngel xpAngel) {
        angel = xpAngel;
    }

    // Modific xp-ul fiecarui erou
    @Override
    public void visit(final Knight k) {
        int xp = k.getXp();
        xp += Constants.HIGH_XP_KNIGHT;
        k.setXp(xp);
    }

    @Override
    public void visit(final Pyromancer p) {
        int xp = p.getXp();
        xp += Constants.HIGH_XP_PYRO;
        p.setXp(xp);
    }

    @Override
    public void visit(final Rogue r) {
        int xp = r.getXp();
        xp += Constants.HIGH_XP_ROGUE;
        r.setXp(xp);
    }

    @Override
    public void visit(final Wizard w) {
        int xp = w.getXp();
        xp += Constants.HIGH_XP_WIZARD;
        w.setXp(xp);
    }
}

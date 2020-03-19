package angelsvisitors;

import angels.TheDoomer;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public final class Doomer implements AngelVisitor {

    private TheDoomer angel;

    public Doomer(final TheDoomer doomer) {
        angel = doomer;
    }

    // Setez hp-ul fiecarui erou la 0 pentru a arata moartea acestuia
    @Override
    public void visit(final Knight k) {
        k.setCurrentHp(0);
    }

    @Override
    public void visit(final Pyromancer p) {
        p.setCurrentHp(0);
    }

    @Override
    public void visit(final Rogue r) {
        r.setCurrentHp(0);
    }

    @Override
    public void visit(final Wizard w) {
        w.setCurrentHp(0);
    }
}

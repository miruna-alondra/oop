package angelsvisitors;

import angels.Spawner;
import constants.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;


public final class SpawnerVisitor implements AngelVisitor {

    private Spawner angel;

    public SpawnerVisitor(final Spawner spawner) {
        angel = spawner;
    }

    // Modific hp-ul fiecarui jucator
    @Override
    public void visit(final Knight k) {
        int hp = Constants.CURRENT_HP_KNIGHT;
        k.setCurrentHp(hp);
        k.setXp(0);
    }

    @Override
    public void visit(final Pyromancer p) {
        int hp = Constants.CURRENT_HP_PYRO;
        p.setCurrentHp(hp);
        p.setXp(0);
    }

    @Override
    public void visit(final Rogue r) {
        int hp = Constants.CURRENT_HP_ROGUE;
        r.setCurrentHp(hp);
        r.setXp(0);
    }

    @Override
    public void visit(final Wizard w) {
        int hp = Constants.CURRENT_HP_WIZARD;
        w.setCurrentHp(hp);
        w.setXp(0);
    }
}

package angels;

import angelsvisitors.LevelUpVisitor;
import heroes.Hero;
import input.Position;

public final class LevelUpAngel extends Angel {

    public LevelUpAngel(final Position position, final String name, final int id,
                        final Status status) {
        super(position, name, id, status);
    }

    @Override
    public void save(final Hero h) {
        LevelUpVisitor levelUpVisitor = new LevelUpVisitor(this);
        h.accept(levelUpVisitor);
    }

}

package angels;

import angelsvisitors.LifeGiverVisitor;
import heroes.Hero;
import input.Position;

public final class LifeGiver extends Angel {
    public LifeGiver(final Position position, final String name, final int id,
                     final Status status) {
        super(position, name, id, status);
    }

    @Override
    public void save(final Hero h) {
        LifeGiverVisitor lifeGiverVisitor = new LifeGiverVisitor(this);
        h.accept(lifeGiverVisitor);
    }

}

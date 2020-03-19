package angels;

import angelsvisitors.DraculaVisitor;
import heroes.Hero;
import input.Position;

public final class Dracula extends Angel {
    public Dracula(final Position position, final String name, final int id, final Status status) {
        super(position, name, id, status);
    }

    @Override
    public void save(final Hero h) {
        DraculaVisitor draculaVisitor = new DraculaVisitor(this);
        h.accept(draculaVisitor);
    }

}

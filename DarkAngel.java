package angels;

import angelsvisitors.DarkAngelVisitor;
import heroes.Hero;
import input.Position;

public final class DarkAngel extends Angel {

    public DarkAngel(final Position position, final String name, final int id,
                     final Status status) {
        super(position, name, id, status);
    }

   @Override
    public void save(final Hero h) {
       DarkAngelVisitor darkAngelVisitor = new DarkAngelVisitor(this);
       h.accept(darkAngelVisitor);
    }

}

package angels;

import angelsvisitors.SmallAngelVisitor;
import heroes.Hero;
import input.Position;

public final class SmallAngel extends Angel {

    public SmallAngel(final Position position, final String name, final int id,
                      final Status status) {
        super(position, name, id, status);
    }

    @Override
    public void save(final Hero h) {
        SmallAngelVisitor smallAngelVisitor = new SmallAngelVisitor(this);
        h.accept(smallAngelVisitor);
    }

}

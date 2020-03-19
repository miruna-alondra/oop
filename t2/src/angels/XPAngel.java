package angels;

import angelsvisitors.XPAngelVisitor;
import heroes.Hero;
import input.Position;

public final class XPAngel extends Angel {
    public XPAngel(final Position position, final String name, final int id, final Status status) {
        super(position, name, id, status);
    }


    @Override
    public void save(final Hero h) {
        XPAngelVisitor xpAngelVisitor = new XPAngelVisitor(this);
        h.accept(xpAngelVisitor);
    }

}

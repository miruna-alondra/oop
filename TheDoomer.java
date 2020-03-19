package angels;

import angelsvisitors.Doomer;
import heroes.Hero;
import input.Position;


public final class TheDoomer extends Angel {
    public TheDoomer(final Position position, final String name, final int id,
                     final Status status) {
        super(position, name, id, status);
    }

    @Override
    public void save(final Hero h) {
        Doomer doomer = new Doomer(this);
        h.accept(doomer);

    }




}

package angels;

import angelsvisitors.GoodBoyVisitor;
import heroes.Hero;
import input.Position;

public final class GoodBoy extends Angel {
    public GoodBoy(final Position position, final String name, final int id, final Status status) {
        super(position, name, id, status);
    }
    @Override
    public void save(final Hero h) {
        GoodBoyVisitor goodBoyVisitor = new GoodBoyVisitor(this);
        h.accept(goodBoyVisitor);
    }

}

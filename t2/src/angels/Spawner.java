package angels;

import angelsvisitors.SpawnerVisitor;
import heroes.Hero;
import input.Position;

public final class Spawner extends Angel {

    public Spawner(final Position position, final String name, final int id, final Status status) {
        super(position, name, id, status);
    }

    @Override
    public void save(final Hero h) {
        SpawnerVisitor spawnerVisitor = new SpawnerVisitor(this);
        h.accept(spawnerVisitor);
    }

}

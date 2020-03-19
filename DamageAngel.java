package angels;


import angelsvisitors.DamageAngelVisitor;
import heroes.Hero;
import input.Position;

public final class DamageAngel extends Angel {
    public DamageAngel(final Position position, final String name, final int id,
                       final Status status) {
        super(position, name, id, status);
    }

    @Override
    public void save(final Hero h) {
        DamageAngelVisitor damageAngelVisitor = new DamageAngelVisitor(this);
        h.accept(damageAngelVisitor);
    }

}

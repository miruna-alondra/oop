package angelsvisitors;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public interface AngelVisitor {
    void visit(Knight k);
    void visit(Pyromancer p);
    void visit(Rogue r);
    void visit(Wizard w);
}

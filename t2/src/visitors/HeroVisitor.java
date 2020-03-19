package visitors;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public interface HeroVisitor {

    int visit(Pyromancer p);
    int visit(Rogue r);
    int visit(Knight k);
    int visit(Wizard w);
}

package visitors;

import constants.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;


public final class Drain implements HeroVisitor {
    private float procentInitial = Constants.PROCENT_DRAIN;
    private float procentLevel = Constants.PROCENT_LEVEL_DRAIN;
    private Wizard attacker;

    public Drain(final Wizard w) {
        attacker = w;
    }

    @Override
    public int visit(final Rogue r) {
        float landModif = attacker.getLandModif();
        float raceModif = 1f + r.getRaceModif().get(Constants.INDEX_DRAIN);
        float procent;
        //calculez procentul necesar formulei damage-ului oferit
        procent = procentInitial + procentLevel * attacker.getLevel();
        procent = procent - (raceModif * procent);
        return Math.round(procent * landModif * Math.min(Constants.PROCENT_APROX_PROCENT
                            * r.getMaxHP(), r.getCurrentHp()));
    }

    @Override
    public int visit(final Knight k) {
        float landModif = attacker.getLandModif();
        float raceModif = 1f + k.getRaceModif().get(Constants.INDEX_DRAIN);
        float procent;
        procent = procentInitial + procentLevel * attacker.getLevel();
        procent = procent + (raceModif * procent);
        return Math.round(procent * landModif * Math.min(Constants.PROCENT_APROX_PROCENT
                            * k.getMaxHP(), k.getCurrentHp()));
    }

    @Override
    public int visit(final Pyromancer p) {
        float landModif = attacker.getLandModif();
        float raceModif = 1f + p.getRaceModif().get(Constants.INDEX_DRAIN);
        float procent;
        procent = procentInitial + procentLevel * attacker.getLevel();
        procent = procent - (raceModif * procent);
        return Math.round(procent * landModif * Math.min(Constants.PROCENT_APROX_PROCENT
                            * p.getMaxHP(), p.getCurrentHp()));
    }

    @Override
    public int visit(final Wizard w) {
        float landModif = attacker.getLandModif();
        float raceModif = 1f + w.getRaceModif().get(Constants.INDEX_DRAIN);
        float procent;
        procent = procentInitial + procentLevel * attacker.getLevel();
        procent = procent + (raceModif * procent);
        return Math.round(procent * landModif * Math.min(Constants.PROCENT_APROX_PROCENT
                            * w.getMaxHP(), w.getCurrentHp()));
    }
}

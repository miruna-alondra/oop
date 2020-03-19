package strategies;

import constants.Constants;
import heroes.Hero;

import java.util.ArrayList;
import java.util.List;

public final class KnightLowDmgHighHP implements Strategy {
    @Override
    public void modifyHp(final Hero h) {
        int hp = h.getCurrentHp() + h.getCurrentHp() / Constants.KNIGHT_STRATEGY_APPLY_2;
        h.setCurrentHp(hp);
    }

    @Override
    public void modifyDmg(final Hero h) {
        List<Float> raceModif = new ArrayList<>();
        for (int i = 0; i < Constants.NO_POWERS; i++) {
            raceModif.add(h.getRaceModif().get(i) + Constants.LOW_HP_KNIGHT_STRATEGY);
        }
    }
}

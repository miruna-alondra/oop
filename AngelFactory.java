package angels;

import input.Position;

public final class AngelFactory {
    private static AngelFactory instance = null;

    private AngelFactory() { }

    public static AngelFactory getInstance() {
        if (instance == null) {
            instance = new AngelFactory();
        }
        return instance;
    }

    public static Angel getAngel(final String angelName, final Position p, final int id) {
        switch (angelName) {
            case "DamageAngel":
                return new DamageAngel(p, angelName, id, Status.GOOD);

            case "DarkAngel":
                return new DarkAngel(p, angelName, id, Status.BAD);

            case "Dracula":
                return new Dracula(p, angelName, id, Status.BAD);

            case "GoodBoy":
                return new GoodBoy(p, angelName, id, Status.GOOD);

            case "LevelUpAngel":
                return new LevelUpAngel(p, angelName, id, Status.GOOD);

            case "LifeGiver":
                return new LifeGiver(p, angelName, id, Status.GOOD);

            case "SmallAngel":
                return new SmallAngel(p, angelName, id, Status.GOOD);

            case "Spawner":
                return new Spawner(p, angelName, id, Status.GOOD);

            case "TheDoomer":
                return new TheDoomer(p, angelName, id, Status.BAD);

            case "XPAngel":
                return new XPAngel(p, angelName, id, Status.GOOD);

            default:
                return null;
        }
    }

}

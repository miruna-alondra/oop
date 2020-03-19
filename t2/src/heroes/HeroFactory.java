package heroes;

import input.Position;

public final class HeroFactory {
    private static HeroFactory instance = null;

    private HeroFactory() { }

    public static HeroFactory getInstance() {
        if (instance == null) {
            instance = new HeroFactory();
        }
        return instance;
    }

    /**
     *
     * @param heroName initiala eroului ce va fi creat
     * @param p pozitia eroului
     * @return tipul de erou ce va participa la lupta
     */
   public static Hero getHero(final String heroName, final Position p) {
       switch (heroName) {
           case "P":
               return new Pyromancer("Pyromancer", p);

           case "K":
               return new Knight("Knight", p);

           case "W":
               return new Wizard("Wizard", p);

           case "R":
               return new Rogue("Rogue", p);

           default:
               return null;
       }
   }
}

package main;

import angels.Angel;
import angels.Status;
import fileio.implementations.FileWriter;
import heroes.Hero;
import heroes.HeroFactory;
import input.GameInput;
import input.GameInputLoader;
import input.Position;
import map.FieldSingleton;
import observer.Magician;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class Main {

    private static FileWriter fs;

    public static FileWriter getFs() {
        return fs;
    }

    private static void setFs(final FileWriter fs) {
        Main.fs = fs;
    }

    // afiseaza rezultatele in urma luptei
    private static void printResults(final List<Hero> heroes, final FileWriter fileWriter) {
        for (int i = 0; i < heroes.size(); i++) {
            try {
                if (heroes.get(i).getCurrentHp() > 0) {
                    fileWriter.writeCharacter(heroes.get(i).getName().charAt(0));
                    fileWriter.writeWord(" ");
                    fileWriter.writeInt(heroes.get(i).getLevel());
                    fileWriter.writeWord(" ");
                    fileWriter.writeInt(heroes.get(i).getXp());
                    fileWriter.writeWord(" ");
                    fileWriter.writeInt(heroes.get(i).getCurrentHp());
                    fileWriter.writeWord(" ");
                    fileWriter.writeInt(heroes.get(i).getP().getX());
                    fileWriter.writeWord(" ");
                    fileWriter.writeInt(heroes.get(i).getP().getY());
                    fileWriter.writeNewLine();
                } else {
                    fileWriter.writeCharacter(heroes.get(i).getName().charAt(0));
                    fileWriter.writeWord(" dead");
                    fileWriter.writeNewLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Main() {
    }
    public static void main(final String[] args) throws IOException {

         //Citesc datele din fisierul de intrare (args[0]) si
         //construiesc jocul.

        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();
        HeroFactory factory = HeroFactory.getInstance();
        int rounds = gameInput.getRounds();
        List<Hero> heroesNames = gameInput.getHeroes();
        List<Hero> heroes = new ArrayList<>();
        FieldSingleton field = FieldSingleton.getInstance();
        field.init(gameInput.getNameFields());
        String filename = args[1];
        FileWriter fileWriter = new FileWriter(filename);
        Magician magician = new Magician();
        ArrayList<Angel> angels = gameInput.getAngels();
        Main.setFs(fileWriter);

         //  Creez jucatorii folosind factory.
        for (int i = 0; i < gameInput.getNoHeroes(); i++) {
            Position p = heroesNames.get(i).getP();
            String name = heroesNames.get(i).getName();
            Hero h = factory.getHero(name, p);
            heroes.add(h);
        }

         // Se vor ataca jucatorii in functie de numarul de runde
        // verific daca erou a murit inainte de aparitia ingerului
        // Spawner pentru afisarea invierii acestuia
        int wasDead = 0;
        heroes.get(0).addObserver(magician);
        heroes.get(1).addObserver(magician);
        for (int i = 0; i < angels.size(); i++) {
            angels.get(i).addObserver(magician);
        }
        for (int i = 0; i < rounds; i++) {
            Hero h1 = heroes.get(0);
            h1.setId(0);
            Hero h2 = heroes.get(1);
            h2.setId(1);
            h1.applyStrategy();
            h2.applyStrategy();
            fileWriter.writeWord("~~ Round ");
            fileWriter.writeInt(i + 1);
            fileWriter.writeWord(" ~~");
            fileWriter.writeNewLine();
            if (gameInput.getNoAngelsperRound().get(i) == 0 && i != rounds - 1) {
                fileWriter.writeNewLine();
            }

            // Verific daca vreunul dintre jucatorii ofera
            // damage overtime
            if (h1.getDamageOvertime().getTime() != 0) {
                h1.getDamageOvertime().setTime(h1.getDamageOvertime().getTime() - 1);
                h1.setCurrentHp(h1.getCurrentHp() - h1.getDamageOvertime().getDmg());
            }

            if (h2.getDamageOvertime().getTime() != 0) {
                h2.getDamageOvertime().setTime(h2.getDamageOvertime().getTime() - 1);
                h2.setCurrentHp(h2.getCurrentHp() - h2.getDamageOvertime().getDmg());
            }

            // verific daca a murit vreunul dintre jucatori
            // si actualizez xp-ul castigatorului
            if (h1.getCurrentHp() > 0 && h2.getCurrentHp() > 0) {
               h1.attack(h2);
               if (h2.getCurrentHp() <= 0) {
                   // afisez daca eroul a murit dupa loviturile
                   // celuilalt erou
                   String message = h2.killedByHero(h1);
                   h2.update(message);
                   fileWriter.writeNewLine();
                   // actualizez nivelul castigatorului
                   // si afisez daca a avansat in nivel
                   h1.updateXp(h2);
                   h1.updateLevel();
                   if (h1.getLevel() != 0) {
                       String s = h1.reachedLevel();
                       h1.update(s);
                       fileWriter.writeNewLine();
                   }
               }
                h2.attack(h1);
               if (h1.getCurrentHp() <= 0) {
                   String message = h1.killedByHero(h2);
                   h1.update(message);
                   h2.updateXp(h1);
                   h2.updateLevel();
                   if (h2.getLevel() != 0) {
                       String s = h2.reachedLevel();
                       h2.update(s);
                       fileWriter.writeNewLine();
                   }
               }
                if (h1.getCurrentHp() <= 0 && h2.getCurrentHp() <= 0) {
                    fileWriter.writeNewLine();
                }

            }

            if (gameInput.getNoAngelsperRound().get(i) >  0) {
                // daca este prima runda, se iau primii ingeri din vector
                // in functie de numarul lor
                if (i == 0) {
                    for (int j = 0; j < gameInput.getNoAngelsperRound().get(i); j++) {
                        String spawned = angels.get(j).spawned();
                        angels.get(j).notifyObservers(spawned);
                        fileWriter.writeNewLine();
                        if (h1.getCurrentHp() > 0
                                || angels.get(j).getAngelName().equals("Spawner")) {
                            // daca apare ingerul Spawner si eroul era mort
                            // acesta il invie si ii seteaza hp-ul
                            if (angels.get(j).getAngelName().equals("Spawner")
                                    && j != gameInput.getNoAngelsperRound().get(i) - 2) {
                                if (h1.getCurrentHp() <= 0) {
                                    wasDead = 1;
                                }
                                angels.get(j).save(h1);
                                if (wasDead == 1 && h1.getCurrentHp() > 0) {
                                    String alive = h1.broughtToLife();
                                    h1.update(alive);
                                    fileWriter.writeNewLine();
                                    wasDead = 0;
                                }
                            } else {
                                angels.get(j).save(h1);
                                String helpH1 = angels.get(j).benefits(h1);
                                angels.get(j).notifyObservers(helpH1);
                                fileWriter.writeNewLine();
                            }
                            // doar daca statusul ingerului este BAD, acesta
                            // poate omori un erou
                            if (h1.getCurrentHp() <= 0
                                    && angels.get(j).getStatus().equals(Status.BAD)) {
                                String killed = h1.killedByAngel();
                                h1.update(killed);
                                fileWriter.writeNewLine();
                            }
                        }
                        if (h2.getCurrentHp() > 0
                                || angels.get(j).getAngelName().equals("Spawner")) {
                            if (angels.get(j).getAngelName().equals("Spawner")
                                    && j != gameInput.getNoAngelsperRound().get(i) - 2) {
                                if (h2.getCurrentHp() <= 0) {
                                    wasDead = 1;
                                }
                                angels.get(j).save(h2);
                                if (wasDead == 1 && h2.getCurrentHp() > 0) {
                                    String alive = h2.broughtToLife();
                                    h2.update(alive);
                                    fileWriter.writeNewLine();
                                    wasDead = 0;
                                }
                            } else {
                                angels.get(j).save(h2);
                                String helpH2 = angels.get(j).benefits(h2);
                                angels.get(j).notifyObservers(helpH2);
                                fileWriter.writeNewLine();
                            }
                            if (h2.getCurrentHp() <= 0
                                    && angels.get(j).getStatus().equals(Status.BAD)) {
                                String killed = h2.killedByAngel();
                                h2.update(killed);
                                fileWriter.writeNewLine();
                            }
                        }
                    }
                } else {
                    // daca este a doua runda, se iau ingerii ramasi in vector
                    for (int j = gameInput.getNoAngelsperRound().get(i - 1);
                         j < angels.size(); j++) {
                        String spawned = angels.get(j).spawned();
                        angels.get(j).notifyObservers(spawned);
                        fileWriter.writeNewLine();
                        if (h1.getCurrentHp() > 0
                                || angels.get(j).getAngelName().equals("Spawner")) {
                            if (h1.getCurrentHp() <= 0) {
                                wasDead = 1;
                            }
                            angels.get(j).save(h1);
                            String helpH1 = angels.get(j).benefits(h1);
                            angels.get(j).notifyObservers(helpH1);
                            fileWriter.writeNewLine();
                            if (wasDead == 1 && h1.getCurrentHp() > 0) {
                                String alive = h1.broughtToLife();
                                h1.update(alive);
                                fileWriter.writeNewLine();
                                wasDead = 0;
                            }
                            if (h1.getLevel() != 0) {
                                String s = h1.reachedLevel();
                                h1.update(s);
                                fileWriter.writeNewLine();
                            }
                            if (h1.getCurrentHp() <= 0
                                    && angels.get(j).getStatus().equals(Status.BAD)) {
                                String killed = h1.killedByAngel();
                                h1.update(killed);
                                fileWriter.writeNewLine();
                            }
                        }
                        if (h2.getCurrentHp() > 0
                                || angels.get(j).getAngelName().equals("Spawner")) {
                            if (h2.getCurrentHp() <= 0) {
                                wasDead = 1;
                            }
                            angels.get(j).save(h2);
                            String helpH2 = angels.get(j).benefits(h2);
                            angels.get(j).notifyObservers(helpH2);
                            fileWriter.writeNewLine();
                            if (wasDead == 1 && h2.getCurrentHp() > 0) {
                                String alive = h2.broughtToLife();
                                h2.update(alive);
                                fileWriter.writeNewLine();
                                wasDead = 0;
                            }
                            h2.updateLevel();
                            if (h2.getLevel() != 0) {
                                String s = h2.reachedLevel();
                                h2.update(s);
                                fileWriter.writeNewLine();
                            }
                            if (h2.getCurrentHp() <= 0
                                    && angels.get(j).getStatus().equals(Status.BAD)) {
                                String killed = h2.killedByAngel();
                                h2.update(killed);
                                fileWriter.writeNewLine();
                            }
                        }
                        if (j < angels.size() - 2 && h1.getCurrentHp() > 0
                                && h2.getCurrentHp() > 0) {
                            fileWriter.writeNewLine();
                        }
                    }
                }
            }
            if (i < rounds - 1) {
                fileWriter.writeNewLine();
            }
        }
        // actualizez nivelul jucatorilor dupa cele 2 runde
        if (heroes.get(0).getCurrentHp() > 0) {
            heroes.get(0).updateLevel();
            if (heroes.get(0).getLevel() != 0) {
                String s1 = heroes.get(0).reachedLevel();
                heroes.get(0).update(s1);
                fileWriter.writeNewLine();
            }
        }
        if (heroes.get(1).getCurrentHp() > 0) {
            heroes.get(1).updateLevel();
            if (heroes.get(1).getLevel() != 0) {
                String s2 = heroes.get(1).reachedLevel();
                heroes.get(1).update(s2);
                fileWriter.writeNewLine();
            }
        }
        // afisez rezultatele bataliei
        fileWriter.writeNewLine();
                fileWriter.writeWord("~~ Results ~~");
                fileWriter.writeNewLine();
                printResults(heroes, fileWriter);

        fileWriter.close();

    }
}

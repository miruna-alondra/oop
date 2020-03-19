package strategies;

import heroes.Hero;

public interface Strategy {
    // In functie de erou si de strategie, vor fi modificati hp-ul si
    // modificatorul de rasa ai acestuia pentru urmatoarea runda
    void modifyHp(Hero h);

    void modifyDmg(Hero h);
}

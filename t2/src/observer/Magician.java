package observer;

import fileio.implementations.FileWriter;

import main.Main;
import java.util.Observable;
import java.util.Observer;

public final class Magician implements Observer {

    // Metoda scrie mesajul corespunzator in fisier
    @Override
    public void update(final Observable o, final Object arg) {
        try {
            FileWriter fs = Main.getFs();
            if (arg instanceof String) {
                fs.writeWord((String) arg);
            }
        } catch (Exception el) {
            el.printStackTrace();
        }
    }
}

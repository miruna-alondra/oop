package angels;

import heroes.Hero;
import input.Position;
import observer.Magician;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public abstract class Angel extends Observable {
    private static Position position;
    private String angelName;
    private int id;
    private Status status;
    private List<Magician> observers = new ArrayList<>();

    public Angel(final Position p, final String name, final int id, final Status status) {
        position = p;
        angelName = name;
        this.id = id;
        this.status = status;
    }

    /**
     * @param o observer
     */
    @Override
    public synchronized void addObserver(final Observer o) {
        observers.add((Magician) o);
    }

    /**
     * @param arg mesajul ce va fi scris in fisier
     */
    @Override
    public void notifyObservers(final Object arg) {
        super.notifyObservers(arg);
        this.observers.get(0).update(this, arg);
    }

    /**
     * @return pozitia ingerului
     */
    public static Position getPosition() {
        return position;
    }

    /**
     * @param position - setez pozitia ingerului in functie de ce am citit
     */
    public static void setPosition(final Position position) {
        Angel.position = position;
    }

    /**
     * @return numele ingerului pentru afisare
     */
    public String getAngelName() {
        return angelName;
    }

    /**
     * @return id-ul ingerului
     */
    public int getId() {
        return id;
    }

    /**
     * @param id setez id-ul ingerului in functie de
     *           ordinea in care citesc ingerii
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * @return status-ul ingerului pentru afisare
     */
    public Status getStatus() {
        return status;
    }

    public abstract void save(Hero h);

    /**
     * @param h eroul ajutat de inger
     * @return mesajul ce va fi scris in fisier
     */
    // creez string-ul prin care afisez beneficiile
    // ingerului asupra unui erou
    public String benefits(final Hero h) {
        StringBuilder sb = new StringBuilder();
        String message;
        sb.append(this.getAngelName());
        sb.append(" ");
        if (this.getStatus().equals(Status.GOOD)) {
            sb.append("helped ");
        } else {
            sb.append("hit ");
        }
        sb.append(h.getName());
        sb.append(" ");
        sb.append(h.getId());
        message = sb.toString();
        return message;

    }

    /**
     * @return mesajul ce va fi scris in fisier
     */
    // creez string-ul prin care marchez aparitia
    // ingerului in joc
    public String spawned() {
        StringBuilder sb = new StringBuilder();
        String message;
        sb.append("Angel ");
        sb.append(this.getAngelName());
        sb.append(" was spawned at ");
        sb.append(this.getPosition().getX());
        sb.append(" ");
        sb.append(this.getPosition().getY());
        message = sb.toString();
        return message;
    }

}

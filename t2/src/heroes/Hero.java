package heroes;

import angelsvisitors.AngelVisitor;
import constants.Constants;
import input.Position;
import observer.Magician;
import visitors.DamageOvertime;
import visitors.HeroVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import static java.lang.Integer.max;

/**
 *
 */
public class Hero extends Observable {
    protected int id;
    protected int xp;
    protected String name;
    protected Position p;
    protected float landModif;
    protected int level;
    protected int currentHp;
    protected int hpMax;
    protected int hpLevel;
    protected DamageOvertime damageOvertime;
    protected List<Float> raceModif = new ArrayList<>();
    protected List<Magician> observers = new ArrayList<>();

    /**
     * @param o observerul
     */
    @Override
    public synchronized void addObserver(final Observer o) {
        observers.add((Magician) o);
    }

    /**
     * @param s mesajul ce va fi scris in fisier
     */
    public void update(final String s) {
        this.notifyObservers(s);
        this.observers.get(0).update(this, s);
    }

    /**
     * @return lista de modificatori de rasa pentru fiecare erou
     */
    public List<Float> getRaceModif() {
        return raceModif;
    }

    /**
     * @param raceModif modific modificatorii de rasa in functie
     *                  de inger sau de strategie
     */
    public void setRaceModif(final List<Float> raceModif) {
        this.raceModif = raceModif;
    }

    /**
     *
     * @param name - initiala eroului ce va fi construit
     * @param p - pozitia eroului in cadrul hartii
     */
    public Hero(final String name, final Position p) {
        this.name = name;
        this.p = p;
        landModif = Constants.INITIAL_LAND_MODIFIER;
        currentHp = 0;
        hpMax = 0;
        hpLevel = 0;
        damageOvertime = new DamageOvertime();
    }

    public Hero() {
        xp = 0;
        level = 0;
    }

    /**
     * @return damage-ul provocat in rundele overtime
     */
    public DamageOvertime getDamageOvertime() {
        return damageOvertime;
    }

    /**
     * @return initiala eroului
     */
    public String getName() {
        return name;
    }

    /**
     * @return pozitia eroului
     */
    public Position getP() {
        return p;
    }


    /**
     * @param currentHp - actualizarea hp-ului
     */
    public void setCurrentHp(final int currentHp) {
        this.currentHp = currentHp;
    }

    /**
     * @param x modificarea landModif in cazul in care
     *          eroul se afla pe un teren in care
     *          abilitatile lui au o putere mai mare
     */
    public void setLandModif(final float x) {
        landModif = x;
    }

    /**
     * @param loser - eroul care a murit in urma luptei
     */
    public void updateXp(final Hero loser) {
        xp = xp + max(0, Constants.UPDATE_XP - (level - loser.level)
                        * Constants.NUMBER_FOR_XP);
    }

    /**
     * @param currLevel - returneaza nivelul la care
     *                  se afla jucatorul
     */
    public void levelUp(final int currLevel) {
        int xpLevelUp = Constants.LEVEL_1 + currLevel * Constants.UPDATE_LEVEL;
        xp = xpLevelUp;
    }

    /**
     * @return xp-ul jucatorului
     */
    public int getXp() {
        return xp;
    }

    /**
     * @param xp modific xp-ul jucatorului in functie de nivel
     */
    public void setXp(final int xp) {
        this.xp = xp;
    }

    /**
     * Actualizeaza Level-ului jucatorului
     * in cazul in care isi omoara adversarul.
     */
    public void updateLevel() {
        if (this.getXp() >= Constants.UPDATE_LEVEL_1 && this.getXp() < Constants.UPDATE_LEVEL_2) {
            level = Constants.LEVEL_1;
            currentHp = hpMax + level * hpLevel;
        }
        if (this.getXp() >= Constants.UPDATE_LEVEL_2 && this.getXp() < Constants.UPDATE_LEVEL_3) {
            level = Constants.LEVEL_2;
            currentHp = hpMax + level * hpLevel;
        }

        if (this.getXp() >= Constants.UPDATE_LEVEL_3 && this.getXp() < Constants.UPDATE_LEVEL_4) {
            level = Constants.LEVEL_3;
            currentHp = hpMax + level * hpLevel;
        }

        if (this.getXp() >= Constants.UPDATE_LEVEL_4 && this.getXp() < Constants.UPDATE_LEVEL_5) {
            level = Constants.LEVEL_4;
            currentHp = hpMax + level * hpLevel;
        }
    }

    /**
     * @return landModif
     */
    public float getLandModif() {
        return landModif;
    }

    /**
     * @return level-ul jucatorului
     */
    public int getLevel() {
        return level;
    }

    /**
     * @return id-ul eroului pentru scrierea in fisier
     */
    public int getId() {
        return id;
    }

    /**
     * @param id setez id-ul jucatorului pentru afisarea in document
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * @param move - actualizeaza pozitia jucatorului
     */
    public void updatePosition(final String move) {
        if (move.equals("U")) {
            p.setX(p.getX() - 1);
        }

        if (move.equals("D")) {
            p.setX(p.getX() + 1);
        }

        if (move.equals("L")) {
            p.setY(p.getY() - 1);
        }

        if (move.equals("R")) {
            p.setY(p.getY() + 1);
        }
    }

    /**
     * @return currentHp - hp-ul jucatorului la
     *                    acel moment
     */
    public int getCurrentHp() {
        return currentHp;
    }

    /**
     * @param h - abilitatea care ii va provoca damage
     *          jucatorului
     */
    public  void accept(final HeroVisitor h) { }

    public void accept(final AngelVisitor angelVisitor) { }
    /**
     * @return damage-ul dat pentru implementarea
     * abilitatii Deflect a wizard-ului, calculat
     * fara race modifier
     */
    public  int damageGiven() {
        return 0;
    }

    /**
     * @param h - jucatorul care va fi atacat
     */
    public void attack(final Hero h) { }
    public void applyStrategy() { }

    /**
     * @param h eroul care a castigat lupta
     * @return mesajul ce va fi scris in fisier
     */
    // creez string-ul care marcheaza de catre
    // care erou a fost omorat
    public String killedByHero(final Hero h) {
        StringBuilder sb = new StringBuilder();
        String message;
        sb.append("Player ");
        sb.append(this.getName());
        sb.append(" ");
        sb.append(this.getId());
        sb.append(" was killed by ");
        sb.append(h.getName());
        sb.append(" ");
        sb.append(h.getId());
        message = sb.toString();
        return message;
    }

    /**
     * @return mesajul ce va fi scris in fisier
     */
    // creez string-ul prin care afisez ca eroul
    // a fost omorat de un inger
    public String killedByAngel() {
        StringBuilder sb = new StringBuilder();
        String message;
        sb.append("Player ");
        sb.append(this.getName());
        sb.append(" ");
        sb.append(this.getId());
        sb.append(" was killed by an angel");
        message = sb.toString();
        return message;
    }

    /**
     * @return mesajul prin care
     * eroul a avansat in nivel
     */
    // actualizarea nivelului
    public String reachedLevel() {
        StringBuilder sb = new StringBuilder();
        String message;
        sb.append(this.getName());
        sb.append(" ");
        sb.append(this.getId());
        sb.append(" reached level ");
        sb.append(this.getLevel());
        message = sb.toString();
        return message;
    }

    /**
     * @return mesajul prin care se marcheaza aducerea
     * la viata a eroului
     */
    // string-ul prin afisez invierea eroului
    public String broughtToLife() {
        StringBuilder sb = new StringBuilder();
        String message;
        sb.append("Player ");
        sb.append(this.getName());
        sb.append(" ");
        sb.append(this.getId());
        sb.append(" was brought to life by an angel");
        message = sb.toString();
        return message;
    }
}

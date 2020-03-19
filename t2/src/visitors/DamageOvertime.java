package visitors;

/**
 * Setez damage-ul overtime si rundele overtime provocate
 * de abilitatile Ignite, Paralysis si Backstab.
 */

public final class DamageOvertime {
    private int dmg;
    private int time;

    public DamageOvertime() {
        dmg = 0;
        time = 0;
    }

    public int getDmg() {
        return dmg;
    }

    public int getTime() {
        return time;
    }

    public void setDmg(final int dmg) {
        this.dmg = dmg;
    }

    public void setTime(final int time) {
        this.time = time;
    }
}

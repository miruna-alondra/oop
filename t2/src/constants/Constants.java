package constants;

public class Constants {

    protected Constants() { }

    /**
     *  NMAX - folosit pentru initializarea matricei
     *             corespunzatoare hartii
     * UPDATE_XP - constanta din cadrul formulei
     *                  pentru actualizarea XP-ului
     * UPDATE_LEVEL_$i - pragurile pentru a trece
     *                        la un alt nivel
     * LEVEL_$i - pentru checkstyle
     *  NUMBER_FOR_XP,  UPDATE_LEVEL - pentru
     *                        formulele necesare
     *                        din cadrul metodelor
     *                        levelUp si updateXp.
     */

    public static final int NMAX = 100;
    public static final float INITIAL_LAND_MODIFIER = 1.0f;
    public static final int UPDATE_XP = 200;
    public static final int UPDATE_LEVEL_1 = 250;
    public static final int UPDATE_LEVEL_2 = 300;
    public static final int UPDATE_LEVEL_3 = 350;
    public static final int UPDATE_LEVEL_4 = 400;
    public static final int UPDATE_LEVEL_5 = 450;
    public static final int UPDATE_LEVEL_6 = 500;

    public static final int LEVEL_1 = 1;
    public static final int LEVEL_2 = 2;
    public static final int LEVEL_3 = 3;
    public static final int LEVEL_4 = 4;
    public static final int LEVEL_5 = 5;
    public static final int NUMBER_FOR_XP = 40;
    public static final int UPDATE_LEVEL = 50;

     /** Constantele pentru Pyromancer.
     */

    public static final int HP_INITIAL_PYROMANCER = 500;
    public static final int HP_LEVEL_PYROMANCER = 50;
    public static final float PYRO_LAND_MODIFIER = 0.25f;

    public static final int BASE_DMG_FIREBLAST = 350;
    public static final int DMG_LEVEL_FIREBLAST = 50;
    public static final float RACE_MODIF_ROGUE_FIREBLAST = -0.2f;
    public static final float RACE_MODIF_KNIGHT_FIREBLAST = 0.2f;
    public static final float RACE_MODIF_PYRO_FIREBLAST = -0.1f;
    public static final float RACE_MODIF_WIZARD_FIREBLAST = 0.05f;

    public static final int BASE_DMG_FIRST_ROUND_IGNITE = 150;
    public static final int DMG_LEVEL_FIRST_ROUND_IGNITE = 20;
    public static final int DMG_NEXT_ROUNDS_IGNITE = 50;
    public static final int DMG_LEVEL_NEXT_ROUNDS_IGNITE = 30;
    public static final float RACE_MODIF_ROGUE_IGNITE = -0.2f;
    public static final float RACE_MODIF_KNIGHT_IGNITE = 0.2f;
    public static final float RACE_MODIF_PYRO_IGNITE = -0.1f;
    public static final float RACE_MODIF_WIZARD_IGNITE = 0.05f;

    /** Constantele pentru Knight.
     *
     */
    public static final int HP_INITIAL_KNIGHT = 900;
    public static final int HP_LEVEL_KNIGHT = 80;
    public static final float KNIGHT_LAND_MODIFIER = 0.15f;

    public static final int BASE_DMG_EXECUTE = 200;
    public static final int DMG_LEVEL_EXECUTE = 30;

    public static final float HP_LIMIT = 0.2f;

    public static final float RACE_MODIF_ROGUE_EXECUTE = 0.15f;
    public static final float RACE_MODIF_KNIGHT_EXECUTE = 0f;
    public static final float RACE_MODIF_PYRO_EXECUTE = 0.1f;
    public static final float RACE_MODIF_WIZARD_EXECUTE = -0.2f;

    public static final int BASE_DMG_SLAM = 100;
    public static final int DMG_LEVEL_SLAM = 40;
    public static final float RACE_MODIF_ROGUE_SLAM = -0.2f;
    public static final float RACE_MODIF_KNIGHT_SLAM = 0.2f;
    public static final float RACE_MODIF_PYRO_SLAM = -0.1f;
    public static final float RACE_MODIF_WIZARD_SLAM = 0.05f;

    /** Constantele pentru Rogue.
     *
     */

    public static final int HP_INITIAL_ROGUE = 600;
    public static final int HP_LEVEL_ROGUE = 40;
    public static final float ROGUE_LAND_MODIFIER = 0.15f;
    public static final int OVERTIME_ROUNDS_WOODS = 6;
    public static final int OVERTIME_ROUNDS = 3;
    public static final int POWERFULL_HIT = 3;

    public static final int BASE_DMG_BACKSTAB = 200;
    public static final int DMG_LEVEL_BACKSTAB = 20;
    public static final float RACE_MODIF_ROGUE_BACKSTAB = 0.2f;
    public static final float RACE_MODIF_KNIGHT_BACKSTAB = -0.1f;
    public static final float RACE_MODIF_PYRO_BACKSTAB = 0.25f;
    public static final float RACE_MODIF_WIZARD_BACKSTAB = 0.25f;
    public static final float OVERTIME_FACTOR = 1.5f;

    public static final int BASE_DMG_PARALYSIS = 40;
    public static final int DMG_LEVEL_PARALYSIS = 10;
    public static final float RACE_MODIF_ROGUE_PARALYSIS = -0.1f;
    public static final float RACE_MODIF_KNIGHT_PARALYSIS = -0.2f;
    public static final float RACE_MODIF_PYRO_PARALYSIS = 0.2f;
    public static final float RACE_MODIF_WIZARD_PARALYSIS = 0.25f;

    /** Constantele pentru Wizard.
     *
     */

    public static final int HP_INITIAL_WIZARD = 400;
    public static final int HP_LEVEL_WIZARD = 30;
    public static final float WIZARD_LAND_MODIFIER = 0.1f;

    public static final float PROCENT_DRAIN = 0.2f;
    public static final float PROCENT_LEVEL_DRAIN = 0.05f;
    public static final float RACE_MODIF_ROGUE_DRAIN = 0.2f;
    public static final float RACE_MODIF_KNIGHT_DRAIN = 0.2f;
    public static final float RACE_MODIF_PYRO_DRAIN = 0.1f;
    public static final float RACE_MODIF_WIZARD_DRAIN = 0.05f;
    public static final float PROCENT_APROX_PROCENT = 0.3f;

    public static final float PROCENT_DEFLECT = 0.35f;
    public static final float PROCENT_LEVEL_DEFLECT = 0.02f;
    public static final float RACE_MODIF_ROGUE_DEFLECT = 0.2f;
    public static final float RACE_MODIF_KNIGHT_DEFLECT = 0.4f;
    public static final float RACE_MODIF_PYRO_DEFLECT = 0.3f;


    /**
     * Constantele pentru DarkAngel.
     */

    public static final int LOW_HP_KNIGHT = 40;
    public static final int LOW_HP_PYRO = 30;
    public static final int LOW_HP_ROGUE = 10;
    public static final int LOW_HP_WIZARD = 20;

    /**
     * Constantele pentru LifeGiver.
     */

    public static final int HIGH_HP_KNIGHT = 100;
    public static final int HIGH_HP_PYRO = 80;
    public static final int HIGH_HP_ROGUE = 90;
    public static final int HIGH_HP_WIZARD = 120;

    /**
     * Constantele pentru XPAngel.
     */

    public static final int HIGH_XP_KNIGHT = 45;
    public static final int HIGH_XP_PYRO = 50;
    public static final int HIGH_XP_ROGUE = 40;
    public static final int HIGH_XP_WIZARD = 60;

    /**
     * Constantele pentru Spawner.
     */

    public static final int CURRENT_HP_KNIGHT = 200;
    public static final int CURRENT_HP_PYRO = 150;
    public static final int CURRENT_HP_ROGUE = 180;
    public static final int CURRENT_HP_WIZARD = 120;

    /**
     * Constantele pentru DamageAngel.
     */

    public static final float DMG_ANGEL_HIGH_DMG_MODIF_KNIGHT = 0.15f;
    public static final float DMG_ANGEL_HIGH_DMG_MODIF_PYRO = 0.2f;
    public static final float DMG_ANGEL_HIGH_DMG_MODIF_ROGUE = 0.3f;
    public static final float DMG_ANGEL_HIGH_DMG_MODIF_WIZARD = 0.4f;

    /**
     * Constantele pentru Dracula.
     */

    public static final float LOW_DMG_MODIF_KNIGHT = 0.2f;
    public static final float LOW_DMG_MODIF_PYRO = 0.3f;
    public static final float LOW_DMG_MODIF_ROGUE = 0.1f;
    public static final float LOW_DMG_MODIF_WIZARD = 0.4f;

    public static final int DRACULA_LOW_HP_KNIGHT = 60;
    public static final int DRACULA_LOW_HP_PYRO = 40;
    public static final int DRACULA_LOW_HP_ROGUE = 35;
    public static final int DRACULA_LOW_HP_WIZARD = 20;

    /**
     * Constantele pentru GoodBoy.
     */

    public static final float GOODBOY_HIGH_DMG_KNIGHT = 0.4f;
    public static final float GOODBOY_HIGH_DMG_PYRO = 0.5f;
    public static final float GOODBOY_HIGH_DMG_ROGUE = 0.4f;
    public static final float GOODBOY_HIGH_DMG_WIZARD = 0.3f;


    public static final int GOODBOY_HIGH_HP_KNIGHT = 20;
    public static final int GOODBOY_HIGH_HP_PYRO = 30;
    public static final int GOODBOY_HIGH_HP_ROGUE = 40;
    public static final int GOODBOY_HIGH_HP_WIZARD = 50;

    /**
     * Constantele pentru LevelUpAngel.
     */

    public static final float LEVEL_UP_HIGH_DMG_KNIGHT = 0.1f;
    public static final float LEVEL_UP_HIGH_DMG_PYRO = 0.2f;
    public static final float LEVEL_UP_HIGH_DMG_ROGUE = 0.15f;
    public static final float LEVEL_UP_HIGH_DMG_WIZARD = 0.25f;

    /**
     * Constantele pentru SmallAngel.
     */

    public static final float SMALL_HIGH_DMG_KNIGHT = 0.1f;
    public static final float SMALL_HIGH_DMG_PYRO = 0.15f;
    public static final float SMALL_HIGH_DMG_ROGUE = 0.05f;
    public static final float SMALL_HIGH_DMG_WIZARD = 0.1f;

    public static final int SMALL_HIGH_HP_KNIGHT = 10;
    public static final int SMALL_HIGH_HP_PYRO = 15;
    public static final int SMALL_HIGH_HP_ROGUE = 20;
    public static final int SMALL_HIGH_HP_WIZARD = 25;

    /**
     * Constante pentru vectorul raceModif.
     */

    public static final int INDEX_EXECUTE = 0;
    public static final int INDEX_SLAM = 1;
    public static final int INDEX_FIREBLAST = 2;
    public static final int INDEX_IGNITE = 3;
    public static final int INDEX_BACKSTAB = 4;
    public static final int INDEX_PARALYSIS = 5;
    public static final int INDEX_DRAIN = 6;
    public static final int INDEX_DEFLECT = 7;
    public static final int NO_POWERS = 8;

    /**
     * Constante pentru strategii.
     */

    public static final float HIGH_HP_KNIGHT_STRATEGY = 0.5f;
    public static final float HIGH_HP_PYRO_STRATEGY = 0.7f;
    public static final float HIGH_HP_ROGUE_STRATEGY = 0.4f;
    public static final float HIGH_HP_WIZARD_STRATEGY = 0.6f;

    public static final float LOW_HP_KNIGHT_STRATEGY = 0.2f;
    public static final float LOW_HP_PYRO_STRATEGY = 0.3f;
    public static final float LOW_HP_ROGUE_STRATEGY = 0.1f;
    public static final float LOW_HP_WIZARD_STRATEGY = 0.2f;

    /**
     * Constante pentru a verifica ce strategie va fi aplicata.
     */

    public static final int KNIGHT_DIVIDER_S_1_1 = 3;
    public static final int KNIGHT_DIVIDER_S_1_2 = 2;
    public static final int KNIGHT_DIVIDER_S_2 = 3;

    public static final int PYRO_DIVIDER_S_1_1 = 4;
    public static final int PYRO_DIVIDER_S_1_2 = 3;
    public static final int PYRO_DIVIDER_S_2 = 4;

    public static final int ROGUE_DIVIDER_S_1_1 = 7;
    public static final int ROGUE_DIVIDER_S_1_2 = 5;
    public static final int ROGUE_DIVIDER_S_2 = 7;

    public static final int WIZARD_DIVIDER_S_1_1 = 4;
    public static final int WIZARD_DIVIDER_S_1_2 = 2;
    public static final int WIZARD_DIVIDER_S_2 = 4;

    public static final int KNIGHT_STRATEGY_APPLY_1 = 5;
    public static final int KNIGHT_STRATEGY_APPLY_2 = 4;

    public static final int PYRO_STRATEGY_APPLY_1 = 4;
    public static final int PYRO_STRATEGY_APPLY_2 = 3;

    public static final int ROGUE_STRATEGY_APPLY_1 = 7;
    public static final int ROGUE_STRATEGY_APPLY_2 = 2;

    public static final int WIZARD_STRATEGY_APPLY_1 = 10;
    public static final int WIZARD_STRATEGY_APPLY_2 = 5;
}

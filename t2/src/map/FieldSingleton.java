package map;

public final class FieldSingleton {
    private static FieldSingleton instance = null;
    private char[][] fieldsNames;

    private FieldSingleton() { }

    /**
     *
     * @param nfieldsNames initializarea hartii
     */
    public void init(final char[][] nfieldsNames) {
        this.fieldsNames = nfieldsNames;
    }

    /**
     *
     * @return matricea corespunzatoare hartii
     */
    public char[][] getFieldsNames() {
        return fieldsNames;
    }

    public static FieldSingleton getInstance() {
        if (instance == null) {
            instance = new FieldSingleton();
        }
        return instance;
    }
}

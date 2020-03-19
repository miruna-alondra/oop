package input;

import angels.Angel;
import constants.Constants;
import heroes.Hero;

import java.util.ArrayList;
import java.util.List;

public class GameInput {

    private  Position field;
    private  char[][] nameFields = new char[Constants.NMAX][Constants.NMAX];
    private  int noFields;
    private  int noHeroes;
    private  List<Hero> heroes;
    private  int noRounds;
    private  List<String> moves;
    private ArrayList<Angel> angels;
    private List<Integer> noAngelsperRound;

    public GameInput() {
        moves = null;
        heroes = null;
        field = null;
        noRounds = -1;
        noHeroes = -1;
        noFields = -1;
        noAngelsperRound = null;
        angels = new ArrayList<>();
    }

    /**
     *
     * @param noFields -
     * @param field - dimensiunile hartii
     * @param nameFields - matricea corespunzatoare hartii
     *                   cu numele terenurilor corespunzatoare
     *                   fiecarei casute
     * @param noHeroes - numarul eroilor care vor participa
     *                 la lupta
     * @param heroes - lista eroilor ce vor participa
     * @param noRounds - numarul de runde
     * @param moves - ce miscari ar trebui sa execute fiecare
     *              jucator inainte de lupta
     //* @param angels - lista ingerilor ce vor aparea
     //* @param noAngelsperRound - lista numarului de ingeri care
     *                         participa la fiecare runda
     */
    public GameInput(final int noFields, final Position field, final char[][] nameFields,
                    final int noHeroes, final List<Hero> heroes, final int noRounds,
                     final List<String> moves, final ArrayList<Angel> angels,
                     final List<Integer> noAngelsperRound) {
        this.noFields = noFields;
        this.field = field;
        for (int i = 0; i < noFields; i++) {
            for (int j = 0; j < noFields; j++) {
                this.nameFields[i][j] = nameFields[i][j];
            }
        }
        this.noHeroes = noHeroes;
        this.heroes = heroes;
        this.noRounds = noRounds;
        this.moves = moves;
        this.angels = angels;
        this.noAngelsperRound = noAngelsperRound;

    }

    /**
     *
     * @return lista de mutari ce vor fi executate
     */
    public final List<String> getMoves() {
        return moves;
    }

    /**
     *
     * @return lista eroilor ce se vor lupta
     */
    public final List<Hero> getHeroes() {
        return heroes;
    }

    /**
     *
     * @return numarul de terenuri pe care se vor lupta
     */
    public final int getNoFields() {
        return noFields;
    }

    /**
     *
     * @return numarul eroilor
     */
    public final int getNoHeroes() {
        return noHeroes;
    }

    /**
     *
     * @return dimensiunile terenului
     */
    public final Position getField() {
        return field;
    }

    /**
     *
     * @return numarul de runde
     */
    public final int getRounds() {
        return noRounds;
    }

    /**
     *
     * @return matricea corespunzatoare hartii
     * cu numele terenurilor din fiecare casuta
     */
    public final char[][] getNameFields() {
        return nameFields;
    }

    /**
     *
     * @return true daca este un input valid,
     * false altfel
     */

    public final ArrayList<Angel> getAngels() {
        return angels;
    }

    public final List<Integer> getNoAngelsperRound() {
        return noAngelsperRound;
    }

    public final boolean isValidInput() {
        boolean membersInstantiated = moves != null && heroes != null;
        boolean membersNotEmpty = moves.size() > 0 && heroes.size() > 0
                                && noRounds > 0 && noFields > 0;

        return membersInstantiated && membersNotEmpty;
    }
}

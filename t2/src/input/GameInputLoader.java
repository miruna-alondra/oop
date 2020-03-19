package input;

import angels.Angel;
import angels.AngelFactory;
import constants.Constants;
import fileio.FileSystem;
import heroes.Hero;

import java.util.ArrayList;
import java.util.List;

public final class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;

    public GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }

    public GameInput load() {
        Position field = new Position();
        char[][] nameFields = new char[Constants.NMAX][Constants.NMAX];
        int noFields = 0;
        int noHeroes = 0;
        List<Hero> heroes = new ArrayList<>();
        int noRounds = 0;
        List<String> moves = new ArrayList<>();
        ArrayList<Angel> angels = new ArrayList<>();
        AngelFactory angelFactory = AngelFactory.getInstance();
        List<Integer> noAngelsperRound = new ArrayList<>();

       // Citirea din fisier a datelor problemei

        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);
            noFields = fs.nextInt();
            field.setX(noFields);
            field.setY(fs.nextInt());

            for (int i = 0; i < noFields; ++i) {
                String nameField = fs.nextWord();
                for (int j = 0; j < noFields; ++j) {
                    nameFields[i][j] = nameField.charAt(j);
                }
            }

            noHeroes = fs.nextInt();

            for (int i = 0; i < noHeroes; ++i) {
               String heroName = fs.nextWord();
               int x = fs.nextInt();
                int y = fs.nextInt();
               Position p = new Position(x, y);
               Hero aux = new Hero(heroName, p);
               heroes.add(aux);

            }

            noRounds = fs.nextInt();

            for (int i = 0; i < noRounds; i++) {
                moves.add(fs.nextWord());
            }
            for (int j = 0; j < noRounds; j++) {
                int aux = fs.nextInt();
                noAngelsperRound.add(aux);
                if (aux > 0) {
                    for (int i = 0; i < aux; i++) {
                        String str = fs.nextWord();
                        String[] parts = str.split(",");
                        String angelName = parts[0];
                        String pozX = parts[1];
                        String pozY = parts[2];
                        int x = pozX.charAt(0) - '0';
                        int y = pozY.charAt(0) - '0';
                        Position poz = new Position(x, y);
                        Angel someAngel = angelFactory.getAngel(angelName, poz, i);
                        angels.add(someAngel);

                    }
                }
            }

            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }
         // Obtinerea datelor pentru implementarea jocului.

        return new GameInput(noFields, field, nameFields, noHeroes, heroes, noRounds,
                moves, angels, noAngelsperRound);
    }
}

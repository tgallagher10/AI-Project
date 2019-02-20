import java.util.ArrayList;

/**
 * Created by carlmeyer on 2/19/19.
 */
public class Connect4Board extends Board {
    public static final int ROWS = 6;
    public static final int COLS = 7;
    private String turn = "R";

    public Connect4Board() {
        super(ROWS, COLS);
        for (int r = 0; r < ROWS; r++) {
                for (int c = 0; c < COLS; c++) {
                    set(r, c, "" + '-');

            }
        }
    }


    /**
     * Places a player piece on the board at the given location.
     * @param loc the location to place the piece
     * @param player the player making the move
     */
    public void placePiece(String loc, String player) {
        int col = Integer.parseInt(loc) - 1;
        for (int r = ROWS; r > 0; r--) {
            //possibly not working because the "-" might not be exactly what's on the board
            if(theBoard[r][col].equals("-")){
                theBoard[r][col] = player;
                break;
            }
        }
        if (turn.equals("R")){
            turn="Y";
        }
        else{
            turn="R";
        }
    }

    public String getTurn(){
        return turn;
    }

    /**
     * Retracts the piece at the given location.
     * @param loc the location to reset
     */
    public void retractPiece(String loc) {
        int currentLoc = 1;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (String.valueOf(currentLoc).equals(loc))
                    theBoard[r][c] = loc;

                currentLoc++;
            }
        }

        if (turn.equals("R")){
            turn="Y";
        }
        else if (turn.equals("Y")){
            turn="R";
        }
    }

    /**
     * Returns the empty locations on the
     */
    public ArrayList<String> getEmptyLocs() {
        ArrayList<String> empty = new ArrayList<>();

        for(int r = 0; r < theBoard.length; r++) {
            for(int c = 0; c < theBoard[0].length; c++) {
                if(!theBoard[r][c].equals("R") && !theBoard[r][c].equals("Y"))
                    empty.add((String) theBoard[r][c]);
            }
        }

        return empty;
    }

    /**
     * Returns true if the given player wins the game in the
     * current state, false otherwise
     * @param player the player to check for a win
     */
    public boolean isWinner(String player) {

        // check rows for streak
        for(int i = 0; i < getRows(); i++) {
            if (streakInRow(i, player, 4) || streakInCol(i, player, 4))
                return true;
        }

        if(streakInNorthEastDiag(2, 0, player, 3) || streakInSouthEastDiag(0, 0, player, 3))
            return true;

        return false;
    }

    /**
     * Returns true if the game is over, false otherwise
     * @return true if the game is over, false otherwise
     */
    public boolean isGameOver() {

        if(isWinner("R") || isWinner("Y") || getEmptyLocs().size() == 0)
            return true;
        else
            return false;

    }

    public String toString(){
        String toReturn = "";

        System.out.println("1234567");

        for(int r = 0; r < theBoard.length; r++) {
            for(int c = 0; c < theBoard[0].length; c++) {

                toReturn += theBoard[r][c];
            }

            toReturn += "\n";
        }

        return toReturn;
    }

}

import java.util.ArrayList;

public class TTTPlayerProAI extends Player {

    /**
     * Constucts a new TTTPlayerProAI
     * @param name
     */
    public TTTPlayerProAI(String name) {
        super(name);
    }

    /**
     * Return the move location for the player
     * @param board the game board
     * @return the move location for the player
     */
    public String getMove(Board board) {
        MoveInfo mi = recMove( (TTTBoard) board, this.name, "");
        return mi.getLoc();
    }

    /**
     * Performs the MinMax algorithm to determine the
     * move of this AI player.
     * @param board the game board
     * @param playerTurn the player moving
     * @return the MoveInfo for the move
     */
    private MoveInfo recMove(TTTBoard board, String playerTurn, String moveLoc) {
        MoveInfo max = new MoveInfo(moveLoc, -10);
        MoveInfo min = new MoveInfo(moveLoc, 10);
        if(board.isWinner("X"))
            return new MoveInfo(moveLoc,10);
        else if(board.isWinner("O"))
            return new MoveInfo(moveLoc,-10);
        else if(!board.isWinner("X") && !board.isWinner("O") &&
                board.getEmptyLocs() == null)
            return new MoveInfo(moveLoc, 0);
        for(String m : board.getEmptyLocs()){
            board.placePiece(m,playerTurn);
            if(board.getTurn().equals("O")) {
                MoveInfo move = recMove(board, "O", m);
                if( move.getScore() > max.getScore())
                    max = move;
            }
            else{
                MoveInfo move = recMove(board,"X",m);
                if(move.getScore() < min.getScore())
                    min = move;
            }
            board.retractPiece(m);
        }
        if (playerTurn.equals("X"))
            return max;
        else
            return min;

    }
}
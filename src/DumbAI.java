import java.util.ArrayList;

public class DumbAI extends Player {


    public DumbAI(String inName){
        super (inName);
    }

    public String getMove(Board board){
        ArrayList<String> spots=new ArrayList<>();
        spots=board.getEmptyLocs();
        for (int i=0; i<spots.size(); i++){
            board.placePiece(spots.get(i), "X");
            if (board.isWinner("X")){
                board.retractPiece(spots.get(i));
                return spots.get(i);
            }
            else{
                board.retractPiece(spots.get(i));
            }
        }

        for (int j=0; j<spots.size(); j++){
            board.placePiece(spots.get(j), "O");
            if (board.isWinner("O")){
                board.retractPiece(spots.get(j));
                return spots.get(j);
            }
            else{
                board.retractPiece(spots.get(j));
            }
        }


    }



    private ArrayList<Integer> isColgap (Board board){}


    private ArrayList<Integer> isRowgap(Board board){}


    private boolean isDiaggap(Board board){
       // ArrayList<Integer> location=new ArrayList<>();
        if (board.get(0,0).equals(board.get(2,2)) && board.getEmptyLocs().contains("5")){
            return true;
        }

        else if (board.get(0,2).equals(board.get(2,0)) && board.getEmptyLocs().contains("5")){
            return true;
        }

        return false;
    }
}

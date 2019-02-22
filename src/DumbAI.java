import java.util.ArrayList;
import java.util.Random;

public class DumbAI extends Player {


    public DumbAI(String inName){
        super (inName);
    }

    public String getMove(Board board){
        ArrayList<String> spots;
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

        Random r=new Random();

        int index=r.nextInt(spots.size());

        return spots.get(index);

    }


}

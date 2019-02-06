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
                return spots.get(i);
            }
            else{
                board.retractPiece(spots.get(i));
            }
        }

        for (int i=0; i<3; i++){
            if (board.streakInCol(i,"O",2)){
                if (spots.contains(board.get(0,i))){
                    return spots.get(spots.indexOf(board.get(0,i)));
                }
                else{
                    return spots.get(spots.indexOf(board.get(2,i)));
                }
            }

            else if (board.streakInRow(i,"O", 2)){
                if (spots.contains(board.get(i,0))){
                    return spots.get(spots.indexOf(board.get(i,0)));
                }
                else{
                    return spots.get(spots.indexOf(board.get(i,2)));
                }
            }
        }
    }



    private ArrayList<Integer> isColgap (Board board){}


    private ArrayList<Integer> isRowgap(Board board){}


    private ArrayList<Integer> isDiaggap(Board board){
        ArrayList<Integer> location=new ArrayList<>();
        if (board.get(0,0).equals(board.get(2,2)) && board.getEmptyLocs().contains("5")){
            location.add(5);
        }

        else if (board.get(0,2).equals(board.get(2,0)) && board.getEmptyLocs().contains("5")){
            location.add(5);
        }

        return location;
    }
}

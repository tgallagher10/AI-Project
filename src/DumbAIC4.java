import java.util.ArrayList;
import java.util.Random;

/**
 * Created by carlmeyer on 2/21/19.
 */
public class DumbAIC4 extends Player {

    public DumbAIC4(String inName){
        super (inName);
    }

    public String getMove(Board board){
        ArrayList<String> spots= getEmptyCols(board);

        for (int i=0; i<spots.size(); i++){
            board.placePiece(spots.get(i), "R");
            if (board.isWinner("R")){
                board.retractPiece(spots.get(i));
                System.out.println(spots.get(i));
                return spots.get(i);
            }
            else{
                board.retractPiece(spots.get(i));
            }
        }

        for (int j=0; j<spots.size(); j++){
            board.placePiece(spots.get(j), "Y");
            if (board.isWinner("Y")){
                board.retractPiece(spots.get(j));
                System.out.println(spots.get(j));
                return spots.get(j);
            }
            else{
                board.retractPiece(spots.get(j));
            }
        }

        Random r=new Random();

        int index=r.nextInt(spots.size());

        System.out.println(spots.get(index));

        return spots.get(index);

    }


    public ArrayList<String> getEmptyCols(Board board){
        ArrayList<String> cols = new ArrayList<>();
        for(int i = 0; i< board.getCols()-1;i++){
            if(board.get(0,i).equals("-")){
                cols.add(Integer.toString(i+1));
            }
        }
        return cols;
    }


}

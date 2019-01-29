import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Board board = null;
        if(in.next().equals("TTT")){
            board = new TTTBoard();
    }

        while (board.isGameOver()==false){
            System.out.println(board.toString());
            String turn=board.getTurn();
            System.out.println("Player "+ turn+" where would you like to move:");
            board.placePiece(in.nextLine(), board.getTurn());
            if (board.isWinner(turn)){
                System.out.println("Player "+ turn+" wins!");
            }
        }

    }
}

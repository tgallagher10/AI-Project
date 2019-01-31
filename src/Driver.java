import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("1. Tic-Tac-Toe (Human vs Human");
        System.out.println("2. Tic-Tac-Toe (Human vs Beginner AI");
        System.out.println("3. Tic-Tac-Toe (Human vs Pro AI");
        System.out.println("4. Connect 4 (Human vs Human");
        System.out.println("5. Connect 4 (Human vs Beginner AI");
        System.out.println("6. Connect 4 (Human vs Pro AI");
        System.out.println("Select your game (1-6):");

        Board board = null;
        if(in.next().equals("1")){
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
            else if (board.getEmptyLocs().size()==0){
                System.out.println("Cats Game");
            }
        }

    }
}

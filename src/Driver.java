import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("1. Tic-Tac-Toe (Human vs Human)");
        System.out.println("2. Tic-Tac-Toe (Human vs Beginner AI)");
        System.out.println("3. Tic-Tac-Toe (Human vs Pro AI)");
        System.out.println("4. Connect 4 (Human vs Human)");
        System.out.println("5. Connect 4 (Human vs Beginner AI)");
        System.out.println("6. Connect 4 (Human vs Pro AI)");
        System.out.println("Select your game (1-6):");

        Board board = null;
        Player p1=null;
        Player p2=null;
        int ans=in.nextInt();
        in.nextLine();
        if(ans<4){
            board = new TTTBoard();
            if (ans==1){
                p1=new HumanTTT("X");
                p2=new HumanTTT("O");
            }
            else if (ans==2){
                p1=new DumbAI("X");
                p2=new HumanTTT("O");
            }

            else if(ans==3){
                p1=new TTTPlayerProAI("X");
                p2=new HumanTTT("O");

            }
        }
        else{
            board = new Connect4Board();
            System.out.println(board.toString());
            if (ans==4){
                p1=new HumanC4("R");
                p2=new HumanC4("Y");
            }
            else if (ans == 5){
                p1 = new DumbAIC4("R");
                p2 = new HumanC4("Y");
            }
            }






        while (board.isGameOver()==false){
            String turn=board.getTurn();

            if (turn.equals("X") || turn.equals("R")){
                board.placePiece(p1.getMove(board), board.getTurn());
            }

            if (turn.equals("O") || turn.equals("Y")){
                board.placePiece(p2.getMove(board), board.getTurn());
                System.out.println(board.toString());
            }


            if (board.isWinner(turn)){
                System.out.println("Player "+ turn+" wins!");
                System.out.println(board.toString());
            }
            else if (board.getEmptyLocs().size()==0){
                System.out.println("Cats Game");
                System.out.println(board.toString());
            }
        }

    }
}

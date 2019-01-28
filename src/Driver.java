import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Board board = null;
        if(in.next().equals("TTT")){
            board = new TTTBoard();
    }


        System.out.println(board.toString());

    }
}

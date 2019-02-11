import java.util.Scanner;

public class HumanTTT extends Player{
    private String name;

    public HumanTTT(String inName){
        super (inName);
        name=inName;
    }

    public String getMove(Board board){
        Scanner in=new Scanner(System.in);
        System.out.println(board.toString());
        String turn=board.getTurn();
        System.out.println("Player "+ name +" where would you like to move:");
        String num=in.nextLine();
        return num;
    }


}

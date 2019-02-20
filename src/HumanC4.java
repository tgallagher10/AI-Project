import java.util.Scanner;

public class HumanC4 extends Player {
    private String name;

    public HumanC4(String inName){
        super(inName);
        name=inName;
    }

    public String getMove(Board board){
        Scanner in=new Scanner(System.in);
        System.out.println(board.toString());
        System.out.println("Player "+ name+" where would you like to move:");
        String num=in.nextLine();
        return num;
    }
}

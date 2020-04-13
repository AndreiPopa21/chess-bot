import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static Piece whiteHorse;
    public static Piece blackHorse;
    public static ReceiverXboard recv;
    public static Table table;

    public static void main(String[] args) {

        GameManager.newGame(Color.WHITE);
        GameManager.printTable();

        

        GameManager.executeMove(
            new Move(Constants.B1,Constants.C3,null)
        );

        GameManager.executeMove(
            new Move(Constants.B2,Constants.B3,null)
        );

        GameManager.executeMove(
            new Move(Constants.C1,Constants.A3,null)
        );

        GameManager.executeMove(
            new Move(Constants.C1,Constants.A3,null)
        );

        GameManager.executeMove(
            new Move(Constants.A3,Constants.E7,null)
        );

        GameManager.executeMove(
            new Move(Constants.E7,Constants.C5,null)
        );

        GameManager.executeMove(
            new Move(Constants.D8,Constants.H4,null)
        );

        GameManager.executeMove(
            new Move(Constants.F2,Constants.F3,null)
        );

        

      /*  table = new Table();
        recv = new ReceiverXboard(table);
        Scanner s = new Scanner(System.in);

        String mutare="start";

        Piece[][] board = table.getConfiguration();
        blackHorse = board[7][1];
        whiteHorse = board[0][1];

        while (mutare.compareTo("quit") != 0)
        {
            mutare= s.nextLine();
            boolean verificare_mutare = recv.comandComparer(mutare);

            if (verificare_mutare) {
                recv.table.move(mutare);
               if (recv.getE_color() == EngineColor.BLACK) {
                    moveBlack();
               }else {
                    moveWhite();
               }
            }

            if(mutare.equals("go"))
                if(recv.getE_color() == EngineColor.WHITE)
                    moveWhite();
                else
                    moveBlack();
        }*/

    }

   /* public static void moveWhite(){

        if(whiteHorse.getAllPossibleMoves() != null){
            ArrayList<String> whiteHorseMoves = whiteHorse.getAllPossibleMoves();
            int index = new Random().nextInt(whiteHorseMoves.size());
            recv.table.move(whiteHorseMoves.get(index));
            System.out.println("move " + whiteHorseMoves.get(index)) ;
            System.out.flush();
        }else{
            //System.out.println("Calul alb a fost capturat");
            System.out.println("0-1 {White resigns}");
        }
    }

    public static void moveBlack(){

        if(blackHorse.getAllPossibleMoves() != null) {
            ArrayList<String> blackHorseMoves = blackHorse.getAllPossibleMoves();
            int index = new Random().nextInt(blackHorseMoves.size());
            recv.table.move(blackHorseMoves.get(index));
            System.out.println("move " + blackHorseMoves.get(index)) ;
            System.out.flush();
        }
        else{
            //System.out.println("Calul negru a fost capturat");
            System.out.println("1-0 {Black resigns}");
        }
    }*/
}

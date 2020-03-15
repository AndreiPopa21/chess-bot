import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void print2D(String mat[][]) {
        // Loop through all rows
        for (int i = 0; i < mat.length; i++) {

            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {

        char[] a = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

        Vector<String> coloane = new Vector<String>();
        coloane.add("a");
        coloane.add("b");
        coloane.add("c");
        coloane.add("d");
        coloane.add("e");
        coloane.add("f");
        coloane.add("g");
        coloane.add("h");


        String[] coloane_litere={"h","g","f","e","d","c","b","a"};

        int[] coloane3={1,2,3,4,5,6,7,8};
        int[] lini = {1,2,3,4,5,6,7,8};

        String str , str2;

        Table table = new Table();
        //System.out.println(table.toString());
        /*ArrayList<String> moves = table.getConfiguration()[1][7].getAllPossibleMoves();
        for(int i = 0; i <moves.size(); i++)
            System.out.println(moves.get(i));*/
        //table.getConfiguration()[0][1].move("g1f3");
     /*   table.move("g1f3");
        System.out.println(table.toString());
        table.move("f3g5");
        System.out.println(table.toString());
        table.move("g5f7");
        System.out.println(table.toString());*/

        int index = 0;
        Scanner s = new Scanner(System.in);

        ReceiverXboard recv = new ReceiverXboard(table);

        System.out.println("xboard");
        System.out.flush();
        System.out.println("new");
        System.out.flush();


        System.out.println("feature sigint=0 sigterm=0 done=1");
        System.out.flush();


        String mutare="start";
        Piece[][] board = table.getConfiguration();
      //  System.out.println("asdfghjkljgfdsadfgfdsa"+board[7][1].getAllPossibleMoves().size());


        Piece cal = board[7][1];


        while (mutare.compareTo("quit") != 0)
        {

            mutare= s.nextLine();
            boolean verificare_mutare = recv.comandComparer(mutare);
/*
            str = String.valueOf(mutare.charAt(0));
            str2= String.valueOf(mutare.charAt(2));
*/
            if (verificare_mutare==true) {
                recv.table.move(mutare);
                //System.out.println(table.toString());
               // board = recv.table.getConfiguration();

                while (cal.getAllPossibleMoves()!=null) {
                    ArrayList<String> arr=cal.getAllPossibleMoves();
                    index = new Random().nextInt(arr.size());
                    recv.table.move(arr.get(index));

                    System.out.println(table.toString());
                    System.out.println("move " + arr.get(index));
                    System.out.flush();
                    System.out.println(cal.getPosition().digit+"--------"+cal.getPosition().letter);
                    break ;
                    //System.out.println(cal.getName());

                }
              /*
                if (recv.getE_color() == EnginColor.BLACK)
                {
                   /* for (int i = 7; i >= 0; i--) {
                        for (int j = 0; j <= 7; j++) {
                            if (board[i][j].getName().equals('p')) {
                                int minus1 = lini[i] - 1;
                                mutare = coloane_litere[j] + lini[i] + coloane_litere[j] + minus1;
                                table.move(mutare);
                                /*System.out.println("force");
                                System.out.flush();
                                System.out.println("quit");
                                System.out.flush();
                                System.out.println("1/2-1/2 {Draw}");
                                System.out.println("move " + mutare);
                                System.out.flush();


                                j = 8;
                                i = -1;
                                //   System.out.println(table.toString());
                            }
                        }
                    }*/
              /*  }else
                {
                    for (int i = 0; i <= 7; i++) {
                        for (int j = 0; j <= 7; j++) {
                            if (board[i][j].getName().equals('P')) {
                                int minus1 = lini[i] - 1;
                                mutare = coloane_litere[j] + lini[i] + coloane_litere[j] + minus1;
                                table.move(mutare);
                                System.out.println("move " + mutare);
                                System.out.flush();
                                j = 8;
                                i = -1;
                                //   System.out.println(table.toString());
                            }
                        }
                    }
                }*/
            }
        }
    }
}

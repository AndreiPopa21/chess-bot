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

        //String str , str2;

        Table table = new Table();
        ReceiverXboard recv = new ReceiverXboard(table);
        Scanner s = new Scanner(System.in);

        int index = 0;
        int steps_until_go = 0;
        String mutare="start";

        Piece[][] board = table.getConfiguration();
        Piece cal = board[7][1];

        while (mutare.compareTo("quit") != 0)
        {

            mutare= s.nextLine();
            boolean verificare_mutare = recv.comandComparer(mutare);

            if (verificare_mutare==true) {

                recv.table.move(mutare);

               if (steps_until_go!=4) {
                   while (cal.getAllPossibleMoves() != null) {

                       ArrayList<String> lista_mutari_pos_cal = cal.getAllPossibleMoves();
                       index = new Random().nextInt(lista_mutari_pos_cal.size());
                       recv.table.move(lista_mutari_pos_cal.get(index));
                       System.out.println(table.toString());
                       System.out.println("move " + lista_mutari_pos_cal.get(index)) ;
                       System.out.flush();
                       steps_until_go++;
                       System.out.println(cal.getPosition().digit + "--------" + cal.getPosition().letter);
                       break;

                   }
               }else
               {
                   /*steps_until_go=0;
                   cal=board[0][1];
                   System.out.println(cal.getName());
                   ArrayList<String> lista_mutari_pos_cal = cal.getAllPossibleMoves();
                   index = new Random().nextInt(lista_mutari_pos_cal.size());
                   recv.table.move(lista_mutari_pos_cal.get(index));
                   System.out.println("move " + lista_mutari_pos_cal.get(index));

                    */
               }

            }
        }
    }
}

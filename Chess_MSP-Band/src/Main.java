import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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

    public static void dummy() {

    }

    public static void main(String[] args) throws IOException {

        char[] a = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

        Table table = new Table();
        System.out.println(table.toString());
        ArrayList<String> moves = table.getConfiguration()[0][1].getAllPossibleMoves();
        for(int i = 0; i <moves.size(); i++)
            System.out.println(moves.get(i));

        int index = 0;
        Scanner s = new Scanner(System.in);
        s.nextLine();
        s.nextLine();
        s.nextLine();
        s.nextLine();
        s.nextLine();
        s.nextLine();
        s.nextLine();


        System.out.println("xboard");
        System.out.flush();
        System.out.println("new");
        System.out.flush();

        System.out.println("feature sigint=0 sigterm=0 done=1");
        System.out.flush();
        s.nextLine();
        s.nextLine();
        s.nextLine();
        System.out.flush();
        while (index!=8) {
            s.nextLine();
            System.out.flush();
            System.out.println("move "+a[index]+"7"+a[index]+"6");
            System.out.flush();
            index++;
            s.nextLine();
            System.out.flush();
            s.nextLine();
            System.out.flush();
        }
    }
}
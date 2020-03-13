import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

     //   System.out.println("feature sigint=0 sigterm=0 done=1");
      //  System.out.flush();

       // s.nextLine();
        while (index!=8) {

                s.nextLine();
            //if (s.equals("protover"))

          // System.out.println("force");
           // System.out.flush();
           // s.nextLine();
            System.out.println("move "+a[index]+"7"+a[index]+"6");
            System.out.flush();
            index++;
            s.nextLine();
            s.nextLine();

            /*s.nextLine();
            System.out.println("move c7c5");
            System.out.flush();

            s.nextLine();
            System.out.println("edit");
            System.out.flush();

           if (s.equals("protover"))
                System.out.println("feature sigint=0 sigterm=0 done=1");
            s.nextLine();
            System.out.println("move d7d6");
            System.out.flush();

            s.nextLine();
            System.out.println("move b7b6");
            System.out.flush();
            //index++;

             */
        }
    }
}
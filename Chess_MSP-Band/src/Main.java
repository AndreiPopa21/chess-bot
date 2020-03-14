import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    public static void dummy() {

    }

    public static int findIndex(int arr[], int t)
    {

        // if array is Null
        if (arr == null) {
            return -1;
        }

        // find length of array
        int len = arr.length;
        int i = 0;

        // traverse in the array
        while (i < len) {

            // if the i-th element is t
            // then return the index
            if (arr[i] == t) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }


    public static int findIndex_char(char arr[], char t)
    {

        // if array is Null
        if (arr == null) {
            return -1;
        }

        // find length of array
        int len = arr.length;
        int i = 0;

        // traverse in the array
        while (i < len) {

            // if the i-th element is t
            // then return the index
            if (arr[i] == t) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) throws IOException {

        /*char[] coloane = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        int[] lini = {1,2,3,4,5,6,7,8};
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

        while (index!=8) {

            s.nextLine();
            System.out.println("move "+a[index]+"7"+a[index]+"6");
            System.out.flush();
            index++;
            s.nextLine();
            s.nextLine();

        }*/

        Vector<String> coloane = new Vector<String>();
        coloane.add("a");
        coloane.add("b");
        coloane.add("c");
        coloane.add("d");
        coloane.add("e");
        coloane.add("f");
        coloane.add("g");
        coloane.add("h");

        String[] coloane_litere={"a","b","c","d","e","f","g","h"};

        int[] coloane3={1,2,3,4,5,6,7,8};
        int[] lini = {8,7,6,5,4,3,2,1};

        Vector<String> piese_albe = new Vector<String>();
        piese_albe.add("T");
        piese_albe.add("C");
        piese_albe.add("N");
        piese_albe.add("R");
        piese_albe.add("Q");
        piese_albe.add("P");

        Vector<String> piese_negre = new Vector<String>();
        piese_negre.add("t");
        piese_negre.add("c");
        piese_negre.add("n");
        piese_negre.add("r");
        piese_negre.add("q");
        piese_negre.add("p");
        int index = 0;

       /* Scanner s = new Scanner(System.in);
        System.out.println("Chouse player (1 or 2): ");
        String mutare = s.nextLine();
        int mutare_int = Integer.parseInt(mutare);


        while ((mutare_int != 1) && (mutare_int != 2)) {
            System.out.println("Chouse player (1 or 2): ");
            mutare = s.nextLine();
            mutare_int = Integer.parseInt(mutare);
        }*/

        //int player = Integer.parseInt(mutare);
        Scanner s = new Scanner(System.in);
        int player = 2;
        int mutare_veche_x = 0;
        int mutare_veche_y = 0;
        int mutare_noua_x = 0;
        int mutare_noua_y = 0;
        String str;
        String mutare = s.nextLine();
        int row = 8, column = 8;

        String[][] board = {{"T", "C", "N", "R", "Q", "N", "C", "T"},
                {"P", "P", "P", "P", "P", "P", "P", "P"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"p", "p", "p", "p", "p", "p", "p", "p"},
                {"t", "c", "n", "r", "q", "n", "c", "t"}};

      //  print2D(board);


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
        s.nextLine();S

        try {
            FileWriter file_iesire = new FileWriter("test.txt");

            while (mutare.compareTo("quit") != 0) {

               // System.out.println(mutare);
                file_iesire.write(mutare);
                file_iesire.write(System.getProperty("line.separator"));
                mutare = s.nextLine();
               // System.out.println(mutare.length());
               // System.out.println();
                 str = String.valueOf(mutare.charAt(0));
                if ((mutare.length() == 4)&&(coloane.contains(str))) { //System.out.println(mutare.charAt(0));
                        switch (mutare.charAt(0)) {
                            case 'a':
                                mutare_veche_x = 1;
                                break;

                            case 'b':
                                mutare_veche_x = 2;

                                break;

                            case 'c':
                                mutare_veche_x = 3;

                                break;
                            case 'd':
                                mutare_veche_x = 4;

                                break;
                            case 'e':

                                mutare_veche_x = 5;
                                break;
                            case 'f':

                                mutare_veche_x = 6;
                                break;
                            case 'g':

                                mutare_veche_x = 7;
                                break;

                            case 'h':

                                mutare_veche_x = 8;
                                break;
                            default:
                                System.out.println("Mutare invalida swich");
                        }
                        mutare_veche_y = Character.getNumericValue(mutare.charAt(1));

                        switch (mutare.charAt(2)) {
                            case 'a':
                                mutare_noua_x = 1;
                                break;

                            case 'b':
                                mutare_noua_x = 2;

                                break;

                            case 'c':

                                mutare_noua_x = 3;
                                break;
                            case 'd':

                                mutare_noua_x = 4;
                                break;
                            case 'e':

                                mutare_noua_x = 5;
                                break;
                            case 'f':

                                mutare_noua_x = 6;
                                break;
                            case 'g':
                                mutare_noua_x = 7;
                                break;

                            case 'h':
                                mutare_noua_x = 8;
                                break;
                            default:

                        }
                        mutare_noua_y = Character.getNumericValue(mutare.charAt(3));


                        if (player == 2) {
                            if ((board[findIndex(lini, mutare_veche_y)][findIndex(coloane3, mutare_veche_x)] == "0")
                                    && (piese_negre.contains(board[findIndex(lini, mutare_veche_y)][findIndex(coloane3, mutare_veche_x)]) == true)) {
                                System.out.println("Mutare Invalida");
                            } else {
                                board[findIndex(lini, mutare_noua_y)][findIndex(coloane3, mutare_noua_x)] = board[findIndex(lini, mutare_veche_y)][findIndex(coloane3, mutare_veche_x)];
                                board[findIndex(lini, mutare_veche_y)][findIndex(coloane3, mutare_veche_x)] = "0";
                            }
                        } else {
                            if ((board[findIndex(lini, mutare_veche_y)][findIndex(coloane3, mutare_veche_x)] == "0")
                                    && (piese_albe.contains(board[findIndex(lini, mutare_veche_y)][findIndex(coloane3, mutare_veche_x)]) == true)) {
                                System.out.println("Mutare Invalida");
                            } else {
                                board[findIndex(lini, mutare_noua_y)][findIndex(coloane3, mutare_noua_x)] = board[findIndex(lini, mutare_veche_y)][findIndex(coloane3, mutare_veche_x)];
                                board[findIndex(lini, mutare_veche_y)][findIndex(coloane3, mutare_veche_x)] = "0";

                            }
                        }
                       // print2D(board);

                        for (int i = 0 ; i < row;i++ )
                        {
                            for (int j = 0 ; i < column;j++)
                            {
                                if (board[i][j].compareTo("P")==0)
                                {
                                    int minus1=lini[i]-1;
                                    System.out.println("move "+coloane_litere[j]+lini[i]+coloane_litere[j]+minus1);
                                }
                            }
                        }

                    }

                }


                file_iesire.close();


            } catch(IOException e){
                e.printStackTrace();
            }
        }
}

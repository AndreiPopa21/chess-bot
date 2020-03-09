package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void print2D(String mat[][])
    {
        // Loop through all rows
        for (int i = 0; i < mat.length; i++) {

            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
	// write your code here
        Scanner s = new Scanner(System.in);
        System.out.println("Chouse player (1 or 2): ");
        String mutare = s.nextLine();
        int mutare_int=Integer.parseInt(mutare);


        while ((mutare_int!=1)&&(mutare_int!=2))
        {
            System.out.println("Chouse player (1 or 2): ");
            mutare = s.nextLine();
            mutare_int=Integer.parseInt(mutare);
        }

        int player = Integer.parseInt(mutare);
        int mutare_veche_x=0;
        int mutare_veche_y=0;
        int mutare_noua_x=0;
        int mutare_noua_y=0;

        int row=8,column=8;

        String[][] board = {  { "T","C","N","R","Q","N","C","T"},
                            { "P","P","P","P","P","P","P","P"},
                            { "0","0","0","0","0","0","0","0"},
                            { "0","0","0","0","0","0","0","0"},
                            { "0","0","0","0","0","0","0","0"},
                            { "0","0","0","0","0","0","0","0"},
                            { "p","p","p","p","p","p","p","p"},
                            { "t","c","n","r","q","n","c","t"}};

        print2D(board);

        try {
            FileWriter file_iesire = new FileWriter("test.txt");

            while (mutare.compareTo("quit")!=0) {

                System.out.println(mutare);
                file_iesire.write(mutare);
                file_iesire.write(System.getProperty( "line.separator" ));
                mutare = s.nextLine();

                //System.out.println(mutare.charAt(0));
                    switch (mutare.charAt(0)){
                        case 'a':
                            mutare_veche_x=1;
                            break;

                        case 'b':
                            mutare_veche_x=2;

                            break;

                        case 'c':
                            mutare_veche_x=3;

                            break;
                        case 'd':
                            mutare_veche_x=4;

                            break;
                        case 'e':

                            mutare_veche_x=5;
                            break;
                        case 'f':

                            mutare_veche_x=6;
                            break;
                        case 'g':

                            mutare_veche_x=7;
                            break;

                        case 'h':

                            mutare_veche_x=8;
                            break;
                            default:
                                System.out.println("Mutare invalida swich");
                    }
                    mutare_veche_y=Character.getNumericValue(mutare.charAt(1));

                    switch (mutare.charAt(2)){
                        case 'a':
                            mutare_noua_x=1;
                            break;

                        case 'b':
                            mutare_noua_x=2;

                            break;

                        case 'c':

                            mutare_noua_x=3;
                            break;
                        case 'd':

                            mutare_noua_x=4;
                            break;
                        case 'e':

                            mutare_noua_x=5;
                            break;
                        case 'f':

                            mutare_noua_x=6;
                            break;
                        case 'g':
                            mutare_noua_x=7;
                            break;

                        case 'h':
                            mutare_noua_x=8;
                            break;
                        default:

                    }
                    mutare_noua_y=Character.getNumericValue(mutare.charAt(3));


                if (player==2) {
                    if ((mutare_veche_y !=8)&&(mutare_veche_y !=7))
                    {
                        System.out.println("Mutare Invalida");
                    }else
                    {
                        System.out.println(board[mutare_noua_y][mutare_noua_x]);
                        System.out.println(board[mutare_noua_y][mutare_noua_x]);
                        board[mutare_noua_y][mutare_noua_x]=board[mutare_noua_y][mutare_noua_x];
                        board[mutare_noua_y][mutare_noua_x]="0";

                    }
                }else
                {
                    if ((mutare_veche_y !=1)&&(mutare_veche_y !=2))
                    {
                        System.out.println("Mutare Invalida");
                    }else
                    {
                        board[mutare_noua_y][mutare_noua_x]=board[mutare_noua_y][mutare_noua_x];
                        board[mutare_noua_y][mutare_noua_x]="0";

                    }
                }
                print2D(board);


            }


            file_iesire.close();


        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
/*
a                    if (mutare.charAt(0)=='a')
                            {

                            }

                            if (mutare.charAt(0)=='b')
                            {

                            }

                            if (mutare.charAt(0)=='c')
                            {

                            }

                            if (mutare.charAt(0)=='d')
                            {

                            }

                            if (mutare.charAt(0)=='e')
                            {

                            }

                            if (mutare.charAt(0)=='f')
                            {

                            }

                            if (mutare.charAt(0)=='g')
                            {

                            }

                            if (mutare.charAt(0)=='h')
                            {

                            }
*/
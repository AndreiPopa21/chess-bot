import java.util.Collection;
import java.util.Scanner;
import java.util.Vector;

public final class ReceiverXboard {

    private ReceiverXboard(){

    }

   /* public EngineColor getE_color(){
        return e_color;
    }*/


    public static void xboard() {

    }


    public static void New() {
        System.out.println("feature sigint=0 sigterm=0 done=1 colors=0");
        System.out.flush();
        GameManager.setColor(Color.BLACK);
        GameManager.newGame(Color.BLACK);
    }


    public static void force() {

    }


    public static boolean go() {
      //  System.out.println("Am ajuns aici si culoarea mea curenta este "+this.e_color);
        if(GameManager.getColor() == Color.BLACK)
            GameManager.setColor(Color.WHITE);
        else
            GameManager.setColor(Color.BLACK);
        //System.out.println("Am ajuns aici si culoarea mea curenta este "+this.e_color);
        return true;
    }

    public static void white() {
        System.out.println("Sa apelat White");
        GameManager.setColor(Color.BLACK);
    }


    public static void black() {
        System.out.println("Sa apelat Black");
        GameManager.setColor(Color.WHITE);
    }


    public static void quit() {

    }


    public static void resign() {
       /* if (GameManager.getColor()==Color.BLACK)
        {
            System.out.println("0-1 {White resigns}");
        }else
            System.out.println("1-0 {Black resigns}");*/
    }


    public static boolean move(String mutare) {
        int a = mutare.charAt(0);
        int b = mutare.charAt(1) - 48;
        int c = mutare.charAt(2);
        int d = mutare.charAt(3) - 48;
        if (GameManager.validateMove(new Move(a*10+b,c*10+d,0)))
        {
            GameManager.getTable().updateTable(new Move(a*10+b,c*10+d,0));
            return true;
        }else
        {
            return false;
        }

    }



   // public String mutare(String move){
    //    return move;
  //  }


    //o-o  == rocada mica
    //o-o-o === rocada mare
    // e2e4+ === sah
    //e2e4# === sah mat
    // promotion


    public static boolean comandComparer(String command){


        Vector<String> coloane = new Vector<String>();
        coloane.add("a");
        coloane.add("b");
        coloane.add("c");
        coloane.add("d");
        coloane.add("e");
        coloane.add("f");
        coloane.add("g");
        coloane.add("h");

        if (command.equals(".")) {
            return false;
        }

        if ("xboard".equals(command))
        {
            xboard();
        }else if ("new".equals(command))
        {
            New();
        }else if ("force".equals(command))
        {
            force();
        }else if ("go".equals(command))
        {
           return go();
        }else if ("white".equals(command))
        {
            white();
        }else if ("black".equals(command))
        {
            black();
        }else if ("quit".equals(command))
        {
            quit();
        }else if ("resign".equals(command))
        {
            resign();
        }else
        {
            String str = String.valueOf(command.charAt(0));
            String str2= String.valueOf(command.charAt(2));
            if ((command.length() == 4)&&(coloane.contains(str))&&(coloane.contains(str2))){
               // this.move(command);
                return move(command);
            }
        }
        return false;
    }

    public static void recive(){
        Scanner s = new Scanner(System.in);
        String mutare = "start";
        while(mutare.compareTo("quit") != 0) {
            mutare = s.nextLine();
            if (comandComparer(mutare)){
                MiniMax.thinkMove();
            }

        }
    }

}

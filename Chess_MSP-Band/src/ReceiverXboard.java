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
        System.out.println("[ReciverXboard] Sa primit Xboard");
    }


    public static void New() {
        System.out.println("[ReciverXboard] Sa primit New");
        System.out.println("feature sigint=0 sigterm=0 done=1 colors=0");
        System.out.flush();
        MiniMax.index_white = 0;
        MiniMax.index_black = 0;
        GameManager.setColor(Color.BLACK);
        GameManager.newGame(Color.BLACK);
    }


    public static void force() {
        System.out.println("[ReciverXboard] Sa primit force");
    }


    public static boolean go() {
      //  System.out.println("Am ajuns aici si culoarea mea curenta este "+this.e_color);
        System.out.println("[ReciverXboard]Sa primit GO");
        if(GameManager.getColor() == Color.BLACK)
            GameManager.setColor(Color.WHITE);
        else
            GameManager.setColor(Color.BLACK);
        //System.out.println("Am ajuns aici si culoarea mea curenta este "+this.e_color);
        return true;
    }

    public static void white() {
        System.out.println("[ReciverXboard] Sa apelat White");
        GameManager.setColor(Color.BLACK);
    }


    public static void black() {
        System.out.println("[ReciverXboard] Sa apelat Black");
        GameManager.setColor(Color.WHITE);
    }


    public static void quit() {

    }


    public static void resign() {
        System.out.println("[ReciverXboard] sa primit resign");
        if (GameManager.getColor()==Color.BLACK)
        {
            System.out.println("0-1 {White resigns}");
        }else
            System.out.println("1-0 {Black resigns}");
    }


    public static boolean move(String mutare) {
        System.out.println("[ReciverXboard] Sa primit move..........................."+mutare);
        int a = mutare.charAt(0);
        int b = mutare.charAt(1) - 48;
        int c = mutare.charAt(2);
        int d = mutare.charAt(3) - 48;
        Move mv;

        if (mutare.compareTo("e1g1") == 0)
        {
            mv = new Move(0,0,Constants.WHITE_KING_SIDE_CASTLING);

        } else if (mutare.compareTo("e1c1") == 0)
        {
            mv = new Move(0,0,Constants.WHITE_QUEEN_SIDE_CASTLING);

        } else if (mutare.compareTo("e8g8") == 0)
        {
            mv = new Move(0,0,Constants.BLACK_KING_SIDE_CASTLING);

        } else if (mutare.compareTo("e8c8") == 0)
        {
            mv = new Move(0,0,Constants.BLACK_QUEEN_SIDE_CASTLING);
        } else
        {
            mv = new Move(a*10+b,c*10+d,0);
        }

        if (GameManager.validateMove(mv))
        {
                GameManager.record(mv);
                GameManager.getTable().updateTable(mv);
                return true;
        }else
        {
            return false;
        }

    }

    public static boolean promotionMove(String mutare) {
        System.out.println("[ReciverXboard] Sa primit PromotionMove");
        int a = mutare.charAt(0);
        int b = mutare.charAt(1) - 48;
        int c = mutare.charAt(2);
        int d = mutare.charAt(3) - 48;
        Move mv = new Move(a * 10 + b, c * 10 + d, Constants.QUEEN_PROMOTION);

        if (GameManager.validateMove(mv))
        {
            GameManager.record(mv);
            GameManager.getTable().updateTable(mv);
            return true;
        }
        return false;
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
            String str2 = String.valueOf(command.charAt(2));

            if ((command.length() == 4)&&(coloane.contains(str))&&(coloane.contains(str2))){
               // this.move(command);
                return move(command);
            }else if (command.length() == 5)
            {
                String strProm = String.valueOf(command.charAt(4));
                if ((coloane.contains(str))
                        &&(coloane.contains(str2))&&(strProm.compareTo("q") == 0))
                {
                    return promotionMove(command);
                }
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

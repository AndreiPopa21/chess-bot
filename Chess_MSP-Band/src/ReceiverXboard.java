import java.util.Scanner;
import java.util.Vector;

public final class ReceiverXboard {

    private ReceiverXboard(){

    }

    private static boolean isForced = false;
    private static boolean isProtover = false;

    public static void xboard() {
       // System.out.println("[ReceiverXboard] S-a primit XBOARD");
    }


    public static void New() {
       // System.out.println("[ReceiverXboard] S-a primit NEW");
        Sender.sendFeatures(); 

        System.out.flush();
        MiniMax.index_white = 0;
        MiniMax.index_black = 0;
        GameManager.setColor(Color.BLACK);
        GameManager.newGame(Color.BLACK);
    }

    public static void protover(){

        Sender.sendFeatures(); 

        MiniMax.index_white = 0;
        MiniMax.index_black = 0;
        GameManager.setColor(Color.BLACK);
        GameManager.newGame(Color.BLACK);
    }


    public static void force() {
      //  System.out.println("[ReceiverXboard] S-a primit FORCE");
        isForced = true;
    }


    public static boolean go() {
      //  System.out.println("[ReceiverXboard] S-a primit GO");

        if(isForced){
            /*if(GameManager.getColor() == Color.BLACK)
                GameManager.setColor(Color.WHITE);
            else
                GameManager.setColor(Color.BLACK);*/
             //System.out.println("Am ajuns aici si culoarea mea curenta este "+this.e_color);

            if(GameManager.getCurrMove() % 2 == 1){
                GameManager.setColor(Color.WHITE);
            }else{
                GameManager.setColor(Color.BLACK);
            }
            
            isForced = false;
            return true;
        }
        return false;
    
    }

    public static void white() {
       // System.out.println("[ReceiverXboard] S-a apelat WHITE");
        GameManager.setColor(Color.BLACK);
    }


    public static void black() {
      //  System.out.println("[ReceiverXboard] S-a apelat BLACK");
        GameManager.setColor(Color.WHITE);
    }


    public static void quit() {
       // System.out.println("[ReceiverXboard] S-a apelat QUIT");
    }


    public static void resign() {

       // System.out.println("[ReceiverXboard] S-a primit RESIGN");
        if (GameManager.getColor()==Color.BLACK)
        {
            System.out.println("0-1 {White resigns}");
        }else
            System.out.println("1-0 {Black resigns}");
    }


    public static boolean move(String mutare) {
       
       // System.out.println("[ReceiverXboard] S-a primit MOVE..........................."+mutare);
        int a = mutare.charAt(0);
        int b = mutare.charAt(1) - 48;
        int c = mutare.charAt(2);
        int d = mutare.charAt(3) - 48;

        int leftWhiteEnpass = (a + 1) * 10 + (b + 1);
        int rightWhiteEnpass = (a - 1) * 10 + (b + 1);
        int leftBlackEnpass = (a + 1) * 10 + (b - 1);
        int rightBlackEnpass = (a - 1) * 10 + (b - 1);
        int startPozition = a * 10 + b;
        int destinationPozition = c * 10 + d;
        Move move;

        if (mutare.compareTo("e1g1") == 0) {
            move = new Move(0,0,Constants.WHITE_KING_SIDE_CASTLING);

        } else if (mutare.compareTo("e1c1") == 0) {
            move = new Move(0,0,Constants.WHITE_QUEEN_SIDE_CASTLING);

        } else if (mutare.compareTo("e8g8") == 0) {
            move = new Move(0,0,Constants.BLACK_KING_SIDE_CASTLING);

        } else if (mutare.compareTo("e8c8") == 0) {
            move = new Move(0,0,Constants.BLACK_QUEEN_SIDE_CASTLING);
        } else if (!(GameManager.getTable().getSquares().get(destinationPozition).hasPiece()) &&
                ((GameManager.getTable().getSquares().get(startPozition).getPiece().getName() == 'P') ||
                        (GameManager.getTable().getSquares().get(startPozition).getPiece().getName() == 'p') )&&
                ((leftWhiteEnpass == destinationPozition) || (rightWhiteEnpass == destinationPozition)
                        || (leftBlackEnpass == destinationPozition) || (rightBlackEnpass == destinationPozition))) {
            move = new Move(startPozition,destinationPozition, Constants.EN_PASSANT);
        } else {
            move = new Move(startPozition,destinationPozition,0);
        }

        return GameManager.executeMove(move);
    }

    public static boolean promotionMove(String mutare) {

        System.out.println("[ReciverXboard] S-a primit PROMOTION");
        int a = mutare.charAt(0);
        int b = mutare.charAt(1) - 48;
        int c = mutare.charAt(2);
        int d = mutare.charAt(3) - 48;
        Move move = new Move(a * 10 + b, c * 10 + d, Constants.QUEEN_PROMOTION);

        return GameManager.executeMove(move);
    }


    public static boolean commandComparer(String command){

        Vector<String> coloane = new Vector<String>();
        coloane.add("a");
        coloane.add("b");
        coloane.add("c");
        coloane.add("d");
        coloane.add("e");
        coloane.add("f");
        coloane.add("g");
        coloane.add("h");

        if(command == null) return false;
        if(command.isBlank()) return false;
        if(command.isEmpty()) return false;

        if (command.equals(".")) {
            return false;
        }

        String upToNCharacters = command.substring(0, Math.min(command.length(), 7));


        if ("xboard".equals(command))
        {
            xboard();
        }else if ("new".equals(command))
        {
            New();
        }else if ("force".equals(command))
        {
            force();
        }else if("protover".equals(upToNCharacters)){

            protover();
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
            if(command.length() < 4) return false;

            String str = String.valueOf(command.charAt(0));
            String str2 = String.valueOf(command.charAt(2));

            /*if(command.length() == 4){
                if(coloane.contains(str)){
                    if(coloane.contains(str2)){
                        return move(command);
                    }
                }
            }

            if(command.length() == 5){
                String strProm = String.valueOf(command.charAt(4));
                if(coloane.contains(str)){
                    if(coloane.contains(str2)){
                        if(strProm.compareTo("q") == 0){
                            return promotionMove(command);
                        }
                    }
                }
            }*/

            if ((command.length() == 4)&&(coloane.contains(str))&&(coloane.contains(str2))){
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

    public static void receive(){
        Scanner sc = new Scanner(System.in);
        String mutare = "start";
        while(mutare.compareTo("quit") != 0) {
            mutare = sc.nextLine();
            if (commandComparer(mutare)){
                if(!isForced)
                   // MiniMax.thinkMove();
                   GameManager.manageTurn();
            }

        }
        sc.close();
    }

}

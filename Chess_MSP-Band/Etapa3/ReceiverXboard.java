import java.util.Scanner;
import java.util.Vector;

//clasa ReceiverXboard e de tip Singleton
//aceasta se ocupa de primirea si interpretarea comenzilor de la Xboard
//clasa comunica mai departe cu GameManager 
public final class ReceiverXboard {


    //constructoru privat, pattern Singleton
    private ReceiverXboard(){

    }

    //variabile care ne spune daca suntem in Force-Mode
    //in acest timp, noi putem doar primi si executa mutari, fara sa trimitem 
    private static boolean isForced = false;


    //metoda pentru comanda xboard
    public static void xboard() {
       // System.out.println("[ReceiverXboard] S-a primit XBOARD");
    }


    //metoda pentru comanda new
    //am presupus ca pentru versiunea de protocol 1, mi se va trimite new
    //si de aici voi trimite toate celelalte features
    public static void New() {
       // System.out.println("[ReceiverXboard] S-a primit NEW");
        Sender.sendFeatures(); 

        System.out.flush();
        GameManager.setColor(Color.BLACK);
        GameManager.newGame(Color.BLACK);

        if(isForced){
            isForced = false;
        }

    }


    //metoda pentru comanda protover
    //am presupus ca pentru versiunile de protocol >= 2 mi se va trimite protover
    //si de aici voi trimite toate celelate features
    public static void protover(){

        Sender.sendFeatures(); 

        GameManager.setColor(Color.BLACK);
        GameManager.newGame(Color.BLACK);


    }


    //metoda care pune jocul in Force-Mode
    public static void force() {
      //  System.out.println("[ReceiverXboard] S-a primit FORCE");
        isForced = true;
    }


    //metoda care deblocheaza Force-Mode si seteaza culoarea corespunzatoare
    public static boolean go() {
      //  System.out.println("[ReceiverXboard] S-a primit GO");

        if(isForced){
           
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


    //metoda pentru comanda white
    public static void white() {
       // System.out.println("[ReceiverXboard] S-a apelat WHITE");
        GameManager.setColor(Color.BLACK);
    }


    //metoda pentru comanda black
    public static void black() {
      //  System.out.println("[ReceiverXboard] S-a apelat BLACK");
        GameManager.setColor(Color.WHITE);
    }


    //metoda pentru comanda quit
    public static void quit() {
       // System.out.println("[ReceiverXboard] S-a apelat QUIT");
    }


    //metoda pentru comanda resign
    public static void resign() {

       // System.out.println("[ReceiverXboard] S-a primit RESIGN");
        if (GameManager.getColor()==Color.BLACK)
        {
            System.out.println("0-1 {White resigns}");
        }else
            System.out.println("1-0 {Black resigns}");
    }


    //metoda care interpreteaza tipul de mutare primit
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


    //metoda care verifica daca o mutare e de tip Promotion
    public static boolean promotionMove(String mutare) {

        //System.out.println("[ReciverXboard] S-a primit PROMOTION");
        int a = mutare.charAt(0);
        int b = mutare.charAt(1) - 48;
        int c = mutare.charAt(2);
        int d = mutare.charAt(3) - 48;
        Move move = new Move(a * 10 + b, c * 10 + d, Constants.QUEEN_PROMOTION);

        return GameManager.executeMove(move);
    }


    //metoda care decide ce comanda s-a primit de la xboard
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

        String upToNCharacters = command.substring(0, Math.min(command.length(), 8));


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


    //metoda care citeste intr-un while input-urile de la xboard
    public static void  receive(){
        Scanner sc = new Scanner(System.in);
        String mutare = "start";
        while(mutare.compareTo("quit") != 0) {
            mutare = sc.nextLine();
            if (commandComparer(mutare)){
                if(!isForced)
                   GameManager.manageTurn();
            }
        }
        sc.close();
    }

}

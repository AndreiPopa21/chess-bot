//clasa Sender e de tip Singleton
//aceasta comunica inapoi lui Xboard mutarile si deciziile 
//luate de catre GameManager
public final class Sender {

    //metoda care primeste o mutare si o formateaza corespunzator
    public static  void parserMove(Move m){

        if(m.moveType == Constants.WHITE_KING_SIDE_CASTLING){
            printXboardMove("e1g1");
            return;
        }


        if(m.moveType == Constants.WHITE_QUEEN_SIDE_CASTLING){
            printXboardMove("e1c1");
            return;
        }


        if(m.moveType == Constants.BLACK_KING_SIDE_CASTLING){
            printXboardMove("e8g8");
            return;
        }


        if(m.moveType == Constants.BLACK_QUEEN_SIDE_CASTLING){
            printXboardMove("e8c8");
            return;
        }


        char sursaCifra = (char)(m.source % 10 + 48);
        char sursaLitera = (char)(m.source / 10 );
        char destinatieCifra = (char)(m.dest % 10 + 48);
        char destinatieLitera = (char)(m.dest / 10);
        String command = "" + sursaLitera + sursaCifra + destinatieLitera + destinatieCifra ;
        printXboardMove(command);
    }


    //metoda care actualizeaza tura curenta si care trimite mutarea 
    public static void printXboardMove(String command){
        GameManager.nextMove();
       // System.out.println("Am timisssssssssssssssss "+command);
        System.out.println("move "+command);

    }


    //metoda care printeaza decizia de resign
    public static void resignPrint(){
        if (GameManager.getColor() == Color.BLACK){
            System.out.println("1-0 {Black resigns}");
        }else
            System.out.println("1-0 {White resigns}");
    }

    //metoda care trimite features-urile la Xboard
    //pentru protocol 1 , metoda e apelata din metoda New() din ReceiverXboard
    //pentru protocol >=2 , metoda e apelata din metoda protover() din ReceiverXboard
    public static void sendFeatures(){
        System.out.println("feature sigint=0 sigterm=0 san=0 done=1 colors=0");
    }
}

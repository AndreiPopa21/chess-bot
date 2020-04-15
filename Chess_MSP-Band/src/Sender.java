public final class Sender {

    public static  void parserMove(Move m){
        char sursaCifra = (char)(m.source % 10 + 48);
        char sursaLitera = (char)(m.source / 10 );
        char destinatieCifra = (char)(m.dest % 10 + 48);
        char destinatieLitera = (char)(m.dest / 10);
        String command = "" + sursaLitera + sursaCifra + destinatieLitera + destinatieCifra ;
        printXboardMove(command);
    }

    public static void printXboardMove(String command){
        System.out.println("move "+command);
    }

    public static void resignPrint(){
        if (GameManager.getColor() == Color.BLACK){
            System.out.println("1-0 {Black resigns}");
        }else
            System.out.println("1-0 {White resigns}");
    }

}

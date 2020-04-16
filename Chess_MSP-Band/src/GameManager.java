import java.util.ArrayList;
import java.util.Vector;

public final class GameManager{
    
    private static Table currTable = null;
    private static Color currPlayer;
    private static Vector<HistoryPairs> history = new Vector<HistoryPairs>();


    //white king-side castling     King - e1g1 | Rook - h1f1
    //white queen-side castling    King - e1c1 | Rook - a1d1
    //black king-side castling     King - e8g8 | Rook - h2f2
    //black queen-side castling    King - e8c8 | Rook - a8d8


    // e2e4 - new Move(E2,E4, 0);

    // king-side castling   O - O  
    // queen-side castling  O - O - O

    private static boolean whiteCastled = false;
    private static boolean blackCastled = false;

    
    private GameManager(){
        //do nothing 
    }







    public static void newGame(Color playeColor){
        currPlayer = playeColor;
        currTable = new Table();
    }












    public static void printTable(){
        if(currTable == null){
            System.out.println("NULL table, nothing to be printed");
            return;
        }
        System.out.println(currTable.toString());
    }






    public static void setColor(Color color){
        currPlayer = color;
    }












    public static Color getColor(){
        return currPlayer;
    }

    public static Table getTable(){
        return currTable;
    }



    // updateTable(new Move(E1,G1,0)); -- muta regele
    // updateTable(new Move(H1,F1,0)); -- muta tura


    public static void executeMove(Move move){
        if(validateMove(move)){
            getTable().updateTable(move);
        }else{
            System.out.println("[GameManager] Cannot execute illegal move: " + move.toString());
        }
        printTable();
    }






    // noi -Negru
    // adversa - ALB

    //

    // new Move (0 ,0 , White-QUEEN--side-castling)


    // nu tine de cont de cine e la mutare
    public static boolean validateMove(Move move){

        if(move.source == 0 && move.dest == 0 && move.moveType != 0){
            return getTable().validateSpecialMove(move);
        }


        int src = move.source;
        int dest = move.dest;
        
        Square srcSq = getTable().getSquares().get(src);
        Square destSq = getTable().getSquares().get(dest);

        if(srcSq == null){
            System.out.println("[GameManager] Invalid source square: " + move.toString());
            return false;
        } 
        if(destSq == null){
            System.out.println("[GameManager] Invalid source square: " + move.toString());  
            return false;
        } 
        
        if(!srcSq.hasPiece()){
            System.out.println("[GameManager] Source square does not have piece: " + move.toString());
            return false;
        }

        ArrayList<Move> moves = srcSq.getPiece().searchMoves(srcSq.getPosition());
        for(int i = 0; i < moves.size(); i++){
            System.out.println("[GameManager] Valid Move: " + moves.get(i).toString());
        }
        for(int i = 0; i < moves.size(); i++){
            Move next = moves.get(i);
            if((next.source == move.source) 
                && (next.dest == move.dest)){
                    return true;
                }
        }

        return false;
    }





   // public static Vector<Pair<Integer, Integer>> history;

   // public static void record(Move move){
        // o scrie in vector
     //   history.add()
        //history.add()
   // }

    public static void record(Move m){

        history.add(new HistoryPairs(m.source,m.dest,GameManager.currTable.getSquares().get(m.source).getPiece().getName()));
    }


    public static String toStringHistory() {
        String out = "";
        String a ,b,c,d;
        for (HistoryPairs i : history)
        {
            a = String.valueOf((char)(i.startPozition % 10 + 48));
            b = String.valueOf((char)(i.startPozition / 10));
            c = String.valueOf((char)(i.finishPozition % 10 + 48));
            d = String.valueOf((char)(i.finishPozition / 10));
            out += String.valueOf(i.piece)+b+a+d+c+" ";
        }
        return out;
    }

    public static boolean searchHistoryFor(String name) {

        if (name.compareTo("KA") == 0) {
            for (HistoryPairs i : history) {
                if (i.startPozition == Constants.E1) {
                    return true;
                }
            }
        } else if (name.compareTo("kn") == 0) {
            for (HistoryPairs i : history) {
                if (i.startPozition == Constants.H1) {
                    return true;
                }
            }
        } else if (name.compareTo("r1") == 0) {
            for (HistoryPairs i : history) {
                if (i.startPozition == Constants.A1) {
                    return true;
                }
            }
        } else if (name.compareTo("r2") == 0) {
            for (HistoryPairs i : history) {
                if (i.startPozition == Constants.E8) {
                    return true;
                }
            }
        } else if (name.compareTo("R1") == 0) {
            for (HistoryPairs i : history) {
                if (i.startPozition == Constants.H8) {
                    return true;
                }
            }
        } else if (name.compareTo("R2") == 0) {
            for (HistoryPairs i : history) {
                if (i.startPozition == Constants.A8) {
                    return true;
                }
            }
        }

        return false;
    }
    // class Record{ Move move; String movedPiece;}

    







    // (..) -



    // en=passsant



    

}





//PASSED: instantiating new Table
//PASSED: printing Table
import java.util.ArrayList;
import java.util.Vector;

public final class GameManager{
    
    private static Table currTable = null;
    private static Color currPlayer;
    private static Vector<HistoryPairs> history = new Vector<HistoryPairs>();

    private static int currMove = 1;
    
    private GameManager(){
        //do nothing 
    }


    public static void newGame(Color playeColor){
        currMove = 1;
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

    public static Vector<HistoryPairs> getHistory(){
        return history;
    }


    public static boolean executeMove(Move move){
        if(validateMove(move)){
            record(move);
            nextMove();
            getTable().updateTable(move);
            printTable();
            return true;
        }else{
            System.out.println("[GameManager] Cannot execute illegal move: " + move.toString());
            printTable();
            return false;
        }
    }


    public static boolean validateMove(Move move){

        if( move.moveType != 0 && move.moveType!=Constants.QUEEN_PROMOTION){
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


    public static void record(Move m){
        HistoryPairs hp;
        if (m.moveType == Constants.WHITE_KING_SIDE_CASTLING) {
            hp = new HistoryPairs(Constants.E1,Constants.G1,'K');

        } else if (m.moveType == Constants.WHITE_QUEEN_SIDE_CASTLING) {
            hp = new HistoryPairs(Constants.E1,Constants.C1,'K');

        } else if (m.moveType == Constants.BLACK_KING_SIDE_CASTLING) {
            hp = new HistoryPairs(Constants.E8,Constants.G8,'k');

        } else if (m.moveType == Constants.BLACK_QUEEN_SIDE_CASTLING) {
            hp = new HistoryPairs(Constants.E8,Constants.C8,'k');

        } else {
            hp = new HistoryPairs(m.source,m.dest,GameManager.currTable.getSquares().get(m.source).getPiece().getName());

        }
        history.add(hp);
    }


    public static void nextMove(){
        currMove += 1;
    }


    public static int getCurrMove(){
        return currMove;
    }


    public static String toStringHistory() {
        String out = "";
        String a ,b,c,d;
        for (HistoryPairs i : history)
        {
            a = String.valueOf((char)(i.startPosition % 10 + 48));
            b = String.valueOf((char)(i.startPosition / 10));
            c = String.valueOf((char)(i.finishPosition % 10 + 48));
            d = String.valueOf((char)(i.finishPosition / 10));
            out += String.valueOf(i.piece)+b+a+d+c+" ";
        }
        return out;
    }

    //TODO defineste cu supraincarcare inca o metoda searchHistoryFor
    // cu parametru de Move, in loc sa caut dupa un string, sa caut dupa un obiect Move
    public static boolean searchHistoryFor(String name) {

        if (name.compareTo("KA") == 0) {
            for (HistoryPairs i : history) {
                if (i.startPosition == Constants.E1) {
                    return true;
                }
            }
        } else if (name.compareTo("kn") == 0) {
            for (HistoryPairs i : history) {
                if (i.startPosition == Constants.E8) {
                    return true;
                }
            }
            //r1 tura neagra de pe A8
        } else if (name.compareTo("r1") == 0) {
            for (HistoryPairs i : history) {
                if (i.startPosition == Constants.A8) {
                    return true;
                }
            }
            // r2 tura neagra pentru H8
        } else if (name.compareTo("r2") == 0) {
            for (HistoryPairs i : history) {
                if (i.startPosition == Constants.H8) {
                    return true;
                }
            }
            // R1 tura alba pentru A1
        } else if (name.compareTo("R1") == 0) {
            for (HistoryPairs i : history) {
                if (i.startPosition == Constants.A1) {
                    return true;
                }
            }
            // R2 tura alba pt H1
        } else if (name.compareTo("R2") == 0) {
            for (HistoryPairs i : history) {
                if (i.startPosition == Constants.H1) {
                    return true;
                }
            }
        }

        return false;
    }

}

import java.util.ArrayList;

public final class GameManager{
    
    private static Table currTable = null;
    private static Color currPlayer;
    
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

    public static void executeMove(Move move){
        if(validateMove(move)){
            getTable().updateTable(move);
        }else{
            System.out.println("[GameManager] Cannot execute illegal move: " + move.toString());
        }
        printTable();
    }

    public static boolean validateMove(Move move){
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
           // System.out.println("[GameManager] Valid Move: " + moves.get(i).toString());
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

}


//PASSED: instantiating new Table
//PASSED: printing Table
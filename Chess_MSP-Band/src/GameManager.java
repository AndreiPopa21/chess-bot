import java.util.ArrayList;

public final class GameManager{
    
    private static Table currTable = null;
    private static Color currPlayer;


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
            return validateSpecialMove(move);
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





    //public static ArrayList<Record> history;

    public static void record(Move move){
        // o scrie in vector

        //history.add()
    }

    // class Record{ Move move; String movedPiece;}

    







    // (..) -



    // en=passsant



    public static boolean validateSpecialMove(Move move){

        if(move.moveType == Constants.WHITE_KING_SIDE_CASTLING){

            System.out.println("[GameManager] Se evalueaza white king-side castling");

            Square e1 = getTable().getSquares().get(Constants.E1);
            Square f1 = getTable().getSquares().get(Constants.F1);
            Square g1 = getTable().getSquares().get(Constants.G1);
            Square h1 = getTable().getSquares().get(Constants.H1);
            
            //(TODO) searchHistoryFor('K');

            if(e1.hasPiece()){
                if(!e1.getPiece().getName().equals('K')){
                    return false;
                }
            }else{
                return false;
            }

            if(h1.hasPiece()){
                if(!h1.getPiece().getName().equals('R')){
                    return false;
                }
            }else{
                return false;
            }

            if(f1.hasPiece() || g1.hasPiece()) return false;

            if(getTable().isKingChecked(Color.WHITE)) return false;

            Move checkMove = new Move(Constants.E1,Constants.F1,0);
            getTable().applyMove(checkMove);
            if(getTable().isKingChecked(Color.WHITE)){
                getTable().undoMove(checkMove, null);
                return false;
            }
            getTable().undoMove(checkMove, null);

            checkMove = new Move(Constants.E1,Constants.G1,0);
            getTable().applyMove(checkMove);
            if(getTable().isKingChecked(Color.WHITE)){
                getTable().undoMove(move, null);
                return false;
            }
            getTable().undoMove(checkMove, null);

            return true;
        }

        if(move.moveType == Constants.WHITE_QUEEN_SIDE_CASTLING){
            System.out.println("[GameManager] Se evalueaza white queen-side castling");
            
            return true;

        }

        if(move.moveType == Constants.BLACK_KING_SIDE_CASTLING){

            System.out.println("[GameManager] Se evalueaza black king-side castling");

            Square e8 = getTable().getSquares().get(Constants.E8);
            Square f8 = getTable().getSquares().get(Constants.F8);
            Square g8 = getTable().getSquares().get(Constants.G8);
            Square h8 = getTable().getSquares().get(Constants.H8);

            if(e8.hasPiece()){
                if(!e8.getPiece().getName().equals('k')){
                    return false;
                }
            }else{
                return false;
            }

            if(h8.hasPiece()){
                if(!h8.getPiece().getName().equals('r')){
                    return false;
                }
            }else{
                return false;
            }

            if(f8.hasPiece() || g8.hasPiece()) return false;

            if(getTable().isKingChecked(Color.BLACK)) return false;

            Move checkMove = new Move(Constants.E8,Constants.F8,0);
            getTable().applyMove(checkMove);
            if(getTable().isKingChecked(Color.BLACK)){
                getTable().undoMove(checkMove, null);
                return false;
            }

            checkMove = new Move(Constants.E8,Constants.G8,0);
            getTable().applyMove(checkMove);
            if(getTable().isKingChecked(Color.BLACK)){
                getTable().undoMove(move, null);
                return false;
            }

            return true;
        }

        if(move.moveType == Constants.BLACK_QUEEN_SIDE_CASTLING){

            System.out.println("[GameManager] Se evalueaza black queen-side castling");

            return true;
        }

        return true;
    }

}





//PASSED: instantiating new Table
//PASSED: printing Table
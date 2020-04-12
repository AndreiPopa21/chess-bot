import java.util.ArrayList;

public class Bishop extends Piece {

    public int[] rowOff = new int[]{-1,-1,1,1};
    public int[] colOff = new int[]{10,-10,-10,10};

    
    public Bishop(Color color, Table table){
        this.setColor(color);
        this.setTable(table);
        this.setName(color==Color.WHITE? 'B' : 'b');
        this.setValue(Constants.BISHOP_VALUE);
    }

    private void recursiveSearch(int src, int off, int increment, ArrayList<Move> moves){
        int next = src + (rowOff[off] + colOff[off]) * increment;
        Square nextSq = getTable().getSquares().get(next);

        if(nextSq == null) return;

        if(!nextSq.hasPiece()){
            moves.add(new Move(src,next,null));
            recursiveSearch(src, off, increment + 1, moves);
            return;
        }

        if(nextSq.getPiece().getColor() == this.getColor()) {
            return;
        }

        moves.add(new Move(src, next, null));
    }

    public ArrayList<Move> searchMoves(int src){

        ArrayList<Move> moves = new ArrayList<Move>();

        if(this.getTable().isKingChecked()){
            return moves;
        }

        for(int i = 0; i < rowOff.length; i++) {
            recursiveSearch(src, i, 1, moves);
        }

        ArrayList<Move> finalMoves = new ArrayList<>();

        for(int i = 0; i < moves.size(); i++){
            Move move = moves.get(i);
            if(!getTable().isKingBinded(move))
                finalMoves.add(move);
        }

        return finalMoves;
    }
    
    private boolean recursiveCheck(int src, int dest, int off, int increment){
        
        int next = src + (rowOff[off] + colOff[off]) * increment;
        Square nextSq = getTable().getSquares().get(next);

        if(nextSq == null) return false;

        if(next == dest) return true;

        if(nextSq.hasPiece()) return false;

        return recursiveCheck(src, dest, off, increment + 1);
    }

    public boolean isChecking(int src, int king){
        for(int i = 0; i < rowOff.length; i++){
            boolean result = recursiveCheck(src, king, i, 1);
            if(result) return true;
        }
        return false;
    }
}

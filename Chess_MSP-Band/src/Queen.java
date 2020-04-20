import java.util.ArrayList;

public class Queen extends Piece {

    public int[] rowOff = new int[]{-1,-1,0,1,1,1,0,-1};
    public int[] colOff = new int[]{0,-10,-10,-10,0,10,10,10};

    public Queen(Color color, Table table){
        this.setColor(color);
        this.setTable(table);
        this.setName(color==Color.WHITE? 'Q' : 'q');
        this.setValue(Constants.QUEEN_VALUE);
    }

    private void recursiveSeach(int src, int off, int increment, ArrayList<Move> moves){
      
        int next = src + (rowOff[off] + colOff[off])*increment;
        Square nextSq = getTable().getSquares().get(next);

        if(nextSq == null) return;

        if(!nextSq.hasPiece()){
            moves.add(new Move(src,next,0));
            recursiveSeach(src, off, increment+1, moves);
            return;
        }

        if(nextSq.getPiece().getColor() == this.getColor()){
            return;
        }

        moves.add(new Move(src,next,0));
    }

    public ArrayList<Move> searchMoves(int src){
        
        ArrayList<Move> moves = new ArrayList<>();

        for(int i = 0; i < rowOff.length; i++){
            recursiveSeach(src, i, 1, moves);
        }
        
        ArrayList<Move> finalMoves = new ArrayList<>();
        
        for(int i = 0; i < moves.size(); i++){
            Move move = moves.get(i);
            if(!getTable().isKingBinded(move, this.getColor())){
                finalMoves.add(move);
            }else{
               // System.out.println("[Queen] Cannot perform " + move.toString() + " because king bounded");
            }
                
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

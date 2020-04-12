import java.util.ArrayList;

public class Rook extends Piece {
    
    public int[] rowOff = new int[]{-1,0,1,0};
    public int[] colOff = new int[]{0,-10,0,10};


    public Rook(Color color, Table table){
        this.setColor(color);
        this.setTable(table);
        this.setName(color==Color.WHITE? 'R' : 'r');
        this.setValue(Constants.ROOK_VALUE);
    }

    private void recursiveSeach(int src, int off, int increment, ArrayList<Move> moves){
      
        int next = src + (rowOff[off] + colOff[off])*increment;
        Square nextSq = getTable().getSquares().get(next);

        if(nextSq == null) return;

        if(!nextSq.hasPiece()){
            moves.add(new Move(src,next,null));
            recursiveSeach(src, off, increment+1, moves);
            return;
        }

        if(nextSq.getPiece().getColor() == this.getColor()){
            return;
        }

        moves.add(new Move(src,next,null));
    }

    public ArrayList<Move> searchMoves(int src){
        
        ArrayList<Move> moves = new ArrayList<Move>();

        if(this.getTable().isKingChecked()){
            return moves;
        }

        if(this.getTable().isKingBinded(src, this.getColor())) {
            return moves;
        }

        for(int i = 0; i < rowOff.length; i++){
            recursiveSeach(src, i, 1, moves);
        }

        return moves;
    }

}

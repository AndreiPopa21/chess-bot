import java.util.ArrayList;

public class Knight extends Piece {

    public static int[] rowOff = new int[]{-2,-2,-1,1,2,2,1,-1};
    public static int[] colOff = new int[]{10,-10,-20,-20,-10,10,20,20};


    public Knight(Color color, Table table){
        this.setColor(color);
        this.setName(color==Color.WHITE? 'N' : 'n');
        this.setTable(table);
        this.setValue(Constants.KNIGHT_VALUE);
    }

    @Override
    public ArrayList<Move> searchMoves(int src) {

        ArrayList<Move> moves = new ArrayList<>();

        // e foarte important de verificat daca o piesa, odata mutata,
        // lasa regele descoperit pentru un sah
        if(this.getTable().isKingBinded(src, this.getColor())) {
            return moves;
        }

        for(int i = 0; i < rowOff.length; i++){
            int next = src + rowOff[i] + colOff[i];

            Square sq = getTable().getSquares().get(next);
            
            if(sq == null) {
                // se verifica daca e vreun patrat invalid
                continue;
            }
            
            if(this.getColor() == sq.getPiece().getColor()) {
                // se verifica daca mi-am gasit un coechipier
                continue;
            }
            
            if(isKing(sq.getPiece())) {
                // se verifica daca pe patrat sta un rege
                continue;
            }

            moves.add(new Move(src,next, null));
        }

        return moves;
    }

}

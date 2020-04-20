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

        for(int i = 0; i < rowOff.length; i++){
            int next = src + rowOff[i] + colOff[i];

            Square sq = getTable().getSquares().get(next);
            
            // se verifica daca e vreun patrat invalid
            if(sq == null) continue;
            
            if(sq.hasPiece()){
                if(sq.getPiece().getColor() == this.getColor()){
                    continue;
                }else{
                    moves.add(new Move(src,next,0));
                }
            }else{
                moves.add(new Move(src,next,0));
            }
        }

        ArrayList<Move> finalMoves = new ArrayList<>();

        for(int i = 0; i < moves.size(); i++){
            Move move = moves.get(i);
            if(!getTable().isKingBinded(move, this.getColor())){
                finalMoves.add(move);
            }else{
             //   System.out.println("[Knight] Cannot perform " + move.toString() + " because king bounded");
            }
        }

        return finalMoves;
    }

    public boolean isChecking(int src, int king){
        for(int i = 0; i < rowOff.length; i++){
            int next = src + rowOff[i] + colOff[i];
            if(next == king) return true;
        }
        return false;
    }

}

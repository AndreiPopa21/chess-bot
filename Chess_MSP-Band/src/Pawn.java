import java.util.ArrayList;

public class Pawn extends Piece {

    public Pawn(Color color, Table table){
        this.setColor(color);       
        this.setTable(table);
        this.setName(color==Color.WHITE? 'P' : 'p');
        this.setValue(Constants.PAWN_VALUE);
    }


    public ArrayList<Move> searchMoves(int src){
        ArrayList<Move> moves = new ArrayList<>();

        if(this.getTable().isKingChecked()){
            return moves;
        }

        int front = src + 1;
        int attackLeft = src - 9;
        int attackRight = src + 11;

        Square frontSq = getTable().getSquares().get(front);
        Square leftSq = getTable().getSquares().get(attackLeft);
        Square rightSq = getTable().getSquares().get(attackRight);

        if(frontSq != null){
            if(!frontSq.hasPiece()){
                moves.add(new Move(src,front,null));
            }
        }
        if(leftSq != null){
            if(leftSq.hasPiece()){
                if(leftSq.getPiece().getColor() != this.getColor()){
                    moves.add(new Move(src,attackLeft,null));
                }
            }
        }

        if(leftSq != null){
            if(leftSq.hasPiece()){
                if(leftSq.getPiece().getColor() != this.getColor()){
                    moves.add(new Move(src,attackLeft,null));
                }
            }
        }

        ArrayList<Move> finalMoves = new ArrayList<>();

        for(int i = 0; i < moves.size(); i++){
            Move move = moves.get(i);
            if(!getTable().isKingBinded(move)){
                finalMoves.add(move);
            }
        }

        return finalMoves;
    }

    public boolean isChecking(int src, int king){
        int attackRight = src + 11;
        int attackLeft = src - 9;

        if(king == attackLeft) return true;
        if(king == attackRight) return true;

        return false;
    }

}
